package com.librarymanagebysk.librarymanage;

import com.librarymanagebysk.librarymanage.Database.BookDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    @FXML
    public Button searchButton;

    @FXML
    ImageView booksSearchImg;
    @FXML
    ImageView addBooksImg;


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

    public void setLibManager(LibManager libManager) {
        this.libManager = libManager;
    }
}
