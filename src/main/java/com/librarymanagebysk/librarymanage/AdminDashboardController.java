package com.librarymanagebysk.librarymanage;

import com.librarymanagebysk.librarymanage.Database.BookDB;
import com.librarymanagebysk.librarymanage.Database.IssueBook;
import com.librarymanagebysk.librarymanage.Database.StudentBookDB;
import com.librarymanagebysk.librarymanage.Database.StudentDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {
    public LibManager libManager;

    @FXML
    public TextField bookSearch;
    @FXML
    public TextArea showBookDetails;
    @FXML
    public TextField bookID;
    @FXML
    public TextField bookName;
    @FXML
    public TextField writerName;
    @FXML
    public TextField bookPrice;

    @FXML
    public TextField bookQuantity;
    public TextField stdID;
    public TextField studentFees;
    public TextField stdName;
    public TextField bookTaken;
    public TextField studentIDforDetails;
    public TextArea detailsLabel;

    @FXML
    ImageView booksSearchImg;
    @FXML
    ImageView addBooksImg;

    // Book Issue section
    @FXML
    public TextField stdIdForDetails;
    public TextArea showDetails;
    public TextField stdIdForBook;
    public TextField BookID_1;
    public TextField BookID_2;
    public TextField BookID_3;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        booksSearchImg.setImage(new Image("file:src/main/java/com/librarymanagebysk/librarymanage/images/searching.png"));
        addBooksImg.setImage(new Image("file:src/main/java/com/librarymanagebysk/librarymanage/images/book.png"));
    }

    public void addBookButton(ActionEvent actionEvent) {
        try {
            String name = bookName.getText();
            String id = bookID.getText();
            String wName = writerName.getText();
            int price = Integer.parseInt(bookPrice.getText());
            int quantity = Integer.parseInt(bookQuantity.getText());

            Book book = new Book(id, name, wName, price, quantity);
            // insert to DB and show alert
            boolean check = BookDB.InsertToDB(book);
            if (check) {
                //show alert
                libManager.conformationAlert();
            } else {
                libManager.alreadyExists();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchButton(ActionEvent actionEvent) {
        String id = bookSearch.getText();

        showBookDetails.setText(BookDB.getInfo(id));

        if(BookDB.getInfo(id) == null){
            libManager.notFoundAlert();
        }
        else {
            libManager.foundAlert();
        }
    }

    public void cancelButton(ActionEvent actionEvent) {
        clearField();
    }

    public void adminStdSubmit(ActionEvent actionEvent) {
        //submit to database
        try {
            String id = stdID.getText();
            String name = stdName.getText();
            boolean bookTakenOrNot = Boolean.parseBoolean(bookTaken.getText());
            int fees = Integer.parseInt(studentFees.getText());
            //int quantity = Integer.parseInt(bookQuantity.getText());
            int quantity = 0;

            Student student = new Student(name, id, bookTakenOrNot, quantity, fees);
            boolean check = StudentDB.InsertToDB(student);
            if (check) {
                //show alert
                libManager.conformationAlert();
            } else {
                libManager.showAlert();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        clearField();
    }

    public void showDetailButton(ActionEvent actionEvent) {
        String id = studentIDforDetails.getText();

        detailsLabel.setText(StudentDB.getInfo(id));

        if(StudentDB.getInfo(id) == null){
            libManager.notFoundAlert();
        }
        else {
            libManager.foundAlert();
        }
    }

    public void clearField() {
        stdID.setText("");
        stdName.setText("");
        studentFees.setText("");
        bookQuantity.setText("");
        bookTaken.setText("");
    }

    // Book Issue section
    public void IssueShowDetailButton(ActionEvent actionEvent) {
        String id = stdIdForDetails.getText();

        showDetails.setText(StudentDB.getInfo(id));

        if(StudentDB.getInfo(id) == null){
            libManager.notFoundAlert();
        }
        else {
            libManager.foundAlert();
        }
    }

    public void IssueBookToStudent(ActionEvent actionEvent) {
        try {
            String stdID = stdIdForBook.getText();
            String book_1 = BookID_1.getText();
            String book_2 = BookID_2.getText();
            String book_3 = BookID_3.getText();

            IssueBook issueBook = new IssueBook(stdID, book_1, book_2, book_3);

            boolean check = StudentBookDB.InsertToDB(issueBook);
            if (check) {
                //show alert
                libManager.conformationAlert();
            } else {
                libManager.showAlert();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        clearField();
    }

    public void setLibManager(LibManager libManager) {
        this.libManager = libManager;
    }
}
