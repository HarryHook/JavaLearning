package com.nowcoder.forjob.thoughtworks.services;

import com.nowcoder.forjob.thoughtworks.Domain.Position;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlotService {

    public static List<Position> start(String filePath) {
        List<String> lines = readText(filePath);
        List<Position> results = new ArrayList<>();
        if (lines != null && !lines.isEmpty()) {
            int signalIndex = 0;
            Position position = null;
            for (signalIndex = 0; signalIndex < lines.size(); signalIndex++) {
                String line = lines.get(signalIndex);
                String[] split = line.split("\\s+");
                if (signalIndex == 0 && split.length == 4) {
                    try {
                        //first Position
                        //先判断无人机Id是否符合要求
                        String regx = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]+$";
                        if (split[0].matches(regx)) {
                            position = new Position(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
                            results.add(position);
                        } else {
                            results.add(Position.getErrorPos());
                        }
                    } catch (NumberFormatException e) {
                        results.add(Position.getErrorPos());
                    }
                } else if (split.length == 7) {
                    //next position
                    try {
                        //之后的位置
                        //需要将当前数据与上一条数据进行比对判断
                        String[] plotCur = {split[0], split[1], split[2], split[3]};
                        boolean isRightPos = checkPosition(results.get(signalIndex - 1), plotCur);
                        if (!isRightPos) {
                            results.add(Position.getErrorPos());
                        } else {
                            position = new Position(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]),
                                    Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]));
                            results.add(position);
                        }
                    } catch (NumberFormatException e) {
                        results.add(Position.getErrorPos());
                    }

                } else {
                    //error position
                    results.add(Position.getErrorPos());

                }
            }
        }
        return results;
    }

    private static boolean checkPosition(Position positionPre, String[] plotCur) {
        if (Position.isErrorPos(positionPre)) {
            return false;
        }
        if (positionPre.getId().equals(plotCur[0]) &&
                positionPre.getX() == Integer.parseInt(plotCur[1]) &&
                positionPre.getY() == Integer.parseInt(plotCur[2]) &&
                positionPre.getZ() == Integer.parseInt(plotCur[3])) {
            return true;
        }
        return false;
    }

    public static List<String> readText(String filePath) {
        Path path = Paths.get(filePath);
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(path, Charset.forName("utf-8"));
        } catch (IOException e) {
            System.err.println("该路径下没有文件， 请重新查找！");
            System.exit(1);
        }
        return lines;
    }
}
