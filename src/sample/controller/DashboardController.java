package sample.controller;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;

import javafx.stage.Window;
import javafx.util.Callback;
import sample.JPA.*;
import sample.Main;
import sample.utils.Constants;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.eclipse.fx.ui.controls.tree.FilterableTreeItem;
import org.eclipse.fx.ui.controls.tree.TreeItemPredicate;

public class DashboardController extends Main implements Initializable {

    public Button close_button;
    @FXML
    private TableView table;
    public Button open_file;
    public TextField paieskosLaukelis;
    public Label countAll;



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

    public FilterableTreeItem<CategoryItem> loadsProductsToCatalogTree() {


        FilterableTreeItem<CategoryItem> root = new FilterableTreeItem<>(new CategoryItem("Root"));
        root.setExpanded(true);

        FilterableTreeItem<CategoryItem> skydai = createFolder("Skydai");
        FilterableTreeItem<CategoryItem> apsvietimas = createFolder("Apšvietimas");
        FilterableTreeItem<CategoryItem> kabeliai = createFolder("Kabeliai");
        FilterableTreeItem<CategoryItem> vamzdziaiIrGofra = createFolder("Vamzdžiai Ir Gofra");
        FilterableTreeItem<CategoryItem> instaliacinesPrekes = createFolder("Instaliacinės prekės");
        FilterableTreeItem<CategoryItem> metalinesKonstrukcijos = createFolder("Metalinės konstrukcijos");
        FilterableTreeItem<CategoryItem> izeminimasIrZaibosauga = createFolder("Įžeminimas ir žaibosauga");
        FilterableTreeItem<CategoryItem> elektromechanika = createFolder("Elektromechanika");

        root.getInternalChildren().add(skydai);
        root.getInternalChildren().add(apsvietimas);
        root.getInternalChildren().add(kabeliai);
        root.getInternalChildren().add(vamzdziaiIrGofra);
        root.getInternalChildren().add(instaliacinesPrekes);
        root.getInternalChildren().add(metalinesKonstrukcijos);
        root.getInternalChildren().add(izeminimasIrZaibosauga);
        root.getInternalChildren().add(elektromechanika);

        //Skydai
        FilterableTreeItem<CategoryItem> laukoSkydai = createFolder("Lauko skydai");
        FilterableTreeItem<CategoryItem> vidausSkydai = createFolder("Vidaus skydai");

        //Apšvietimas
        FilterableTreeItem<CategoryItem> laukoApsvietimas = createFolder("Lauko apšvietimas");
        FilterableTreeItem<CategoryItem> vidausApsvietimas = createFolder("Vidaus apšvietimas");

        //Kabeliai
        FilterableTreeItem<CategoryItem> instaliaciniaiKabeliai = createFolder("Instaliaciniai kabeliai");
        FilterableTreeItem<CategoryItem> jegosKabeliai = createFolder("Jėgos kabeliai");
        FilterableTreeItem<CategoryItem> behalogeniniaiKabeliai = createFolder("Behalogeniniai kabeliai");
        FilterableTreeItem<CategoryItem> kontroliniaiKabeliai = createFolder("Kontroliniai kabeliai");
        FilterableTreeItem<CategoryItem> laidai = createFolder("Laidai");
        FilterableTreeItem<CategoryItem> internetiniaiKabeliai = createFolder("Internetinai kabeliai");

        //Vamzdžiai ir gofra
        FilterableTreeItem<CategoryItem> lauko = createFolder("Lauko");
        FilterableTreeItem<CategoryItem> vidaus = createFolder("Vidaus");

        //Instaliacinės prekės
        FilterableTreeItem<CategoryItem> jungikliaiIrKistukiniaiLizdai = createFolder("Jungikliai ir kištukiniai lizdai");
        FilterableTreeItem<CategoryItem> potinkinesDezutes = createFolder("Potinkinės dėžutės");
        FilterableTreeItem<CategoryItem> sildymoElementai = createFolder("Šildymo elementai");
        FilterableTreeItem<CategoryItem> judesioIrBuvioJutikliai = createFolder("Judesio ir būvio jutikliai");
        FilterableTreeItem<CategoryItem> virstinkinesInstaliacinėsDezutes = createFolder("Virštinkinės instaliacinės dėžutės");
        FilterableTreeItem<CategoryItem> grindinesDezutes = createFolder("Grindinės dėžutės");
        FilterableTreeItem<CategoryItem> modulineSistema = createFolder("Modulinė 45x45 sistema");


        //metalines Konstrukcijos
        FilterableTreeItem<CategoryItem> kopecios = createFolder("Kopėčios");
        FilterableTreeItem<CategoryItem> loveliai = createFolder("Loveliai");
        FilterableTreeItem<CategoryItem> apsvietimoLovelis = createFolder("Apšvietimo lovelis");


        //Įžeminimas ir žaibosauga
        FilterableTreeItem<CategoryItem> izeminimoStrypai = createFolder("Įžeminimo strypai");
        FilterableTreeItem<CategoryItem> cinkuotaJuosta = createFolder("Cinkuota juosta");
        FilterableTreeItem<CategoryItem> cinkuotaViela = createFolder("Cinkuota viela");
        FilterableTreeItem<CategoryItem> jungtys = createFolder("Jungtys");
        FilterableTreeItem<CategoryItem> laikikliai = createFolder("Laikikliai");
        FilterableTreeItem<CategoryItem> aktyviZaibosauga = createFolder("Aktyvi žaibosauga");
        FilterableTreeItem<CategoryItem> pasyviZaibosauga = createFolder("Pasyvi žaibosauga");
        FilterableTreeItem<CategoryItem> virsItampioRibotuvai = createFolder("Virš įtampio ribotuvai");
        FilterableTreeItem<CategoryItem> priedai = createFolder("Priedai");

        //Elektromechanika
        FilterableTreeItem<CategoryItem> automatiniaiJungikliai = createFolder("Automatiniai jungikliai");
        FilterableTreeItem<CategoryItem> relės = createFolder("Relės");
        FilterableTreeItem<CategoryItem> kontaktoriai = createFolder("Kontaktoriai");
        FilterableTreeItem<CategoryItem> kirtikliai = createFolder("Kirtikliai");
        FilterableTreeItem<CategoryItem> moduliniaiJungikliai = createFolder("Moduliniai jungikliai");
        FilterableTreeItem<CategoryItem> saugikliai = createFolder("Saugikliai");

        //Skydai add
        skydai.getInternalChildren().add(laukoSkydai);
        skydai.getInternalChildren().add(vidausSkydai);

        //Apsvietimas add
        apsvietimas.getInternalChildren().add(laukoApsvietimas);
        apsvietimas.getInternalChildren().add(vidausApsvietimas);

        //Kabeliai add
        kabeliai.getInternalChildren().add(instaliaciniaiKabeliai);
        kabeliai.getInternalChildren().add(jegosKabeliai);
        kabeliai.getInternalChildren().add(behalogeniniaiKabeliai);
        kabeliai.getInternalChildren().add(kontroliniaiKabeliai);
        kabeliai.getInternalChildren().add(laidai);
        kabeliai.getInternalChildren().add(internetiniaiKabeliai);

        //VamzdziaiIrGofra add
        vamzdziaiIrGofra.getInternalChildren().add(lauko);
        vamzdziaiIrGofra.getInternalChildren().add(vidaus);

        //Instaliacinės prekės add
        instaliacinesPrekes.getInternalChildren().add(jungikliaiIrKistukiniaiLizdai);
        instaliacinesPrekes.getInternalChildren().add(potinkinesDezutes);
        instaliacinesPrekes.getInternalChildren().add(sildymoElementai);
        instaliacinesPrekes.getInternalChildren().add(judesioIrBuvioJutikliai);
        instaliacinesPrekes.getInternalChildren().add(virstinkinesInstaliacinėsDezutes);
        instaliacinesPrekes.getInternalChildren().add(grindinesDezutes);
        instaliacinesPrekes.getInternalChildren().add(modulineSistema);

        //Metalinės konstrukcijos add
        metalinesKonstrukcijos.getInternalChildren().add(kopecios);
        metalinesKonstrukcijos.getInternalChildren().add(loveliai);
        metalinesKonstrukcijos.getInternalChildren().add(apsvietimoLovelis);

        //Įžeminimas ir žaibosauga add
        izeminimasIrZaibosauga.getInternalChildren().add(izeminimoStrypai);
        izeminimasIrZaibosauga.getInternalChildren().add(cinkuotaJuosta);
        izeminimasIrZaibosauga.getInternalChildren().add(cinkuotaViela);
        izeminimasIrZaibosauga.getInternalChildren().add(jungtys);
        izeminimasIrZaibosauga.getInternalChildren().add(laikikliai);
        izeminimasIrZaibosauga.getInternalChildren().add(aktyviZaibosauga);
        izeminimasIrZaibosauga.getInternalChildren().add(pasyviZaibosauga);
        izeminimasIrZaibosauga.getInternalChildren().add(virsItampioRibotuvai);
        izeminimasIrZaibosauga.getInternalChildren().add(priedai);

        //Elektromechanika add
        elektromechanika.getInternalChildren().add(automatiniaiJungikliai);
        elektromechanika.getInternalChildren().add(relės);
        elektromechanika.getInternalChildren().add(kontaktoriai);
        elektromechanika.getInternalChildren().add(kirtikliai);
        elektromechanika.getInternalChildren().add(moduliniaiJungikliai);
        elektromechanika.getInternalChildren().add(saugikliai);

        //Skydai - Vidaus skydai
        FilterableTreeItem<CategoryItem> metalinesDezes = createFolder("Metalinės dėžės");
        FilterableTreeItem<CategoryItem> potinkiniaiSkydeliai = createFolder("Potinkiniai skydeliai");
        FilterableTreeItem<CategoryItem> virstinkiniaiSkydeliai = createFolder("Virštinkiniai skydeliai");
        FilterableTreeItem<CategoryItem> remontiniaiSkydeliai = createFolder("Remontiniai skydeliai");

        //Skydai - Vid add
        vidausSkydai.getInternalChildren().add(metalinesDezes);
        vidausSkydai.getInternalChildren().add(potinkiniaiSkydeliai);
        vidausSkydai.getInternalChildren().add(virstinkiniaiSkydeliai);
        vidausSkydai.getInternalChildren().add(remontiniaiSkydeliai);

        //Skydai - potinkiniaiSkydeliai
        FilterableTreeItem<CategoryItem> potinkiniaiMetaliniaiSkydeliai = createFolder("Metaliniai");
        FilterableTreeItem<CategoryItem> potinkiniaiPlastikiniaiSkydeliai = createFolder("Plastikiniai");


        //Skydai - virstinkiniaiSkydeliai
        FilterableTreeItem<CategoryItem> virstinkiniaiMetaliniaiSkydeliai = createFolder("Metaliniai");
        FilterableTreeItem<CategoryItem> virstinkiniaiPlastikiniaiSkydeliai = createFolder("Plastikiniai");

        //Skydai - potinkiniaiSkydeliai add
        potinkiniaiSkydeliai.getInternalChildren().add(potinkiniaiMetaliniaiSkydeliai);
        potinkiniaiSkydeliai.getInternalChildren().add(potinkiniaiPlastikiniaiSkydeliai);

        //Skydai - virstinkiniaiSkydeliai add
        virstinkiniaiSkydeliai.getInternalChildren().add(virstinkiniaiMetaliniaiSkydeliai);
        virstinkiniaiSkydeliai.getInternalChildren().add(virstinkiniaiPlastikiniaiSkydeliai);

        //Skydai - virstinkiniaiSkydeliai - Plastikiniai
        FilterableTreeItem<CategoryItem> virstinkiniaiPlastikinioSkydelioIp40 = createFolder("IP40");
        FilterableTreeItem<CategoryItem> virstinkiniaiPlastikinioSkydelioIp65 = createFolder("IP65");

        //Skydai - virstinkiniaiSkydeliai - Plastikiniai add
        virstinkiniaiPlastikiniaiSkydeliai.getInternalChildren().add(virstinkiniaiPlastikinioSkydelioIp40);
        virstinkiniaiPlastikiniaiSkydeliai.getInternalChildren().add(virstinkiniaiPlastikinioSkydelioIp65);

        //Apsvietimas - Lauko apsvietimas
        FilterableTreeItem<CategoryItem> gatviniaiSviestuvai = createFolder("Gatviniai šviestuvai");
        FilterableTreeItem<CategoryItem> laukoprozektoriai = createFolder("Lauko prožektoriai");
        FilterableTreeItem<CategoryItem> parkiniaisviestuvai = createFolder("Parkiniai šviestuvaii");
        FilterableTreeItem<CategoryItem> atramosgembes = createFolder("Atramos gembės");
        FilterableTreeItem<CategoryItem> priedailaukoApsvietimui = createFolder("Priedai lauko apšvietimui");

        //Apsvietimas - Vidaus apšvietimas
        FilterableTreeItem<CategoryItem> LEDPanelesA = createFolder("LED panelės 60x60");
        FilterableTreeItem<CategoryItem> LEDPaneles = createFolder("LED panelės");
        FilterableTreeItem<CategoryItem> downlight = createFolder("Downlight");
        FilterableTreeItem<CategoryItem> lubiniai = createFolder("Lubiniai IP65");
        FilterableTreeItem<CategoryItem> sieniniai = createFolder("Sieniniai");
        FilterableTreeItem<CategoryItem> pakabinami = createFolder("Pakabinami");
        FilterableTreeItem<CategoryItem> avarinisApsvietimas = createFolder("Avarinis apšvietimas");
        FilterableTreeItem<CategoryItem> highBay = createFolder("High Bay");

        //Apsvietimas - Lauko apsvietimas add
        laukoApsvietimas.getInternalChildren().add(gatviniaiSviestuvai);
        laukoApsvietimas.getInternalChildren().add(laukoprozektoriai);
        laukoApsvietimas.getInternalChildren().add(parkiniaisviestuvai);
        laukoApsvietimas.getInternalChildren().add(atramosgembes);
        laukoApsvietimas.getInternalChildren().add(priedailaukoApsvietimui);

        //Apsvietimas - Vidaus apšvietimas add
        vidausApsvietimas.getInternalChildren().add(LEDPanelesA);
        vidausApsvietimas.getInternalChildren().add(LEDPaneles);
        vidausApsvietimas.getInternalChildren().add(downlight);
        vidausApsvietimas.getInternalChildren().add(lubiniai);
        vidausApsvietimas.getInternalChildren().add(sieniniai);
        vidausApsvietimas.getInternalChildren().add(pakabinami);
        vidausApsvietimas.getInternalChildren().add(avarinisApsvietimas);
        vidausApsvietimas.getInternalChildren().add(highBay);

        //Apsvietimas - Lauko apsvietimas - Atramos gembes
        FilterableTreeItem<CategoryItem> atramos = createFolder("Atramos");
        FilterableTreeItem<CategoryItem> gembes = createFolder("Gembės");
        FilterableTreeItem<CategoryItem> pamatai = createFolder("Pamatai");

        //Apsvietimas - Lauko apsvietimas - Atramos gembes add
        atramosgembes.getInternalChildren().add(atramos);
        atramosgembes.getInternalChildren().add(gembes);
        atramosgembes.getInternalChildren().add(pamatai);

        //Apsvietimas - Vidaus apšvietimas - LED panelės
        FilterableTreeItem<CategoryItem> ipa = createFolder("IP20");
        FilterableTreeItem<CategoryItem> ipb = createFolder("IP44");

        //Apsvietimas - Vidaus apšvietimas - LED panelės add
        LEDPaneles.getInternalChildren().add(ipa);
        LEDPaneles.getInternalChildren().add(ipb);

        //Apsvietimas - Vidaus apšvietimas - Downlight
        FilterableTreeItem<CategoryItem> ipaa = createFolder("IP20");
        FilterableTreeItem<CategoryItem> ipbb = createFolder("IP44");

        //Apsvietimas - Vidaus apšvietimas - Downlight add
        downlight.getInternalChildren().add(ipaa);
        downlight.getInternalChildren().add(ipbb);

        //Apsvietimas - Vidaus apšvietimas - sieniniai add
        FilterableTreeItem<CategoryItem> ipaaa = createFolder("IP44");
        FilterableTreeItem<CategoryItem> ipbbb = createFolder("IP65");

        //Apsvietimas - Vidaus apšvietimas - sieniniai add
        downlight.getInternalChildren().add(ipaaa);
        downlight.getInternalChildren().add(ipbbb);

        //Įžeminimas ir žaibosauga - Įžeminimo strypai
        FilterableTreeItem<CategoryItem> variuotiStrypai = createFolder("Variuoti strypai");
        FilterableTreeItem<CategoryItem> cinkuotiStrypai = createFolder("Cinkuoti strypai");

        //Kabeliai - Jėgos kabeliai
        FilterableTreeItem<CategoryItem> nyyj = createFolder("NYY-J");
        FilterableTreeItem<CategoryItem> cykyj = createFolder("CYKY-J");

        //Kabeliai - Jėgos kabeliai add
        jegosKabeliai.getInternalChildren().add(nyyj);
        jegosKabeliai.getInternalChildren().add(cykyj);

        //Kabeliai - Behalogeniniai kabeliai
        FilterableTreeItem<CategoryItem> cca = createFolder("Cca");
        FilterableTreeItem<CategoryItem> b2ca = createFolder("B2ca");

        //Kabeliai - Behalogeniniai kabeliai add
        behalogeniniaiKabeliai.getInternalChildren().add(cca);
        behalogeniniaiKabeliai.getInternalChildren().add(b2ca);

        //Kabeliai - Internetinai kabeliai
        FilterableTreeItem<CategoryItem> cat5 = createFolder("Cat5");
        FilterableTreeItem<CategoryItem> cat6 = createFolder("Cat6");

        //Kabeliai - Internetinai kabeliai add
        internetiniaiKabeliai.getInternalChildren().add(cat5);
        internetiniaiKabeliai.getInternalChildren().add(cat6);

        //Kabeliai - Internetinai kabeliai - cat5
        FilterableTreeItem<CategoryItem> cat5utp = createFolder("UTP");
        FilterableTreeItem<CategoryItem> cat5ftp = createFolder("FTP");

        //Kabeliai - Internetinai kabeliai - cat6
        FilterableTreeItem<CategoryItem> cat6utp = createFolder("UTP");
        FilterableTreeItem<CategoryItem> cat6ftp = createFolder("FTP");

        //Kabeliai - Internetinai kabeliai - cat5 add
        cat5.getInternalChildren().add(cat5utp);
        cat5.getInternalChildren().add(cat5ftp);

        //Kabeliai - Internetinai kabeliai - cat6 add
        cat6.getInternalChildren().add(cat6utp);
        cat6.getInternalChildren().add(cat6ftp);

        //Vamzdžiai ir gofra - lauko
        FilterableTreeItem<CategoryItem> ape = createFolder("APE");
        FilterableTreeItem<CategoryItem> gofros = createFolder("Gofros");
        FilterableTreeItem<CategoryItem> prakalimoVamzdis = createFolder("Prakalimo vamzdis");
        FilterableTreeItem<CategoryItem> sudedamasVazdis = createFolder("Sudedamas vazdis");

        //Vamzdžiai ir gofra - lauko add
        lauko.getInternalChildren().add(ape);
        lauko.getInternalChildren().add(gofros);
        lauko.getInternalChildren().add(prakalimoVamzdis);
        lauko.getInternalChildren().add(sudedamasVazdis);

        //Vamzdžiai ir gofra - vidaus
        FilterableTreeItem<CategoryItem> vGofros = createFolder("Gofros");
        FilterableTreeItem<CategoryItem> behalogeninėsGofros = createFolder("Behalogeninės gofros");
        FilterableTreeItem<CategoryItem> vamzdžiai = createFolder("Vamzdžiai");
        FilterableTreeItem<CategoryItem> behalogeniniaiVamzdžiai = createFolder("Behalogeniniai vamzdžiai");
        FilterableTreeItem<CategoryItem> gofrosSuKabeliu = createFolder("Gofros su kabeliu");
        FilterableTreeItem<CategoryItem> gofrosSuLaidu = createFolder("Gofros su laidu");

        //Vamzdžiai ir gofra - vidaus add
        vidaus.getInternalChildren().add(vGofros);
        vidaus.getInternalChildren().add(behalogeninėsGofros);
        vidaus.getInternalChildren().add(vamzdžiai);
        vidaus.getInternalChildren().add(behalogeniniaiVamzdžiai);
        vidaus.getInternalChildren().add(gofrosSuKabeliu);
        vidaus.getInternalChildren().add(gofrosSuLaidu);

        //Vamzdžiai ir gofra - lauko
        FilterableTreeItem<CategoryItem> g450N = createFolder("g450N");
        FilterableTreeItem<CategoryItem> g750N = createFolder("g750N");
        FilterableTreeItem<CategoryItem> g1250N = createFolder("g1250N");

        //Vamzdžiai ir gofra - vidaus
        FilterableTreeItem<CategoryItem> vG320N = createFolder("320N");
        FilterableTreeItem<CategoryItem> vG750N = createFolder("750N");

        //Vamzdžiai ir gofra - lauko add
        gofros.getInternalChildren().add(g450N);
        gofros.getInternalChildren().add(g750N);
        gofros.getInternalChildren().add(g1250N);

        //Vamzdžiai ir gofra - vidaus add
        vGofros.getInternalChildren().add(vG320N);
        vGofros.getInternalChildren().add(vG750N);

        //Instaliacinės prekės - Jungikliai ir kištukiniai lizdai
        FilterableTreeItem<CategoryItem> potinkiniaiJungikliai = createFolder("Potinkiniai jungikliai ir kištukiniai lizdai");
        FilterableTreeItem<CategoryItem> virstinkiniaiJungikliai = createFolder("Virštinkiniai jungikliai ir kištukiniai lizdai");
        FilterableTreeItem<CategoryItem> pramoniniaiLizdai = createFolder("Pramoniniai lizdai ir kištukai");

        //Instaliacinės prekės - Jungikliai ir kištukiniai lizdai add
        jungikliaiIrKistukiniaiLizdai.getInternalChildren().add(potinkiniaiJungikliai);
        jungikliaiIrKistukiniaiLizdai.getInternalChildren().add(virstinkiniaiJungikliai);
        jungikliaiIrKistukiniaiLizdai.getInternalChildren().add(pramoniniaiLizdai);

        //Instaliacinės prekės - Potinkinės dėžutės
        FilterableTreeItem<CategoryItem> muroDezute = createFolder("Dėžutė į mūrą");
        FilterableTreeItem<CategoryItem> gipsoDezute = createFolder("Dėžutė į gipsą");

        //Instaliacinės prekės - Potinkinės dėžutės add
        potinkinesDezutes.getInternalChildren().add(muroDezute);
        potinkinesDezutes.getInternalChildren().add(gipsoDezute);
        //Instaliacinės prekės - Šildymo elementai
        FilterableTreeItem<CategoryItem> sildymoKilimėliai = createFolder("Šildymo kilimėliai");
        FilterableTreeItem<CategoryItem> sildymoKabeliai = createFolder("Šildymo kabeliai");
        FilterableTreeItem<CategoryItem> sildymoĮranga = createFolder("Šildymo įranga");

        //Instaliacinės prekės - Šildymo elementai add
        sildymoElementai.getInternalChildren().add(sildymoKilimėliai);
        sildymoElementai.getInternalChildren().add(sildymoKabeliai);
        sildymoElementai.getInternalChildren().add(sildymoĮranga);

        //Instaliacinės prekės - Grindinės dėžutės
        FilterableTreeItem<CategoryItem> gridninesPlastikinesDezutes = createFolder("Plastikinės");
        FilterableTreeItem<CategoryItem> grindinesMetalinesDezutes = createFolder("Metalinės");

        //Instaliacinės prekės - Grindinės dėžutės add
        grindinesDezutes.getInternalChildren().add(gridninesPlastikinesDezutes);
        grindinesDezutes.getInternalChildren().add(grindinesMetalinesDezutes);

        //Instaliacinės prekės - Judesio ir būvio jutikliai
        FilterableTreeItem<CategoryItem> judesio = createFolder("Judesio");
        FilterableTreeItem<CategoryItem> buvio = createFolder("Būvio");

        //Instaliacinės prekės - Judesio ir būvio jutikliai add
        judesioIrBuvioJutikliai.getInternalChildren().add(judesio);
        judesioIrBuvioJutikliai.getInternalChildren().add(buvio);

        //Instaliacinės prekės - Judesio ir būvio jutikliai Judesio
        FilterableTreeItem<CategoryItem> virstinkiniai = createFolder("Virštinkiniai");
        FilterableTreeItem<CategoryItem> potinkiniai = createFolder("Potinkiniai");

        //Instaliacinės prekės - Judesio ir būvio jutikliai Būvio
        FilterableTreeItem<CategoryItem> virstinkiniaiB = createFolder("Virštinkiniai");
        FilterableTreeItem<CategoryItem> potinkiniaiB = createFolder("Potinkiniai");

        //Instaliacinės prekės - Judesio ir būvio jutikliai Judesio add
        judesio.getInternalChildren().add(virstinkiniai);
        judesio.getInternalChildren().add(potinkiniai);
        //Instaliacinės prekės - Judesio ir būvio jutikliai Būvio add
        buvio.getInternalChildren().add(virstinkiniaiB);
        buvio.getInternalChildren().add(potinkiniaiB);

        //Įžeminimas ir žaibosauga - Įžeminimo strypai
        izeminimoStrypai.getInternalChildren().add(variuotiStrypai);
        izeminimoStrypai.getInternalChildren().add(cinkuotiStrypai);

        //Metalinės konstrukcijos - kopecios
        FilterableTreeItem<CategoryItem> kopKarstoCinkavimo = createFolder("Karšto cinkavimo");
        FilterableTreeItem<CategoryItem> kopSaltoCinkavimo = createFolder("Šalto cinkavimo");

        //Metalinės konstrukcijos - loveliai
        FilterableTreeItem<CategoryItem> lovKarstoCinkavimo = createFolder("Karšto cinkavimo");
        FilterableTreeItem<CategoryItem> lovSaltoCinkavimo = createFolder("Šalto cinkavimo");

        //Metalinės konstrukcijos - kopecios
        kopecios.getInternalChildren().add(kopKarstoCinkavimo);
        kopecios.getInternalChildren().add(kopSaltoCinkavimo);

        //Metalinės konstrukcijos - loveliai
        loveliai.getInternalChildren().add(lovKarstoCinkavimo);
        loveliai.getInternalChildren().add(lovSaltoCinkavimo);

        //Elektromechanika - Automatiniai jungikliai
        FilterableTreeItem<CategoryItem> e6kA = createFolder("6kA");
        FilterableTreeItem<CategoryItem> e10kA = createFolder("10kA");

        //Elektromechanika - Kirtikliai
        FilterableTreeItem<CategoryItem> moduliniai = createFolder("Moduliniai");
        FilterableTreeItem<CategoryItem> paneliniai = createFolder("Paneliniai");

        //Elektromechanika - Automatiniai jungikliai
        automatiniaiJungikliai.getInternalChildren().add(e6kA);
        automatiniaiJungikliai.getInternalChildren().add(e10kA);

        //Elektromechanika - Kirtikliai
        kirtikliai.getInternalChildren().add(moduliniai);
        kirtikliai.getInternalChildren().add(paneliniai);

        return root;
    }


    public void loadColumnToTable() {

        TableColumn number = new TableColumn("No.");
        TableColumn id = new TableColumn("Id");
        TableColumn catalogNo = new TableColumn("catalogNo");
        TableColumn symbol = new TableColumn("symbol");
        TableColumn priceNet = new TableColumn("priceNet");
        TableColumn stock = new TableColumn("stock");

        table.getColumns().addAll(number, id, catalogNo, symbol, priceNet, stock);

        number.prefWidthProperty().bind(table.widthProperty().multiply(0.07));
        id.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
        catalogNo.prefWidthProperty().bind(table.widthProperty().multiply(0.23));
        symbol.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
        priceNet.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
        stock.prefWidthProperty().bind(table.widthProperty().multiply(0.194));

        number.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ProductCatalog, ProductCatalog>, ObservableValue<ProductCatalog>>() {
            @Override
            public ObservableValue<ProductCatalog> call(TableColumn.CellDataFeatures<ProductCatalog, ProductCatalog> p) {
                return new ReadOnlyObjectWrapper(p.getValue());
            }
        });

        number.setCellFactory(new Callback<TableColumn<ProductCatalog, ProductCatalog>, TableCell<ProductCatalog, ProductCatalog>>() {
            @Override
            public TableCell<ProductCatalog, ProductCatalog> call(TableColumn<ProductCatalog, ProductCatalog> param) {
                return new TableCell<ProductCatalog, ProductCatalog>() {
                    @Override
                    protected void updateItem(ProductCatalog item, boolean empty) {
                        super.updateItem(item, empty);

                        if (this.getTableRow() != null && item != null) {
                            setText(this.getTableRow().getIndex() + 1 + "");
                        } else {
                            setText("");
                        }
                    }
                };
            }
        });
        number.setSortable(false);
        id.setCellValueFactory(new PropertyValueFactory<ProductCatalog, String>("Id"));
        catalogNo.setCellValueFactory(new PropertyValueFactory<ProductCatalog, String>("catalogNo"));
        symbol.setCellValueFactory(new PropertyValueFactory<ProductCatalog, String>("symbol"));
        priceNet.setCellValueFactory(new PropertyValueFactory<ProductCatalog, String>("priceNet"));
        stock.setCellValueFactory(new PropertyValueFactory<ProductCatalog, String>("stock"));

        number.setResizable(false);
        id.setResizable(false);
        catalogNo.setResizable(false);
        symbol.setResizable(false);
        priceNet.setResizable(false);
        stock.setResizable(false);

    }

    public void loadDataToTable(ProductCatalog productCatalog) {

        table.getItems().add(productCatalog);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadColumnToTable();
        createContents();
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

        Window parent = open_file.getScene().getWindow();

        List<ProductCatalog> excelProducts = null;
        List<ProductCatalog> dbProducts = ProductCatalogDAO.displayAllItems();

        try {
            excelProducts = ReadExcelWithProductCatalog.readFileUsingPOI(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int countAffectedProducts = 0;
        int countExcelProducts = 0;
        int countNewProducts = 0;
        int countDBProduducts = 0;

        for (ProductCatalog excelProduct : excelProducts) {
            countExcelProducts++;

            boolean isNewProduct = true;

            for (ProductCatalog dbProduct : dbProducts) {


                if (dbProduct.getPriceNet() != excelProduct.getPriceNet() && dbProduct.getCatalogNo() == excelProduct.getCatalogNo()) {
                    isNewProduct = false;
                    ProductCatalogDAO.updateByCatalog_no(excelProduct.getPriceNet(), dbProduct.getId());
                    countAffectedProducts++;

                } else if (dbProduct.getPriceNet() == excelProduct.getPriceNet()) {
                    isNewProduct = false;
                    countDBProduducts++;
                }

            }
            if (isNewProduct) {
                countNewProducts++;
                ProductCatalogDAO.insert(excelProduct);
            }
        }

        Label label = new Label("Pakeista produktų :" + " " + countAffectedProducts + "\n" +
                "Excel'yje yra produktų : " + countExcelProducts + "\n" +
                "Pridėta naujų produktų : " + countNewProducts + "\n" +
                "Duombazėje nepakeistų produktų : " + countDBProduducts);
        final Popup popup = new Popup();
        Button hide = new Button("Ok");
        hide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popup.hide();
            }
        });
        hide.setLayoutX(140);
        hide.setLayoutY(115);
        label.setStyle(" -fx-background-color: grey; -fx-text-fill: white;");
        label.setMinWidth(300);
        label.setMinHeight(150);
        label.setAlignment(Pos.CENTER);
        popup.getContent().addAll(label, hide);
        if (countAffectedProducts > 0) {
            popup.show(parent);
        }

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

    /**
     * NUO CIA PRASIDEDA AKTYVAUS FILTRAVIMO KODAS
     */

    public TitledPane leftTitledPane;
    TreeView<CategoryItem> treeView = new TreeView<>();


    public void createContents() {
        VBox vBoxElement = new VBox(6);
        vBoxElement.getChildren().add(createFilterPane());
        Node demoPane = createDemoPane();
        VBox.setVgrow(demoPane, Priority.ALWAYS);
        vBoxElement.getChildren().add(demoPane);
    }


    private Node createFilterPane() {
        paieskosLaukelis.setPromptText("Įveskite kategorijos pavadinimą filtravimui ...");
        TitledPane pane = new TitledPane("Filter", paieskosLaukelis);
        pane.setCollapsible(false);
        return pane;
    }

    private Node createDemoPane() {
        HBox hBoxElement = new HBox(6);
        Node filteredTree = createFilteredTree();
        HBox.setHgrow(filteredTree, Priority.ALWAYS);
        hBoxElement.getChildren().add(filteredTree);
        leftTitledPane.setContent(filteredTree);
        return new BorderPane(hBoxElement);
    }

    private Node createFilteredTree() {
        FilterableTreeItem<CategoryItem> root = loadsProductsToCatalogTree();
        root.predicateProperty().bind(Bindings.createObjectBinding(() -> {
            if (paieskosLaukelis.getText() == null || paieskosLaukelis.getText().isEmpty())
                return null;
            return TreeItemPredicate.create(categoryItem -> categoryItem.toString().contains(paieskosLaukelis.getText()));
        }, paieskosLaukelis.textProperty()));

        treeView.setRoot(root);
        treeView.setShowRoot(false);
        treeView.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                TreeItem<CategoryItem> item = treeView.getSelectionModel().getSelectedItem();
                System.out.println(item.getValue().getName());
                List<Categories> categories = CategoriesDAO.selectCategory(item.getValue().getName());
                List<ProductCatalog> products = ProductCatalogDAO.displayAllItems();
                int number = 0;
                table.getItems().clear();
                for (Categories category : categories) {
                    for (ProductCatalog product : products) {
                        if (category.getId() == product.getGroupId()) {
                            number++;
                            loadDataToTable(product);
                        }
                    }
                }
                countAll.setText("Išviso įrašų : " + number);
            }
        });
        return treeView;
    }


    private FilterableTreeItem<CategoryItem> createFolder(String name) {
        FilterableTreeItem<CategoryItem> folder = new FilterableTreeItem<>(new CategoryItem(name));


        return folder;
    }


}


