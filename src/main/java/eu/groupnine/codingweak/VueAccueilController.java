package eu.groupnine.codingweak;

import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;

public class VueAccueilController implements Observer, Initializable{
    
    Model model;

    @FXML
    ListView<String> PileSpace;

    @FXML
    Button PlayButton;

    @FXML
    Button DeleteButton;

    @FXML
    Button SeetingsButton;

    @FXML
    Button AddButton;
    
    
    public VueAccueilController(Model model){
        this.model = model;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PlayButton.setDisable(true);
        DeleteButton.setDisable(true);
        SeetingsButton.setDisable(true);
        chargePile();
        
    }
    


    public void chargePile(){
        //Obtenir l'ensemble des clés du dictionnaire
        Set<String> pileNames = model.stockFromDisk.EnsembleDesPiles.keySet();
        // for (Map.Entry<String, Pile> pileSet : model.stockFromDisk.EnsembleDesPiles.entrySet()) {
        //     String NameDescription;
        //     String Name= model.stockFromDisk.EnsembleDesPiles.get(pileSet.getKey()).getNom();
        //     String Description= model.stockFromDisk.EnsembleDesPiles.get(pileSet.getValue()).getDescription();
        //     NameDescription = Name + "   :  " + Description;
        //     PileSpace.getItems().add(NameDescription);
        if (pileNames == null){
            return;
        }

        for (String pileName : pileNames) {
            String NameDescription;
            String Name= model.stockFromDisk.EnsembleDesPiles.get(pileName).getNom();
            String Description= model.stockFromDisk.EnsembleDesPiles.get(pileName).getDescription();
            NameDescription = Name + " : " + Description;
            PileSpace.getItems().add(NameDescription);
        }
    }

    public void Play(){
        model.sc.afficherParent("Jeu");
    }

    public void Seetings(){
        model.sc.afficherParent("Reglage");
    }


    public void addPile(){
        model.sc.afficherParent(null);
    }

    public void ActivateButton(){
        PlayButton.setDisable(false);
        DeleteButton.setDisable(false);
        SeetingsButton.setDisable(false);
    }
    


    public void refresh(){
        model.callObservers();
    }


}
