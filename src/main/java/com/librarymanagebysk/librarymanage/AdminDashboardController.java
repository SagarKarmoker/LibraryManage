package com.librarymanagebysk.librarymanage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {
    public LibManager libManager;

    @FXML
    ImageView booksSearchImg;
    @FXML
    ImageView addBooksImg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        booksSearchImg.setImage(new Image("file:src/main/java/com/librarymanagebysk/librarymanage/images/searching.png"));
        addBooksImg.setImage(new Image("file:src/main/java/com/librarymanagebysk/librarymanage/images/book.png"));
    }


    public void setLibManager(LibManager libManager) {
        this.libManager = libManager;
    }
}
