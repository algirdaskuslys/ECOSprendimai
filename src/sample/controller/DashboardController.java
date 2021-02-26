package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import sample.Main;
import sample.utils.Constants;

import java.net.URL;
import java.util.ResourceBundle;


public class DashboardController extends Main implements Initializable {

    public Button close_button;
    public TreeView<String> product_catalog_tree;


    public void goBackToLogin(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Constants.LOGIN_VIEW_DIRECTORY_PATH));
            Stage LoginStage = new Stage();
            Scene scene = new Scene(root, Constants.LOGIN_REGISTER_WINDOW_WIDTH, Constants.LOGIN_REGISTER_WINDOW_HEIGHT);
            scene.getStylesheets().add(getClass().getResource(Constants.CSS_DIRECTORY_PATH).toExternalForm());
            LoginStage.setTitle("");
            LoginStage.setScene(scene);
            LoginStage.show();
            windowClose();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void windowClose() { //Uzdaro prisijungimo langa
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }

    public void loadsProductsToCatalogTree(){
        TreeItem<String> root = new TreeItem<>("Visa klasifikacija");

        TreeItem<String> nodeA = new TreeItem<>("Moduline apsaugos aparatura");
        TreeItem<String> nodeB = new TreeItem<>("Pramoniniai automatiniai jungikliai");
        TreeItem<String> nodeC = new TreeItem<>("Virstampiu ribotuvai SPD");

        root.getChildren().add(nodeA);
        root.getChildren().add(nodeB);
        root.getChildren().add(nodeC);

        TreeItem<String> nodeA1 = new TreeItem<>("subkategorija1");
        TreeItem<String> nodeA2 = new TreeItem<>("subkategorija2");
        TreeItem<String> nodeA3 = new TreeItem<>("subkategorija3");

        TreeItem<String> nodeB1 = new TreeItem<>("subkategorija1");
        TreeItem<String> nodeB2 = new TreeItem<>("subkategorija2");
        TreeItem<String> nodeB3 = new TreeItem<>("subkategorija3");

        TreeItem<String> nodeC1 = new TreeItem<>("subkategorija1");
        TreeItem<String> nodeC2 = new TreeItem<>("subkategorija2");
        TreeItem<String> nodeC3 = new TreeItem<>("subkategorija3");


        nodeA.getChildren().add(nodeA1);
        nodeA.getChildren().add(nodeA2);
        nodeA.getChildren().add(nodeA3);

        nodeB.getChildren().add(nodeB1);
        nodeB.getChildren().add(nodeB2);
        nodeB.getChildren().add(nodeB3);

        nodeC.getChildren().add(nodeC1);
        nodeC.getChildren().add(nodeC2);
        nodeC.getChildren().add(nodeC3);

        product_catalog_tree.setRoot(root);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadsProductsToCatalogTree();
    }
}
