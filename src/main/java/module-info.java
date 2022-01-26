module com.librarymanagebysk.librarymanage {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.librarymanagebysk.librarymanage to javafx.fxml;
    exports com.librarymanagebysk.librarymanage;
}