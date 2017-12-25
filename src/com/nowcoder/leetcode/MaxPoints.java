package com.nowcoder.leetcode;

import java.util.HashMap;
import java.util.Map;

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class MaxPoints {
    public static int maxPoints(Point[] points) {
        if (points.length < 2) {
            return points.length;
        }
        int size = points.length;
        int result = 0;
        for (int i = 0; i < size; i++) {
            int vcount = 0;  //垂直点
            int dupCount = 0; //重复点
            int curMax = 1;  //当前含有最多点的数量
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    double x = points[i].x - points[j].x;
                    double y = points[i].y - points[j].y;

                    if (x == 0 && y == 0) {  //重复点
                        dupCount++;
                    } else if (x == 0) {  //垂直点
                        if (vcount == 0) {
                            vcount = 2;
                        } else {
                            vcount++;
                        }
                        curMax = Math.max(curMax, vcount);
                    } else {  //在斜率为k的线上的点
                        double k = y / x;
                        if (map.containsKey(k)) {
                            map.put(k, map.get(k) + 1);
                        } else {
                            map.put(k, 2);
                        }
                        curMax = Math.max(curMax, map.get(k));
                    }
                }
            }
            result = Math.max(result, curMax + dupCount);
        }
        return result;
    }

    public static void main(String[] args) {

        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);

        Point[] points = {p1, p2};
        System.out.println(maxPoints(points));
    }
}


