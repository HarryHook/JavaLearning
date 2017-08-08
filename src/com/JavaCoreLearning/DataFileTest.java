package com.JavaCoreLearning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DataFileTest {

    public static void main(String[] args) {
	Employee[] staff = new Employee[3];
	staff[0] = new Employee("Harry Hacker", 35000, 1987, 12, 15);
	staff[1] = new Employee("Carl Cracker", 75000, 1989, 10, 1);
	staff[2] = new Employee("Tony Tester", 38000, 1993, 3, 10);
	try {
	    PrintWriter out = new PrintWriter(new FileWriter("employee.dat"));
	    writeData(staff, out);
	    out.close();
		    
	    BufferedReader in = new BufferedReader(new FileReader("employee.dat"));
	    Employee[] newStaff = readData(in);
	    in.close();
	    
	    for(Employee e : newStaff) {
		System.out.println(e);
	    }
	} catch(IOException e) {
	    e.printStackTrace();
	}
    }

    static void writeData(Employee[] staff, PrintWriter out) throws IOException {
	out.println(staff.length);
	for(Employee e : staff) {
	    e.writeData(out);
	}
    }
    static Employee[] readData(BufferedReader in) throws IOException {
	int n = Integer.parseInt(in.readLine());
	Employee[] employees = new Employee[n];
	for(int i=0; i<n; i++) {
	    employees[i] = new Employee();
	    employees[i].readData(in);
	}
	return employees;
    }

    

}
