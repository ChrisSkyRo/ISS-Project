module com.example.wmsproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires jakarta.persistence;
    requires jakarta.annotation;
    requires spring.data.jpa;
    requires jakarta.transaction;
    requires spring.beans;

    opens com.example.wmsproject to javafx.fxml;
    exports com.example.wmsproject;
}