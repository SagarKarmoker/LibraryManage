package com.librarymanagebysk.librarymanage.Database;

import com.librarymanagebysk.librarymanage.Book;
import com.librarymanagebysk.librarymanage.Student;

import java.sql.*;

public class StudentDB {
    static Connection con;
    boolean flag = false;

    public static Connection create(){
        try {
            String url = "jdbc:mysql://localhost:3306/student_db";
            String user = "root";
            String password = "root";
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create the connection
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static boolean InsertToDB(Student std) throws SQLException {
        //jdbc code here
        boolean flag = false;
        try {
            Connection connection = BookDB.create();
            String query = "INSERT INTO students(id,stdName,bookTaken,quantity,fees) VALUES(?,?,?,?,?)";
            // prepared connection
            PreparedStatement statement = connection.prepareStatement(query);
            // set the values of parameter
            statement.setString(1, std.getId());
            statement.setString(2, std.getName());
            statement.setBoolean(3, std.isBookTaken());
            statement.setInt(4, std.getQuantity());
            statement.setInt(5, std.getFees());
            //execute
            if(getInfo(std.getId()) == null){
                statement.executeUpdate();
                flag = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static String getInfo(String id) {
        String send = null;
        try {
            Connection connection = BookDB.create();
            String query = "select id,stdName,bookTaken,quantity,fees from students where id =?";

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            {
                preparedStatement.setString(1, id);
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet rs = preparedStatement.executeQuery();

                // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    String name = String.valueOf(rs.getInt("stdName"));
                    id = rs.getString("id");
                    boolean bookTaken = rs.getBoolean("bookTaken");
                    String fees = rs.getString("fees");
                    String quantity = rs.getString("quantity");

                    send =  "Student{" +
                            "name='" + name + '\'' +
                            ", id='" + id + '\'' +
                            ", bookTaken=" + bookTaken +
                            ", quantity=" + quantity +
                            ", fees=" + fees +
                            '}';
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return send;
    }
}
