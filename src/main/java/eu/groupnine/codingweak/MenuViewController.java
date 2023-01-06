package eu.groupnine.codingweak;



import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eu.groupnine.codingweak.stockage.Carte;
import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuViewController implements Observer, Initializable{

    private static Model model;
    public static Stage stage;

    @FXML private Menu menuEdit;
    @FXML private Menu menuOpen;
    @FXML private Label alert;

    String alertMess;

    public MenuViewController(){
        model.observers.add(this);
    }

    public static void setModel(Model m){
        model = m;
    }

    public void accueil(){
        model.sc.afficherParent("Page");
        model.callObservers();
    }

    public void fermer(){
        Platform.exit();
    }

    public void openStats(){
        model.sc.afficherParent("StatGlobal");
        model.callObservers();
    }

    public void importPile() throws IOException,NullPointerException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open JSON file");
        fileChooser.getExtensionFilters().setAll(
     new FileChooser.ExtensionFilter("Text Files", "*.json")
);
        File file = fileChooser.showOpenDialog(stage);
        try{
        model.stockFromDisk.loadFrom(file.getAbsolutePath());
        }catch(NullPointerException e){
            System.err.println("Can't load File");
        }
        model.callObservers();
        
    }


    public void exportPile() throws IOException {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(stage);

        if ( selectedDirectory == null){
            System.err.println("ERROR: path not found");
        }else{
            model.stockFromDisk.saveAt(selectedDirectory.getAbsolutePath()+"/export.json");
        }
        model.callObservers();
    }

    public void refresh(){
        if (model.sc.strMain != "Page"){
            menuEdit.setVisible(false);
        }else{
            menuEdit.setVisible(true);
        }
    }

    public void setIcone(){
        Image image1 = new Image(getClass().getResource("/icone/reglages.png").toExternalForm()); 
        ImageView icon1 = new ImageView(image1);
        icon1.setFitWidth(20);
        icon1.setFitHeight(20); 
        menuOpen.setGraphic(icon1);
        Image image2 = new Image(getClass().getResource("/icone/export.png").toExternalForm()); 
        ImageView icon2 = new ImageView(image2);
        icon2.setFitWidth(20);
        icon2.setFitHeight(20); 
        menuEdit.setGraphic(icon2);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setIcone();
        
    }


}