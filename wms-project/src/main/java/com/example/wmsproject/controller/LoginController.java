package com.example.wmsproject.controller;

import com.example.wmsproject.model.Admin;
import com.example.wmsproject.model.Worker;
import com.example.wmsproject.utils.enums.LoginResponseType;
import com.example.wmsproject.utils.functions.Functions;
import com.example.wmsproject.service.Service;
import com.example.wmsproject.utils.responses.LoginResponse;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController implements Controller {
    public Label addedText;
    public TextField usernameText;
    public PasswordField passwordText;

    private Service service;

    @Override
    public void update() {}

    public void setService(Service service) {
        this.service = service;
        service.addObserver(this);
    }

    public void onLoginButtonClick() throws IOException {
        String username = usernameText.getText();
        String password = passwordText.getText();

        LoginResponse loginResponse = service.login(username, password);
        if (loginResponse.getType() == LoginResponseType.FAILED) {
            addedText.setText("Credentials are invalid");
        } else if (loginResponse.getType() == LoginResponseType.ADMIN) {
            Stage stage = new Stage();
            Controller ctrl = Functions.fxmlLoad(stage, "/com/example/wmsproject/admin-window.fxml");
            ctrl.setService(service);
            ((AdminController) ctrl).loggedAdmin = (Admin) loginResponse.getBody();
            closeWindow();
        } else if (loginResponse.getType() == LoginResponseType.WORKER) {
            Stage stage = new Stage();
            Controller ctrl = Functions.fxmlLoad(stage, "/com/example/wmsproject/worker-window.fxml");
            Worker worker = (Worker) loginResponse.getBody();
            ctrl.setService(service);
            ((WorkerController) ctrl).setLoggedWorker(worker);
            service.startWorking(worker.getId());
            stage.onCloseRequestProperty().setValue(event -> service.stopWorking(worker.getId()));
            closeWindow();
        }
    }

    private void closeWindow() {
        service.removeObserver(this);
        Stage stage = (Stage) addedText.getScene().getWindow();
        stage.close();
    }
}
