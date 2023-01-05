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
        model.tempsPile = Long.parseLong(valeurTemps.getText());
    }

    public void choixOrdre(){
        model.ordrePile = true;
        if (valeurOrdre.getSelectionModel().getSelectedItem().equalsIgnoreCase("aléatoire")){
            model.ordrePile = false;
        }
    }

    public void choixFrequence(){
        model.frequencePile = Integer.parseInt(valeurFrequence.getText());
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
        model.sc.afficherParent("Jeu");
        model.sc.callFunctFromController("startQuestion");
    }

    public void refresh(){
        
    }
}
