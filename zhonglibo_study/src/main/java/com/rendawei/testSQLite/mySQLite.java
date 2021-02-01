package com.rendawei.testSQLite;

import java.sql.*;


public class mySQLite {

  private static final String className = "org.sqlite.JDBC";
  private static final String DB_url = "jdbc:sqlite:D:\\study\\dbs\\Databases\\test.db";


  public static Connection createConnection() throws SQLException, ClassNotFoundException {
    Class.forName(className);
    return DriverManager.getConnection(DB_url);
  }

  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    Connection connection = createConnection();
    Statement statement = connection.createStatement();

    // 新增数据
    statement.executeUpdate("insert into student values('zhou1',18)");
    statement.executeUpdate("insert into student values('zhou1',19)");
    statement.executeUpdate("insert into student values('zhou1',18)");
    statement.executeUpdate("insert into student values('zhou1',17)");

    // 遍历表
    ResultSet rs = statement.executeQuery("select * from student");
    System.out.println();

    while (rs.next()){
      System.out.println(rs.getString("name") + " " +  rs.getString("age"));
    }

    statement.executeUpdate("DELETE FROM student WHERE age = 18");
    connection.close();

  }


}



