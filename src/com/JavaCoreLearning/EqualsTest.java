package com.JavaCoreLearning;


public class EqualsTest {
    
    public static void main(String[] args) {
	
	Employee alice1 = new Employee("Alice Adams", 75000, 1993, 10, 1);
	Employee alice2 = alice1;
	Employee alice3 = new Employee("Alice Adams", 75000, 1993, 10, 1);
	Employee bob = new Employee("Bob Brandson", 50000, 1989, 12, 15);
	
	System.out.println("alice1 == alice2: " + (alice1 == alice2));
	System.out.println("alice1.equals(alice2): " + (alice1.equals(alice2)));
	System.out.println("alice1 == alice3: " + (alice1 == alice3));
	System.out.println("alice1.equals(alice3): " + (alice1.equals(alice3)));
	System.out.println("alice1.equals(bob): " + (alice1.equals(bob)));
	System.out.println("bob.toString: " + bob);
	
	Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
	Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
	boss.setBonus(5000);
	System.out.println("boss.toString: " + boss.toString());
	System.out.println("carl.equals(boss): " + (carl.equals(boss)));
	System.out.println("alice1.hashCode():" + alice1.hashCode());
	System.out.println("alice3.hashCode():" + alice3.hashCode());
	System.out.println("bob.hashCode():" + bob.hashCode());
	System.out.println("carl.hashCode():" + carl.hashCode());

    }
}

