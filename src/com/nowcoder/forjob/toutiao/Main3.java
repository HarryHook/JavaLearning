package com.nowcoder.forjob.toutiao;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        long[] room = new long[n];
        for (int i = 0; i < n; i++) {
            room[i] = sc.nextLong();
        }
        //最小的房间号，即被分配的房间
        int roomNo = minNo(room);
        //第i个房间与最后被分配的房间需要循环多少次
        long loopTimes = loopTimes(room[roomNo], n, roomNo, x - 1);
        int index = x - 1;
        long origin = loopTimes;
        while (loopTimes > 0) {
            room[index]--;
            if (index == 0) {
                index = n;
            }
            index--;
            loopTimes--;
        }
        room[roomNo] = origin;
        for (int i = 0; i < n - 1; i++) {
            System.out.print(room[i] + " ");
        }
        System.out.print(room[n - 1]);

    }

    /**
     * 根据第i个房间的人数和最后一次人数分配在哪个房间确定循环了多少次
     */
    private static long loopTimes(long roomNo, int n, int iRoom, int lastRoom) {
        long ps = 0;
        if (iRoom == lastRoom) {
            ps = n * roomNo;
        } else {
            ps = n * roomNo;
            ps += (lastRoom < iRoom) ? (lastRoom + n - iRoom) : (lastRoom - iRoom);
        }
        return ps;
    }

    private static int minNo(long[] room) {
        int min = 0;
        for (int i = 1; i < room.length; i++) {
            if (room[i] < room[min]) {
                min = i;
            }
        }
        return min;
    }
}
