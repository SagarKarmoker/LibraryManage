package com.librarymanagebysk.librarymanage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class LibController implements Initializable {
    public LibManager libManager;

    @FXML
    ImageView imgButton;
    @FXML
    ImageView uname;
    @FXML
    ImageView pass;
    @FXML
    ImageView loginHead;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginHead.setImage(new Image("file:src/main/java/com/librarymanagebysk/librarymanage/images/login_head.png"));
        uname.setImage(new Image("file:src/main/java/com/librarymanagebysk/librarymanage/images/user.png"));
        pass.setImage(new Image("file:src/main/java/com/librarymanagebysk/librarymanage/images/password.png"));
        imgButton.setImage(new Image("file:src/main/java/com/librarymanagebysk/librarymanage/images/login.png"));
    }

    public void addButton(MouseEvent mouseEvent) {
        System.out.println("worked");
    }

    public void setLibManager(LibManager libManager) {
        this.libManager = libManager;
    }
}
