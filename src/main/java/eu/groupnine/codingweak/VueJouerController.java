package eu.groupnine.codingweak;

import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javafx.scene.input.MouseEvent;

public class VueJouerController implements Observer{
    Model model;

    @FXML
    TextField valeurTemps;
    
    @FXML
    TextField valeurFrequence;

    @FXML
    Button boutonJouer;

    @FXML
    CheckBox valeurSmartMode;

    @FXML
    ChoiceBox<String> valeurOrdre;

    /* label pour page d'erreur */
    @FXML
    Label texteErreur;

    public VueJouerController(Model model){
        this.model = model;

        // EventHandler<KeyEvent> eventHandlerTextField = new EventHandler<KeyEvent>() { 
        //     @Override 
        //     public void handle(KeyEvent event) { 
        //         System.out.println("ouiiiiii");
        //     }           
        // };

        // //Handling the mouse clicked event(on box) 
        // EventHandler<MouseEvent> eventHandlerBox = new EventHandler<javafx.scene.input.MouseEvent>() {
        //     @Override 
        //     public void handle(javafx.scene.input.MouseEvent e) { 
        //         System.out.println("ouiiiiii"); 
        //     } 


        // };

        // if (valeurTemps != null){

        //     valeurTemps.addEventHandler(KeyEvent.KEY_TYPED, eventHandlerTextField);
        //     valeurTemps.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandlerBox);

        // }
        // else { 
        //     valeurTemps = new TextField("5");

        //     valeurTemps.addEventHandler(KeyEvent.KEY_TYPED, eventHandlerTextField);
        //     valeurTemps.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandlerBox);
        // }
    }

    public void choixTemps() throws Exception{
        
        if (Long.parseLong(valeurTemps.getText())>0 ) {
            model.time = Long.parseLong(valeurTemps.getText());
            }
        else {
            model.time = 3;
        }
    }




    // public void actionTemps(){

    //     if (valeurTemps.getText().isEmpty()){
    //     }
    //     if (Long.parseLong(valeurTemps.getText()) <0 || Long.parseLong(valeurTemps.getText()) >30){
    //     }
    // }

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

        empecherJouer("Attention, le temps et la fréquence choisis doiventt être des entiers positifs.");
    }

    public void empecherJouer(String textVoulu) throws IOException{
        
        
        this.boutonJouer.setDisable(true);
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("VueErreur.fxml"));
        loader.setControllerFactory(iC->this);
        Parent rootPage = loader.load();

        // afficher les données de la page
        texteErreur.setText(textVoulu);
        Scene scene = new Scene(rootPage);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    public void refresh(){
        
    }
}
