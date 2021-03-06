package sample.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.utils.Constants;
import sample.utils.Validation;

public class LoginController {

    public Button username_button;
    public Label login_info_label;
    public TextField username_textfield;
    public PasswordField password_passwordfield;
    public Button register_button;
    public Button dashboard_button;
    public Stage dashboardStage = new Stage();

    public void login() {
        if (Validation.isValidUsername(username_textfield.getText()) && Validation.isValidPassword(password_passwordfield.getText())) {
            login_info_label.setStyle("-fx-text-fill: green;");
            login_info_label.setText("Prisijungimo vardas : " + username_textfield.getText() + "\n Slaptazodis : " + password_passwordfield.getText());
            goTodashboard();
        } else {
            login_info_label.setStyle("-fx-text-fill: red;");
            login_info_label.setText("Blogai įvestas prisijungimo vardas arba slaptažodis");
        }
    }

    public void windowCloseLoginButton() { //Uzdaro prisijungimo langa
        Stage stage = (Stage) register_button.getScene().getWindow();
        stage.close();
    }

    public void register() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Constants.REGISTER_VIEW_DIRECTORY_PATH));
            Stage registerStage = new Stage();
            Scene scene = new Scene(root, Constants.LOGIN_REGISTER_WINDOW_WIDTH, Constants.LOGIN_REGISTER_WINDOW_HEIGHT);
            scene.getStylesheets().add(getClass().getResource(Constants.CSS_DIRECTORY_PATH).toExternalForm());
            registerStage.setTitle("Registracija");
            registerStage.setScene(scene);
            registerStage.show();
            windowCloseLoginButton();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void goTodashboard(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Constants.DASHBOARD_VIEW_DIRECTORY_PATH));
            Stage dashboardStage = new Stage();
            Scene scene = new Scene(root);
            //scene.getStylesheets().add(getClass().getResource(Constants.CSS_DIRECTORY_PATH).toExternalForm());
            dashboardStage.setTitle("Produktų peržiūros langas");
            dashboardStage.setScene(scene);
            dashboardStage.setMinWidth(1345);
            dashboardStage.show();
            windowCloseLoginButton();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


}
