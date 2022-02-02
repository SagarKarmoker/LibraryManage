package com.librarymanagebysk.librarymanage.Database;

import com.librarymanagebysk.librarymanage.Student;

import java.sql.*;

public class StudentBookDB {
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

    public static boolean InsertToDB(IssueBook ids) throws SQLException {
        //jdbc code here
        boolean flag = false;
        try {
            Connection connection = StudentBookDB.create();
            String query = "INSERT INTO stdBookDB(id, bookID1, bookID2, bookID3) VALUES(?,?,?,?)";
            // prepared connection
            PreparedStatement statement = connection.prepareStatement(query);
            // set the values of parameter
            statement.setString(1, ids.getId());
            statement.setString(2, ids.getBookId1());
            statement.setString(3, ids.getBookId2());
            statement.setString(4, ids.getBookId3());
            //execute
            if(getInfo(ids.getId()) == null){
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
            Connection connection = StudentDB.create();
            String query = "select id from stdBookDB where id =?";

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            {
                preparedStatement.setString(1, id);
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet rs = preparedStatement.executeQuery();

                // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    id = rs.getString("id");
                    String BookId1 = rs.getString("bookID1");
                    String BookId2 = rs.getString("bookID2");
                    String BookId3 = rs.getString("bookID3");

                    send =  "IssueBook{" +
                            "id='" + id + '\'' +
                            ", BookId1='" + BookId1 + '\'' +
                            ", BookId2='" + BookId2 + '\'' +
                            ", BookId3='" + BookId3 + '\'' +
                            '}';
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return send;
    }
}
