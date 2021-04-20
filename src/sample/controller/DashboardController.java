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

import sample.JPA.*;
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

        TreeItem<String> skydai = new TreeItem<>("Skydai");
        TreeItem<String> apsvietimas = new TreeItem<>("Apšvietimas");
        TreeItem<String> kabeliai = new TreeItem<>("Kabeliai");
        TreeItem<String> vamzdziaiIrGofra = new TreeItem<>("Vamzdžiai Ir Gofra");
        TreeItem<String> instaliacinesPrekes = new TreeItem<>("Instaliacinės prekės");
        TreeItem<String> metalinesKonstrukcijos = new TreeItem<>("Metalinės konstrukcijos");
        TreeItem<String> izeminimasIrZaibosauga = new TreeItem<>("Įžeminimas ir žaibosauga");
        TreeItem<String> elektromechanika = new TreeItem<>("Elektromechanika");

        root.getChildren().add(skydai);
        root.getChildren().add(apsvietimas);
        root.getChildren().add(kabeliai);
        root.getChildren().add(vamzdziaiIrGofra);
        root.getChildren().add(instaliacinesPrekes);
        root.getChildren().add(metalinesKonstrukcijos);
        root.getChildren().add(izeminimasIrZaibosauga);
        root.getChildren().add(elektromechanika);
        //Skydai
        TreeItem<String> laukoSkydai = new TreeItem<>("Lauko skydai");
        TreeItem<String> vidausSkydai = new TreeItem<>("Vidaus skydai");

        //Apšvietimas
        TreeItem<String> laukoApsvietimas = new TreeItem<>("Lauko apšvietimas");
        TreeItem<String> vidausApsvietimas = new TreeItem<>("Vidaus apšvietimas");

        //Kabeliai
        TreeItem<String> instaliaciniaiKabeliai = new TreeItem<>("Instaliaciniai kabeliai");
        TreeItem<String> jegosKabeliai = new TreeItem<>("Jėgos kabeliai");
        TreeItem<String> behalogeniniaiKabeliai = new TreeItem<>("Behalogeniniai kabeliai");
        TreeItem<String> kontroliniaiKabeliai = new TreeItem<>("Kontroliniai kabeliai");
        TreeItem<String> laidai = new TreeItem<>("Laidai");
        TreeItem<String> internetiniaiKabeliai = new TreeItem<>("Internetinai kabeliai");

        //Vamzdžiai ir gofra
        TreeItem<String> lauko = new TreeItem<>("Lauko");
        TreeItem<String> vidaus = new TreeItem<>("Vidaus");

        //Instaliacinės prekės
        TreeItem<String> jungikliaiIrKistukiniaiLizdai = new TreeItem<>("Jungikliai ir kištukiniai lizdai");
        TreeItem<String> potinkinesDezutes = new TreeItem<>("Potinkinės dėžutės");
        TreeItem<String> sildymoElementai = new TreeItem<>("Šildymo elementai");
        TreeItem<String> judesioIrBuvioJutikliai = new TreeItem<>("Judesio ir būvio jutikliai");
        TreeItem<String> virstinkinesInstaliacinėsDezutes = new TreeItem<>("Virštinkinės instaliacinės dėžutės");
        TreeItem<String> grindinesDezutes = new TreeItem<>("Grindinės dėžutės");
        TreeItem<String> modulineSistema = new TreeItem<>("Modulinė 45x45 sistema");


        //metalines Konstrukcijos
        TreeItem<String> kopecios = new TreeItem<>("Kopėčios");
        TreeItem<String> loveliai = new TreeItem<>("Loveliai");
        TreeItem<String> apsvietimoLovelis = new TreeItem<>("Apšvietimo lovelis");


        //Įžeminimas ir žaibosauga
        TreeItem<String> izeminimoStrypai = new TreeItem<>("Įžeminimo strypai");
        TreeItem<String> cinkuotaJuosta = new TreeItem<>("Cinkuota juosta");
        TreeItem<String> cinkuotaViela = new TreeItem<>("Cinkuota viela");
        TreeItem<String> jungtys = new TreeItem<>("Jungtys");
        TreeItem<String> laikikliai = new TreeItem<>("Laikikliai");
        TreeItem<String> aktyviZaibosauga = new TreeItem<>("Aktyvi žaibosauga");
        TreeItem<String> pasyviZaibosauga = new TreeItem<>("Pasyvi žaibosauga");
        TreeItem<String> virsItampioRibotuvai = new TreeItem<>("Virš įtampio ribotuvai");
        TreeItem<String> priedai = new TreeItem<>("Priedai");

        //Elektromechanika
        TreeItem<String> automatiniaiJungikliai = new TreeItem<>("Automatiniai jungikliai");
        TreeItem<String> relės = new TreeItem<>("Relės");
        TreeItem<String> kontaktoriai = new TreeItem<>("Kontaktoriai");
        TreeItem<String> kirtikliai = new TreeItem<>("Kirtikliai");
        TreeItem<String> moduliniaiJungikliai = new TreeItem<>("Moduliniai jungikliai");
        TreeItem<String> saugikliai = new TreeItem<>("Saugikliai");

        //Skydai add
        skydai.getChildren().add(laukoSkydai);
        skydai.getChildren().add(vidausSkydai);

        //Apsvietimas add
        apsvietimas.getChildren().add(laukoApsvietimas);
        apsvietimas.getChildren().add(vidausApsvietimas);

        //Kabeliai add
        kabeliai.getChildren().add(instaliaciniaiKabeliai);
        kabeliai.getChildren().add(jegosKabeliai);
        kabeliai.getChildren().add(behalogeniniaiKabeliai);
        kabeliai.getChildren().add(kontroliniaiKabeliai);
        kabeliai.getChildren().add(laidai);
        kabeliai.getChildren().add(internetiniaiKabeliai);

        //VamzdziaiIrGofra add
        vamzdziaiIrGofra.getChildren().add(lauko);
        vamzdziaiIrGofra.getChildren().add(vidaus);

        //Instaliacinės prekės add
        instaliacinesPrekes.getChildren().add(jungikliaiIrKistukiniaiLizdai);
        instaliacinesPrekes.getChildren().add(potinkinesDezutes);
        instaliacinesPrekes.getChildren().add(sildymoElementai);
        instaliacinesPrekes.getChildren().add(judesioIrBuvioJutikliai);
        instaliacinesPrekes.getChildren().add(virstinkinesInstaliacinėsDezutes);
        instaliacinesPrekes.getChildren().add(grindinesDezutes);
        instaliacinesPrekes.getChildren().add(modulineSistema);

        //Metalinės konstrukcijos add
        metalinesKonstrukcijos.getChildren().add(kopecios);
        metalinesKonstrukcijos.getChildren().add(loveliai);
        metalinesKonstrukcijos.getChildren().add(apsvietimoLovelis);

        //Įžeminimas ir žaibosauga add
        izeminimasIrZaibosauga.getChildren().add(izeminimoStrypai);
        izeminimasIrZaibosauga.getChildren().add(cinkuotaJuosta);
        izeminimasIrZaibosauga.getChildren().add(cinkuotaViela);
        izeminimasIrZaibosauga.getChildren().add(jungtys);
        izeminimasIrZaibosauga.getChildren().add(laikikliai);
        izeminimasIrZaibosauga.getChildren().add(aktyviZaibosauga);
        izeminimasIrZaibosauga.getChildren().add(pasyviZaibosauga);
        izeminimasIrZaibosauga.getChildren().add(virsItampioRibotuvai);
        izeminimasIrZaibosauga.getChildren().add(priedai);

        //Elektromechanika add
        elektromechanika.getChildren().add(automatiniaiJungikliai);
        elektromechanika.getChildren().add(relės);
        elektromechanika.getChildren().add(kontaktoriai);
        elektromechanika.getChildren().add(kirtikliai);
        elektromechanika.getChildren().add(moduliniaiJungikliai);
        elektromechanika.getChildren().add(saugikliai);

        //Skydai - Vidaus skydai
        TreeItem<String> metalinesDezes = new TreeItem<>("Metalinės dėžės");
        TreeItem<String> potinkiniaiSkydeliai = new TreeItem<>("Potinkiniai skydeliai");
        TreeItem<String> virstinkiniaiSkydeliai = new TreeItem<>("Virštinkiniai skydeliai");
        TreeItem<String> remontiniaiSkydeliai = new TreeItem<>("Remontiniai skydeliai");

        //Skydai - Vid add
        vidausSkydai.getChildren().add(metalinesDezes);
        vidausSkydai.getChildren().add(potinkiniaiSkydeliai);
        vidausSkydai.getChildren().add(virstinkiniaiSkydeliai);
        vidausSkydai.getChildren().add(remontiniaiSkydeliai);

        //Skydai - potinkiniaiSkydeliai
        TreeItem<String> potinkiniaiMetaliniaiSkydeliai = new TreeItem<>("Metaliniai");
        TreeItem<String> potinkiniaiPlastikiniaiSkydeliai = new TreeItem<>("Plastikiniai");


        //Skydai - virstinkiniaiSkydeliai
        TreeItem<String> virstinkiniaiMetaliniaiSkydeliai = new TreeItem<>("Metaliniai");
        TreeItem<String> virstinkiniaiPlastikiniaiSkydeliai = new TreeItem<>("Plastikiniai");

        //Skydai - potinkiniaiSkydeliai add
        potinkiniaiSkydeliai.getChildren().add(potinkiniaiMetaliniaiSkydeliai);
        potinkiniaiSkydeliai.getChildren().add(potinkiniaiPlastikiniaiSkydeliai);

        //Skydai - virstinkiniaiSkydeliai add
        virstinkiniaiSkydeliai.getChildren().add(virstinkiniaiMetaliniaiSkydeliai);
        virstinkiniaiSkydeliai.getChildren().add(virstinkiniaiPlastikiniaiSkydeliai);

        //Skydai - virstinkiniaiSkydeliai - Plastikiniai
        TreeItem<String> virstinkiniaiPlastikinioSkydelioIp40 = new TreeItem<>("IP40");
        TreeItem<String> virstinkiniaiPlastikinioSkydelioIp65 = new TreeItem<>("IP65");

        //Skydai - virstinkiniaiSkydeliai - Plastikiniai add
        virstinkiniaiPlastikiniaiSkydeliai.getChildren().add(virstinkiniaiPlastikinioSkydelioIp40);
        virstinkiniaiPlastikiniaiSkydeliai.getChildren().add(virstinkiniaiPlastikinioSkydelioIp65);

        //Apsvietimas - Lauko apsvietimas
        TreeItem<String> gatviniaiSviestuvai = new TreeItem<>("Gatviniai šviestuvai");
        TreeItem<String> laukoprozektoriai = new TreeItem<>("Lauko prožektoriai");
        TreeItem<String> parkiniaisviestuvai = new TreeItem<>("Parkiniai šviestuvaii");
        TreeItem<String> atramosgembes = new TreeItem<>("Atramos gembės");
        TreeItem<String> priedailaukoApsvietimui = new TreeItem<>("Priedai lauko apšvietimui");

        //Apsvietimas - Vidaus apšvietimas
        TreeItem<String> LEDPanelesA = new TreeItem<>("LED panelės 60x60");
        TreeItem<String> LEDPaneles = new TreeItem<>("LED panelės");
        TreeItem<String> downlight = new TreeItem<>("Downlight");
        TreeItem<String> lubiniai = new TreeItem<>("Lubiniai IP65");
        TreeItem<String> sieniniai = new TreeItem<>("Sieniniai");
        TreeItem<String> pakabinami = new TreeItem<>("Pakabinami");
        TreeItem<String> avarinisApsvietimas = new TreeItem<>("Avarinis apšvietimas");
        TreeItem<String> highBay = new TreeItem<>("High Bay");

        //Apsvietimas - Lauko apsvietimas add
        laukoApsvietimas.getChildren().add(gatviniaiSviestuvai);
        laukoApsvietimas.getChildren().add(laukoprozektoriai);
        laukoApsvietimas.getChildren().add(parkiniaisviestuvai);
        laukoApsvietimas.getChildren().add(atramosgembes);
        laukoApsvietimas.getChildren().add(priedailaukoApsvietimui);

        //Apsvietimas - Vidaus apšvietimas add
        vidausApsvietimas.getChildren().add(LEDPanelesA);
        vidausApsvietimas.getChildren().add(LEDPaneles);
        vidausApsvietimas.getChildren().add(downlight);
        vidausApsvietimas.getChildren().add(lubiniai);
        vidausApsvietimas.getChildren().add(sieniniai);
        vidausApsvietimas.getChildren().add(pakabinami);
        vidausApsvietimas.getChildren().add(avarinisApsvietimas);
        vidausApsvietimas.getChildren().add(highBay);

        //Apsvietimas - Lauko apsvietimas - Atramos gembes
        TreeItem<String> atramos = new TreeItem<>("Atramos");
        TreeItem<String> gembes = new TreeItem<>("Gembės");
        TreeItem<String> pamatai = new TreeItem<>("Pamatai");

        //Apsvietimas - Lauko apsvietimas - Atramos gembes add
        atramosgembes.getChildren().add(atramos);
        atramosgembes.getChildren().add(gembes);
        atramosgembes.getChildren().add(pamatai);

        //Apsvietimas - Vidaus apšvietimas - LED panelės
        TreeItem<String> ipa = new TreeItem<>("IP20");
        TreeItem<String> ipb = new TreeItem<>("IP44");

        //Apsvietimas - Vidaus apšvietimas - LED panelės add
        LEDPaneles.getChildren().add(ipa);
        LEDPaneles.getChildren().add(ipb);

        //Apsvietimas - Vidaus apšvietimas - Downlight
        TreeItem<String> ipaa = new TreeItem<>("IP20");
        TreeItem<String> ipbb = new TreeItem<>("IP44");

        //Apsvietimas - Vidaus apšvietimas - Downlight add
        downlight.getChildren().add(ipaa);
        downlight.getChildren().add(ipbb);

        //Apsvietimas - Vidaus apšvietimas - sieniniai add
        TreeItem<String> ipaaa = new TreeItem<>("IP44");
        TreeItem<String> ipbbb = new TreeItem<>("IP65");

        //Apsvietimas - Vidaus apšvietimas - sieniniai add
        downlight.getChildren().add(ipaaa);
        downlight.getChildren().add(ipbbb);

        //Įžeminimas ir žaibosauga - Įžeminimo strypai
        TreeItem<String> variuotiStrypai = new TreeItem<>("Variuoti strypai");
        TreeItem<String> cinkuotiStrypai = new TreeItem<>("Cinkuoti strypai");

        //Kabeliai - Jėgos kabeliai
        TreeItem<String> nyyj = new TreeItem<>("NYY-J");
        TreeItem<String> cykyj = new TreeItem<>("CYKY-J");

        //Kabeliai - Jėgos kabeliai add
        jegosKabeliai.getChildren().add(nyyj);
        jegosKabeliai.getChildren().add(cykyj);

        //Kabeliai - Behalogeniniai kabeliai
        TreeItem<String> cca = new TreeItem<>("Cca");
        TreeItem<String> b2ca = new TreeItem<>("B2ca");

        //Kabeliai - Behalogeniniai kabeliai add
        behalogeniniaiKabeliai.getChildren().add(cca);
        behalogeniniaiKabeliai.getChildren().add(b2ca);

        //Kabeliai - Internetinai kabeliai
        TreeItem<String> cat5 = new TreeItem<>("Cat5");
        TreeItem<String> cat6 = new TreeItem<>("Cat6");

        //Kabeliai - Internetinai kabeliai add
        internetiniaiKabeliai.getChildren().add(cat5);
        internetiniaiKabeliai.getChildren().add(cat6);

        //Kabeliai - Internetinai kabeliai - cat5
        TreeItem<String> cat5utp = new TreeItem<>("UTP");
        TreeItem<String> cat5ftp = new TreeItem<>("FTP");

        //Kabeliai - Internetinai kabeliai - cat6
        TreeItem<String> cat6utp = new TreeItem<>("UTP");
        TreeItem<String> cat6ftp = new TreeItem<>("FTP");

        //Kabeliai - Internetinai kabeliai - cat5 add
        cat5.getChildren().add(cat5utp);
        cat5.getChildren().add(cat5ftp);

        //Kabeliai - Internetinai kabeliai - cat6 add
        cat6.getChildren().add(cat6utp);
        cat6.getChildren().add(cat6ftp);

        //Vamzdžiai ir gofra - lauko
        TreeItem<String> ape = new TreeItem<>("APE");
        TreeItem<String> gofros = new TreeItem<>("Gofros");
        TreeItem<String> prakalimoVamzdis = new TreeItem<>("Prakalimo vamzdis");
        TreeItem<String> sudedamasVazdis = new TreeItem<>("Sudedamas vazdis");

        //Vamzdžiai ir gofra - lauko add
        lauko.getChildren().add(ape);
        lauko.getChildren().add(gofros);
        lauko.getChildren().add(prakalimoVamzdis);
        lauko.getChildren().add(sudedamasVazdis);

        //Vamzdžiai ir gofra - vidaus
        TreeItem<String> vGofros = new TreeItem<>("Gofros");
        TreeItem<String> behalogeninėsGofros = new TreeItem<>("Behalogeninės gofros");
        TreeItem<String> vamzdžiai = new TreeItem<>("Vamzdžiai");
        TreeItem<String> behalogeniniaiVamzdžiai = new TreeItem<>("Behalogeniniai vamzdžiai");
        TreeItem<String> gofrosSuKabeliu = new TreeItem<>("Gofros su kabeliu");
        TreeItem<String> gofrosSuLaidu = new TreeItem<>("Gofros su laidu");

        //Vamzdžiai ir gofra - vidaus add
        vidaus.getChildren().add(vGofros);
        vidaus.getChildren().add(behalogeninėsGofros);
        vidaus.getChildren().add(vamzdžiai);
        vidaus.getChildren().add(behalogeniniaiVamzdžiai);
        vidaus.getChildren().add(gofrosSuKabeliu);
        vidaus.getChildren().add(gofrosSuLaidu);

        //Vamzdžiai ir gofra - lauko
        TreeItem<String> g450N = new TreeItem<>("g450N");
        TreeItem<String> g750N = new TreeItem<>("g750N");
        TreeItem<String> g1250N = new TreeItem<>("g1250N");

        //Vamzdžiai ir gofra - vidaus
        TreeItem<String> vG320N = new TreeItem<>("320N");
        TreeItem<String> vG750N = new TreeItem<>("750N");

        //Vamzdžiai ir gofra - lauko add
        gofros.getChildren().add(g450N);
        gofros.getChildren().add(g750N);
        gofros.getChildren().add(g1250N);

        //Vamzdžiai ir gofra - vidaus add
        vGofros.getChildren().add(vG320N);
        vGofros.getChildren().add(vG750N);


        //Instaliacinės prekės - Jungikliai ir kištukiniai lizdai
        TreeItem<String> potinkiniaiJungikliai = new TreeItem<>("Potinkiniai jungikliai ir kištukiniai lizdai");
        TreeItem<String> virstinkiniaiJungikliai = new TreeItem<>("Virštinkiniai jungikliai ir kištukiniai lizdai");
        TreeItem<String> pramoniniaiLizdai = new TreeItem<>("Pramoniniai lizdai ir kištukai");

        //Instaliacinės prekės - Jungikliai ir kištukiniai lizdai add
        jungikliaiIrKistukiniaiLizdai.getChildren().add(potinkiniaiJungikliai);
        jungikliaiIrKistukiniaiLizdai.getChildren().add(virstinkiniaiJungikliai);
        jungikliaiIrKistukiniaiLizdai.getChildren().add(pramoniniaiLizdai);

        //Instaliacinės prekės - Potinkinės dėžutės
        TreeItem<String> muroDezute= new TreeItem<>("Dėžutė į mūrą");
        TreeItem<String> gipsoDezute = new TreeItem<>("Dėžutė į gipsą");

        //Instaliacinės prekės - Potinkinės dėžutės add
        potinkinesDezutes.getChildren().add(muroDezute);
        potinkinesDezutes.getChildren().add(gipsoDezute);
        //Instaliacinės prekės - Šildymo elementai
        TreeItem<String> sildymoKilimėliai = new TreeItem<>("Šildymo kilimėliai");
        TreeItem<String> sildymoKabeliai = new TreeItem<>("Šildymo kabeliai");
        TreeItem<String> sildymoĮranga = new TreeItem<>("Šildymo įranga");

        //Instaliacinės prekės - Šildymo elementai add
        sildymoElementai.getChildren().add(sildymoKilimėliai);
        sildymoElementai.getChildren().add(sildymoKabeliai);
        sildymoElementai.getChildren().add(sildymoĮranga);

        //Instaliacinės prekės - Grindinės dėžutės
        TreeItem<String> gridninesPlastikinesDezutes = new TreeItem<>("Plastikinės");
        TreeItem<String> grindinesMetalinesDezutes = new TreeItem<>("Metalinės");

        //Instaliacinės prekės - Grindinės dėžutės add
        grindinesDezutes.getChildren().add(gridninesPlastikinesDezutes);
        grindinesDezutes.getChildren().add(grindinesMetalinesDezutes);

        //Instaliacinės prekės - Judesio ir būvio jutikliai
        TreeItem<String> judesio = new TreeItem<>("Judesio");
        TreeItem<String> buvio = new TreeItem<>("Būvio");

        //Instaliacinės prekės - Judesio ir būvio jutikliai add
        judesioIrBuvioJutikliai.getChildren().add(judesio);
        judesioIrBuvioJutikliai.getChildren().add(buvio);

        //Instaliacinės prekės - Judesio ir būvio jutikliai Judesio
        TreeItem<String> virstinkiniai = new TreeItem<>("Virštinkiniai");
        TreeItem<String> potinkiniai = new TreeItem<>("Potinkiniai");

        //Instaliacinės prekės - Judesio ir būvio jutikliai Būvio
        TreeItem<String> virstinkiniaiB = new TreeItem<>("Virštinkiniai");
        TreeItem<String> potinkiniaiB = new TreeItem<>("Potinkiniai");

        //Instaliacinės prekės - Judesio ir būvio jutikliai Judesio add
        judesio.getChildren().add(virstinkiniai);
        judesio.getChildren().add(potinkiniai);
        //Instaliacinės prekės - Judesio ir būvio jutikliai Būvio add
        buvio.getChildren().add(virstinkiniaiB);
        buvio.getChildren().add(potinkiniaiB);

        //Įžeminimas ir žaibosauga - Įžeminimo strypai
        izeminimoStrypai.getChildren().add(variuotiStrypai);
        izeminimoStrypai.getChildren().add(cinkuotiStrypai);

        //Metalinės konstrukcijos - kopecios
        TreeItem<String> kopKarstoCinkavimo = new TreeItem<>("Karšto cinkavimo");
        TreeItem<String> kopSaltoCinkavimo = new TreeItem<>("Šalto cinkavimo");

        //Metalinės konstrukcijos - loveliai
        TreeItem<String> lovKarstoCinkavimo = new TreeItem<>("Karšto cinkavimo");
        TreeItem<String> lovSaltoCinkavimo = new TreeItem<>("Šalto cinkavimo");

        //Metalinės konstrukcijos - kopecios
        kopecios.getChildren().add(kopKarstoCinkavimo);
        kopecios.getChildren().add(kopSaltoCinkavimo);

        //Metalinės konstrukcijos - loveliai
        loveliai.getChildren().add(lovKarstoCinkavimo);
        loveliai.getChildren().add(lovSaltoCinkavimo);

        //Elektromechanika - Automatiniai jungikliai
        TreeItem<String> e6kA = new TreeItem<>("6kA");
        TreeItem<String> e10kA = new TreeItem<>("10kA");

        //Elektromechanika - Kirtikliai
        TreeItem<String> moduliniai = new TreeItem<>("Moduliniai");
        TreeItem<String> paneliniai = new TreeItem<>("Paneliniai");

        //Elektromechanika - Automatiniai jungikliai
        automatiniaiJungikliai.getChildren().add(e6kA);
        automatiniaiJungikliai.getChildren().add(e10kA);

        //Elektromechanika - Kirtikliai
        kirtikliai.getChildren().add(moduliniai);
        kirtikliai.getChildren().add(paneliniai);

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

        List<ProductCatalog> productCatalogs = ProductCatalogDAO.displayAllItems();
        System.out.println(productCatalogs);


        // ProductCatalogDAO.find();


        final ObservableList<ProductCatalog> data = FXCollections.observableArrayList(

                //new ProductCatalog(2020014, "Developer", 15, 2500, 1),
                //new ProductCatalog(2020014, "Developer", 15, 2500, 1)
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


        List<ProductCatalog> excelProducts = null;
        List<ProductCatalog> dbProducts = ProductCatalogDAO.displayAllItems();
        try {
            excelProducts = ReadExcelWithProductCatalog.readFileUsingPOI(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (ProductCatalog excelProduct : excelProducts) {
            for (ProductCatalog dbProduct : dbProducts){
                if (dbProduct.getPriceNet() != excelProduct.getPriceNet() && dbProduct.getCatalogNo() == excelProduct.getCatalogNo()){
                   ProductCatalogDAO.updateByCatalog_no(excelProduct.getPriceNet(), dbProduct.getId());
                }
           }
            // TODO: 1. Padaryta
           // ProductCatalogDAO.insert(excelProduct);
            // TODO: 2. Padaryta Atnaujinti tik tas produktų kainas, kurios skiriasi nuo xlsx faile esančių kainų, nes pasikeitė
            // 2.1. Arba vienu kreipimusi į db išsitraukti visą sąrašą produktų (ProductCatalogDAO.displayAllItems())
            // 2.1. Arba kiekvieną kartą prieš įrašant konkretų produktą, gauti informaciją apie jo
            //      kainą db (ProductCatalogDAO.findByName(excelProduct.getName()))
            // if (dbProduct.getPrice() != excelProduct.getPrice()) {
            //      ProductCatalogDAO.update(excelProduct);
            // }
            // TODO: 3. Testavimas- 1) pasižiūrėti ar pasikeitus kainoms, atnaujinami įrašai db.
            //                      2) pasižiūrėti ar nepasikeitus kainoms, įrašai db neatnaujinami.
            //System.out.println(product.toString());
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


