package eu.groupnine.codingweak;

import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class VueJouerController implements Observer, Initializable{
    Model model;

    @FXML
    TextField valeurTemps,valeurFrequence;

    @FXML
    Button boutonJouer;

    @FXML
    CheckBox valeurSmartMode;

    @FXML
    ChoiceBox<String> valeurOrdre;

    public VueJouerController(Model model){
        this.model = model;
    }

    public void choixTemps() throws Exception{
        
        if (Long.parseLong(valeurTemps.getText())>0 || valeurTemps.getText()!="") {
            model.time = Long.parseLong(valeurTemps.getText());
            }
        else {
            model.time = 3;
            empecherJouer();
        }
    }

    public void choixOrdre(){
        model.ordrePile = true;
        if (valeurOrdre.getSelectionModel().getSelectedItem().equalsIgnoreCase("aléatoire")){
            model.ordrePile = false;

        }
    }

    public void choixFrequence(){
        if (Integer.parseInt(valeurFrequence.getText())>0) {
        model.frequencePile = Integer.parseInt(valeurFrequence.getText());
        }
        else {
            model.frequencePile = 1;
            empecherJouer();
        }
    }

    public void choixSmartMode(){
        model.smartModePile = false;
        if (valeurSmartMode.isSelected()) {
            model.smartModePile = true;
        }
    }
    
    public void choixJouer() throws Exception{
        this.choixTemps();
        this.choixOrdre();
        this.choixFrequence();
        this.choixSmartMode();
        model.reinit();
        if (!model.checkPile()){
            System.err.println("Error with the Pile: Can't Play");
            return;
        }
        model.sc.afficherParent("Jeu");
        model.sc.callFunctFromController("startQuestion");
        this.model.gestionFrequence();
        this.model.mettreOrdreCartesAleat();
        model.callObservers();
    }

    @FXML
    public void empecherJouer(){
        this.boutonJouer.setDisable(true);
    }


    public void refresh(){
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image1 = new Image(getClass().getResource("/icone/jouer.png").toExternalForm()); 
        ImageView icon1 = new ImageView(image1);
        icon1.setFitWidth(50);
        icon1.setFitHeight(50); 
        boutonJouer.setGraphic(icon1);
       boutonJouer.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        
    }
}
