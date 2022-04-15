module com.example.ctrempleados {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens com.example.ctrempleados to javafx.fxml;
    exports com.example.ctrempleados;
}