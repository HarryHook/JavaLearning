package com.nowcoder.forjob.sohu;

import java.util.Scanner;

public class FindMaxNum {

    public static String fun(String num){
        String max = "";
        int len = num.length();
        for(int i=0;i<len-1;i++){
            if(num.charAt(i)<num.charAt(i+1)){
                max = num.substring(0,i)+num.substring(i+1);
                break;
            }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String num = sc.nextLine();
            int cnt = sc.nextInt();

            for(int i=0;i<cnt;i++){
                num = fun(num);
            }
            System.out.println(num);
        }
    }
}
