package com.JavaCoreLearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

class Employee implements Comparable<Employee>, Cloneable {
    public Employee() {}
    public Employee(String n, double s, int year, int month, int day) {
	name = n;
	this.salary = s;
	GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
	this.hireDay = calendar.getTime();
    }
    
    public Employee(String n, double s) {
   	name = n;
   	this.salary = s;
    }
    
    public double getSalary() {
	return salary;
    }
    
    public String getName() {
	return name;
    }
     
    public Date getHireDay() {
	return hireDay;
    }
    public void setHireDay(int year, int month, int day) {
	GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
	this.hireDay = calendar.getTime();	
    }
    public String getDiscription() {
	return String.format("an employee with a salary of $%.2f", salary);
    }
    public void raiseSalary(double byPercent) {
	double raise = salary * byPercent / 100;
	salary += raise;
    }
    public int compareTo(Employee other) {
	if(this.salary < other.salary) {
	    return -1;
	}
	if(this.salary > other.salary) {
	    return 1;
	}
	return 0;
    }
    public void writeData(PrintWriter out) throws IOException {
	GregorianCalendar calendar = new GregorianCalendar();
	calendar.setTime(hireDay);
	out.println(name + "|" + salary + "|" + calendar.get(Calendar.YEAR) + "|"
 					      + (calendar.get(Calendar.MONTH) + 1) + "|"
					      + calendar.get(Calendar.DAY_OF_MONTH));
    }
    public void readData(BufferedReader in) throws IOException{
	String s = in.readLine();
	StringTokenizer t = new StringTokenizer(s, "|");
	name = t.nextToken();
	salary = Double.parseDouble(t.nextToken());
	int y = Integer.parseInt(t.nextToken());
	int m = Integer.parseInt(t.nextToken());
	int d = Integer.parseInt(t.nextToken());
	GregorianCalendar calendar = new GregorianCalendar(y, m -1 , d);
	hireDay = calendar.getTime();
	
    }
    public Employee clone() throws CloneNotSupportedException {
	Employee cloned = (Employee) super.clone();
	cloned.hireDay = (Date)hireDay.clone();
	return cloned;
    }
    
    public boolean equals(Object otherObject) {
	if(this == otherObject) return true;
	if(otherObject == null) return false;
	if(getClass() != otherObject.getClass()) return false;
	Employee other = (Employee) otherObject;
	
	return name.equals(other.name) &&
		salary == other.salary &&
		hireDay.equals(other.hireDay);

    }
    public int hashCode() {
	return 7 * name.hashCode() +
		11 * new Double(salary).hashCode() + 
		12 * hireDay.hashCode();
    }
    public String toString() {
	return getClass().getName() + 
		"[name = " + name + 
		", salary = " + salary + 
		", hireDay = " + hireDay + "]";
    }
    
    private String name;
    private Double salary;
    private Date hireDay;
    
    
    
}