module javafx {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires MaterialFX;

    requires lombok;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires org.apache.logging.log4j;
    requires com.google.gson;

    exports ui;
    exports ui.controllers;

    opens domain.modelo to javafx.base, com.google.gson;
    opens ui.controllers to javafx.fxml;
    opens domain to javafx.base;
    opens config to com.fasterxml.jackson.databind, com.fasterxml.jackson.dataformat.yaml, org.apache.logging.log4j;
    opens dao to com.google.gson, org.apache.logging.log4j;

}
