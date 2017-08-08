package com.JavaCoreLearning.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {

    public static void main(String[] args) {
	HashMap<String, Employee> map = new HashMap<>();
	
	map.put("11123", new Employee("zhangsan"));
	map.put("1215", new Employee("wangwu"));
	map.put("51", new Employee("mazi"));
	System.out.println(map);
	map.remove("11123");
	System.out.println(map);
	map.put("31313", new Employee("lisi"));
	System.out.println(map);
	System.out.println(map.get("51"));
	for(Entry<String, Employee> entry: map.entrySet()) {
	    String key = entry.getKey();
	    Employee value = entry.getValue();
	    System.out.println("key: " + key + ",value: " +value);
	}
    }

}
class Employee {
    private String name;
    private double salary;
    public Employee(String n) {
	name = n;
	salary = 0;
    }
    public String toString() {
	return "[name:" + name + ", salary: " +salary+ "]";
    }
}