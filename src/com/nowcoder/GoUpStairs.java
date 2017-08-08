package com.nowcoder;

public class GoUpStairs {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	GoUpStairs t = new GoUpStairs();
	System.out.println(t.countWays(5));
    }
    public int countWays(int n) {
        // write code here
        //思路：最后一阶台阶可能是前一节跨1步， 前两节跨两步， 前三节跨3步
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;
        for(int i=3; i<n; i++) {
            /*
             * a[i-1]+a[i-2])%1000000007就相当于(a[i-1]%X+a[i-2]%X)%X 
             */
            a[i]=((a[i-1]+a[i-2])%1000000007+a[i-3])%1000000007;
        }
        return a[n-1];
    }

}
