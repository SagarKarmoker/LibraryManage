module com.librarymanagebysk.librarymanage {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;


    opens com.librarymanagebysk.librarymanage to javafx.fxml;
    exports com.librarymanagebysk.librarymanage;
}