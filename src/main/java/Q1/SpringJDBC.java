package Q1;

import java.sql.*;
import java.util.Properties;

public class SpringJDBC {

    public static void main(String[] args) throws Exception {
        preparedStatment1();
        preparedStatment2();
        preparedStatment3();
        preparedStatment4();
    }

    //question1
    public static Connection getConnection1() throws ClassNotFoundException, SQLException {
        String driverName = "com.mysql.jdbc.Driver";
        Class.forName(driverName); //This will load the class at runtime
        String connectionString = "jdbc:mysql://localhost:3306/spring_demo";
        return DriverManager.getConnection(connectionString, "root", "igdefault");
    }

    //question1
    static void preparedStatment1() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getConnection1().prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
        }

    }

    //question 2
    private static Connection getConnection2() throws Exception {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        String connectionString = "jdbc:mysql://localhost:3306/spring_demo";
        return DriverManager.getConnection(connectionString, "root", "igdefault");

    }

    //question2
    private static void preparedStatment2() throws Exception {
        PreparedStatement preparedStatement = getConnection2().prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
        }

    }

    //question 3
    private static Connection getConnection3() throws Exception {
        java.sql.Driver driver = new com.mysql.jdbc.Driver();
        Properties dbProp = new Properties();
        dbProp.put("user", "root");
        dbProp.put("password", "igdefault");
        return driver.connect("jdbc:mysql://localhost:3306/spring_demo", dbProp);
    }

    private static void preparedStatment3() throws Exception {
        PreparedStatement preparedStatement = getConnection3().prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
        }

    }

    //question 4
    private static Connection getConnection4() throws Exception {
        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
        Properties dbProp = new Properties();
        dbProp.put("user", "root");
        dbProp.put("password", "root");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_data_bootcamp", dbProp);
    }

    private static void preparedStatment4() throws Exception {
        PreparedStatement preparedStatement = getConnection3().prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
        }

    }
}
