package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import sample.JPA.ProductCatalog;
import sample.JPA.ProductCatalogDAO;
import sample.JPA.ReadExcelWithProductCatalog;
import sample.Main;
import sample.utils.Constants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class DashboardController extends Main implements Initializable {

    public Button close_button;
    public TreeView<String> product_catalog_tree;

    public Button open_file;

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

    public void loadsProductsToCatalogTree() {
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


    @FXML
    private TableView table;

    public void loadDataToTable() {

        TableColumn id = new TableColumn("Id");
        TableColumn upload = new TableColumn("catalogNo");
        TableColumn position = new TableColumn("symbol");
        TableColumn employer = new TableColumn("priceNet");
        TableColumn pay = new TableColumn("stock");

        table.getColumns().addAll(id, upload, position, employer, pay);

        ArrayList<ProductCatalog> productCatalogs = ProductCatalogDAO.displayAllItems();
        System.out.println(productCatalogs);


        // ProductCatalogDAO.find();


        final ObservableList<ProductCatalog> data = FXCollections.observableArrayList(

                new ProductCatalog(2020014, "Developer", 15, 2500, 1),
                new ProductCatalog(2020014, "Developer", 15, 2500, 1)
        );

        id.setCellValueFactory(new PropertyValueFactory<ProductCatalog, String>("Id"));
        upload.setCellValueFactory(new PropertyValueFactory<ProductCatalog, String>("catalogNo"));
        position.setCellValueFactory(new PropertyValueFactory<ProductCatalog, String>("symbol"));
        employer.setCellValueFactory(new PropertyValueFactory<ProductCatalog, String>("priceNet"));
        pay.setCellValueFactory(new PropertyValueFactory<ProductCatalog, String>("stock"));

        table.setItems(data);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadsProductsToCatalogTree();
/*
        List<ProductCatalog> products = null;
        try {
            products = ReadExcelWithProductCatalog.readFileUsingPOI();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (ProductCatalog product : products) {
            System.out.println(product.toString());
        }
        loadDataToTable();

 */
    }

    public void openExcelFileFromDialog() {
        final FileChooser fileChooser = new FileChooser();
        open_file.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                configureFileChooser(fileChooser);
                File file = fileChooser.showOpenDialog(new Stage());
                if (file != null) {
                    openFile(file);
                }
            }
        });

    }

    private void openFile(File file) {


        List<ProductCatalog> products = null;
        try {
            products = ReadExcelWithProductCatalog.readFileUsingPOI(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (ProductCatalog product : products) {
            System.out.println(product.toString());
        }
   //     loadDataToTable();

    }

    private static void configureFileChooser(
            final FileChooser fileChooser) {
        fileChooser.setTitle("Uzkrauti excel faila");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Excel file", "*.xlsx")
        );
    }

}


