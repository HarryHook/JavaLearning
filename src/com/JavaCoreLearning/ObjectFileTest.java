package com.JavaCoreLearning;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ObjectFileTest {
    public static void main(String[] args) {
	
	Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
	boss.setBonus(5000);
	
	Employee[] staff = new Employee[3];
	
	staff[0] = boss;
	staff[1] = new Employee("Carl Cracker", 75000, 1989, 10, 1);
	staff[2] = new Employee("Tony Tester", 38000, 1993, 3, 10);
	
	try {
	    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"));
	    out.writeObject(staff);
	    out.close();
		    
	    ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"));
	    Employee[] newStaff = (Employee[]) in.readObject();
	    in.close();
	    
	    for(Employee e : newStaff) {
		System.out.println(e);
	    }
	} catch(Exception e) {
	    e.printStackTrace();
	}
    }
}
