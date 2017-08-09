package src.com.imooc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc";
    private static final String USER = "root";
    private static final String PASSWORD = "123";
    
    public static void main(String[] args)throws Exception {
	//1.加载驱动程序
	Class.forName("com.mysql.jdbc.Driver");
	//2.获得数据库连接
	Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	//3.操纵数据库，实现CURD
	Statement statement = conn.createStatement();
	ResultSet res = statement.executeQuery("SELECT user_name, age  FROM imooc_goddess");
	while(res.next()) {
	    System.out.println(res.getString("user_name") + "," + res.getInt("age"));
	}
    }

}
