package com.librarymanagebysk.librarymanage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LibManager extends Application {
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // write start code here
        stage = primaryStage;
        stage.getIcons().add(new Image("file:I:\\JavaFX Projects\\LibraryManage\\src\\main\\java\\com\\librarymanagebysk\\librarymanage\\library.png"));
        //loginPage();
        adminDash();
    }

    public void loginPage() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HomePage.fxml"));

        Parent root = loader.load();
        LibController libController = loader.getController();
        libController.setLibManager(this);

        stage.setTitle("Welcome To Library Management System");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    public void adminDash() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AdminDashboard.fxml"));

        Parent root = loader.load();
        AdminDashboardController dashboardController = loader.getController();
        dashboardController.setLibManager(this);

        stage.setTitle("Admin Dashboard");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }


    // alert section
    public void showAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("Username or pass is wrong\nPlease try again");
        alert.show();
    }
    public void conformationAlert(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Successful");
        alert.setContentText("Successfully Added to Database");
        alert.show();
    }
    public void alreadyExists(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setContentText("UserID already found at out Database");
        alert.show();
    }

    public void foundAlert(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Found on database");
        alert.setContentText("Successfully Found on database");
        alert.show();
    }

    public void notFoundAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("Not found on database Student ID is wrong\nPlease try again");
        alert.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
