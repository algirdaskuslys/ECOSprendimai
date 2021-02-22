package sample.controller;


import javafx.application.Platform;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

import sample.Main;
import sample.utils.Constants;
import sample.utils.Validation;

import java.awt.event.ActionEvent;


public class RegisterController extends Main {

    public Button register_button;
    public Label form_info_label;
    public TextField username_textfield;
    public PasswordField password_passwordfield;
    public TextField email_textfield;
    public Label form_info_label_2;

    public void register() {
        if (Validation.isValidUsername(username_textfield.getText())
                && Validation.isValidPassword(password_passwordfield.getText())
                && Validation.isValidEmail(email_textfield.getText())) {
            goToLogin();
        } else {
            form_info_label.setText("");
            form_info_label.setStyle("-fx-text-fill: red;");
            form_info_label.setText("Neteisingai įvesti prisijungimo duomenys");
        }
    }
    public void closeRegister() { //Uzdaro prisijungimo langa
        Stage stage = (Stage) register_button.getScene().getWindow();
        stage.close();
    }

    public void goToLogin(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Constants.LOGIN_VIEW_DIRECTORY_PATH));
            Stage loginStage = new Stage();
            Scene scene = new Scene(root, Constants.LOGIN_REGISTER_WINDOW_WIDTH, Constants.LOGIN_REGISTER_WINDOW_HEIGHT);
            scene.getStylesheets().add(getClass().getResource(Constants.CSS_DIRECTORY_PATH).toExternalForm());
            loginStage.setTitle("Prisijungimas");
            loginStage.setScene(scene);
            loginStage.show();
            closeRegister();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
