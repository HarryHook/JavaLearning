package com.JavaCoreLearning.collection;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;



public class TreeSetTest {

    public static void main(String[] args) {
	SortedSet<Item> parts = new TreeSet<Item>();
	parts.add(new Item("zhangsan", 912));
	parts.add(new Item("wangwu", 2345));
	parts.add(new Item("lisi", 4567));
	System.out.println(parts);
	
	SortedSet<Item> sortByDescription = new TreeSet<Item>( 
		new Comparator<Item>() {
		    public int compare(Item a, Item b) {
			String descrA = a.getDescription();
			String descrB = b.getDescription();
			return descrA.compareTo(descrB);
		    }
	});
	sortByDescription.addAll(parts);
	System.out.println(sortByDescription);
    }

}
class Item implements Comparable<Item>{

    private String description;
    private int partNumber;

    public Item(String aDescription, int aPartNumber) {
	description = aDescription;
	partNumber = aPartNumber;
    }
    public String getDescription(){
	return description;
    }
    public String toString() {
	return "[description=" + description
		+", partNumber=" + partNumber + "]";
    }
    public boolean equals(Object otherObject) {
	if(this == otherObject) return true;
	if(otherObject == null) return false;
	if(getClass() != otherObject.getClass()) return false;
	Item other = (Item) otherObject;
	return description.equals(other.description) &&
		partNumber == other.partNumber;
    }
    public int hashCode(){ 
	return 12 * description.hashCode() + 17 * partNumber;
    }
    public int compareTo(Item other){
	return partNumber - other.partNumber;
    }
}