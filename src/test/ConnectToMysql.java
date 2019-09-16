package test;

import java.sql.*;

public class ConnectToMysql {
    public static void main(String[] args) throws SQLException {
        String userName = "codebind";
        String password = "fiker";

        String url = "jdbc;mysql;//localhost;264/employees?useSSL=false";
        String query= "select * from employees.employees_detail;";
        try {
            Class.forName("com.mysql.jdbc.Drive");
        } catch (ClassNotFoundException e) {
            System.out.println("check driver");
            e.printStackTrace();
        }
        //for connecting to jdbc
        Connection connection = DriverManager.getConnection(url,userName,password);
        /////////////statment
        Statement statement=connection.createStatement();

        //result for the statement

        ResultSet table = statement.executeQuery(query);

        while(table.next()){
            String value1=table.getString("name");
            String value2=table.getString("id");
            String value3=table.getString("salary");

            System.out.println(value1+" "+value2+" "+value3);
        }

       //Statement.close();
        //Connection.close();

    }
}
