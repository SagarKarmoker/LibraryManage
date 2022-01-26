package com.librarymanagebysk.librarymanage.Database;

import com.librarymanagebysk.librarymanage.Book;

import java.sql.*;

public class BookDB {
    static Connection con;
    boolean flag = false;

    public static Connection create(){
        try {
            String url = "jdbc:mysql://localhost:3306/book_db";
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

    public static boolean InsertToDB(Book book) throws SQLException {
        //jdbc code here
        boolean flag = false;
        try {
            Connection connection = BookDB.create();
            String query = "INSERT INTO books(id,bookName,wName,price,quantity) VALUES(?,?,?,?,?)";
            // prepared connection
            PreparedStatement statement = connection.prepareStatement(query);
            // set the values of parameter
            statement.setString(1, book.getBookId());
            statement.setString(2, book.getBookName());
            statement.setString(3, book.getWriterName());
            statement.setInt(4, book.getPrice());
            statement.setInt(5, book.getQuantity());
            //execute
            if(getInfo(book.getBookId()) == null){
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
            String query = "select id,bookName,wName,price,quantity from books where id =?";

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            {
                preparedStatement.setString(1, id);
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet rs = preparedStatement.executeQuery();

                // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    String bookId = String.valueOf(rs.getInt("id"));
                    String bookName = rs.getString("bookName");
                    String writerName = rs.getString("wName");
                    String price = rs.getString("price");
                    String quantity = rs.getString("quantity");

                    send = "Book{" +
                            "bookId='" + bookId + '\'' +
                            ", bookName='" + bookName + '\'' +
                            ", writerName='" + writerName + '\'' +
                            ", price=" + price +
                            ", quantity=" + quantity +
                            '}';
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return send;
    }


}
