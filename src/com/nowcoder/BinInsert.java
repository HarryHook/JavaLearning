package com.nowcoder;


public class BinInsert {
    public static int binInsert(int n, int m, int j, int i) {
        // write code here
    	m = m << j;         
        return m|n;
    }
    public static void main(String[] args) {
	int i = binInsert(1024, 19, 2, 6);
	System.out.println(i);
    }
}