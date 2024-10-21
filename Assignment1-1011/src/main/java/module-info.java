module org.example.assignment11011 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.assignment11011 to javafx.fxml;
    exports org.example.assignment11011;
}