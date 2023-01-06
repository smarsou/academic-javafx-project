package eu.groupnine.codingweak;

import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class VueJouerController implements Observer{
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
        
        if (Long.parseLong(valeurTemps.getText())>0) {
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

    }

    @FXML
    public void empecherJouer(){
        this.boutonJouer.setDisable(true);
    }


    public void refresh(){
        
    }
}
