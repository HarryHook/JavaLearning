package com.nowcoder.training;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void print(int index, Object obj) {
        System.out.println(String.format("{%d}, %s", index, obj.toString()));
    }

    public static void demoCommon() {
        Random random = new Random();
        random.setSeed(1);
        for (int i = 0; i < 4; i++) {
            print(1, random.nextInt(100));
        }
        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
        print(2, list);
        Collections.shuffle(list);
        print(3, list);

        Date date = new Date();
        print(4, date);
        print(5, date.getTime());
        //计算未来时间星期几
        DateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        print(6, df.format(date));
        print(7, UUID.randomUUID());
    }


    public static void demoException() {
        try {
            print(1, "Hello");
//            int a = 2;
//            a = a / 0;
            String s = null;
            s.indexOf('a');
        } catch (NullPointerException e) {
            print(3, "NullPointerException");
        } catch (Exception e) {
            print(4, "Exception");
        } finally {
            print(2, "finally");
        }
    }

    public static void demoKeyValue() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            map.put(String.valueOf(i), String.valueOf(i * i));
        }
        print(1, map);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            print(2, entry.getKey() + ": " + entry.getValue());
        }
        print(3, map.keySet());
        print(4, map.values());
        print(5, map.containsKey("1"));
        print(6, map.containsValue("4"));
        map.replace("1", "A");
        print(7, map);
    }

    public static void demoSet() {
        Set<String> strSet = new HashSet<String>();
        for (int i = 0; i < 3; i++) {
            strSet.add(String.valueOf(i));
        }
        print(0, strSet);
        strSet.remove("1");
        print(1, strSet);
        print(2, strSet.contains("2"));
        strSet.addAll(Arrays.asList(new String[]{"A", "B", "c"}));
        print(3, strSet);
        print(4, strSet.size());
        print(5, strSet.isEmpty());
    }


    public static void main(String[] args) {

        String s = "Java";
        System.out.print(s);
        System.out.println("Hello Nowcoder！");
        print(1, "Hello, nowcoder!");
        demoSet();
        demoKeyValue();
        demoException();
        demoCommon();
    }

}
