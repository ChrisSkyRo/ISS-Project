package com.example.wmsproject.controller;

import com.example.wmsproject.HelloApplication;
import com.example.wmsproject.service.Service;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController implements Controller{
    private Service service;

    @Override
    public void setService(Service service) {
        this.service = service;
        service.addObserver(this);
    }

    @Override
    public void update() {}

    public void newWindowClicked() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/wmsproject/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        LoginController controller = fxmlLoader.getController();
        controller.setService(service);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
