package com.collection;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastTest {
//    private static List<String> list = new ArrayList<>();

    private static List<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        new ThreadTwo().start();
        new ThreadOne().start();
    }

    /**
     * 55      * 向list中依次添加10,11,12,13,14,15，每添加一个数之后，就通过printAll()遍历整个list
     * 56
     */
    private static class ThreadOne extends Thread {
        @Override
        public void run() {
            int i = 10;
            while (i < 16) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }

    /**
     * 41      * 向list中依次添加0,1,2,3,4,5，每添加一个数之后，就通过printAll()遍历整个list
     * 42
     */
    private static class ThreadTwo extends Thread {

        public void run() {
            int i = 0;
            while (i < 6) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }

    public static void printAll() {
        String value = null;
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            value = (String) iter.next();
            System.out.print(value + " ");
        }
    }
}
