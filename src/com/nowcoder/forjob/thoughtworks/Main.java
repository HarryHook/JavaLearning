package com.nowcoder.forjob.thoughtworks;

import com.nowcoder.forjob.thoughtworks.Domain.Position;
import com.nowcoder.forjob.thoughtworks.services.PlotService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "F:\\coding\\src\\com\\nowcoder\\forjob\\thoughtworks\\resources\\input.txt";
        if (args != null && args.length > 0) {
            filePath = args[0];
        }
        List<Position> res = PlotService.start(filePath);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int index = sc.nextInt();

            if (index > res.size() - 1) {
                System.out.println("Can not find " + index);
            } else {
                if (Position.isErrorPos(res.get(index))) {
                    System.out.println("Error: " + index);
                } else {
                    Position position = res.get(index);
                    System.out.println(position.getId() + " " + index + " " + position.getX() + " " + position.getY() + " " + position.getZ());
                }
            }
        }
    }
}
