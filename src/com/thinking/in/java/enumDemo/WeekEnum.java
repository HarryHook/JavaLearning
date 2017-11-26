package com.thinking.in.java.enumDemo;

public enum WeekEnum {
    // 因为已经定义了带参数的构造器，所以在列出枚举值时必须传入对应的参数
    //系统自动修饰为public static final类型的
    SUNDAY("星期日"), MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"),
    THURSDAY("星期四"), FRIDAY("星期五"), SATURDAY("星期六");

    // 定义一个 private 修饰的实例变量
    private String date;

    // 定义一个带参数的构造器，枚举类的构造器只能使用 private 修饰
    private WeekEnum(String date) {
        this.date = date;
    }

    // 定义 get set 方法
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static void main(String[] args) {
        System.out.println(SUNDAY.compareTo(MONDAY));
        System.out.println(MONDAY.compareTo(FRIDAY));

    }

}
