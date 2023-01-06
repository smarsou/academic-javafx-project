package eu.groupnine.codingweak;

import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javafx.scene.input.MouseEvent;


public class VueJouerController implements Observer, Initializable{
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

    @FXML
    Label titrePile;

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
        
        if (Long.parseLong(valeurTemps.getText())>0 || verifierEntier(valeurTemps)) {
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
        if (Integer.parseInt(valeurFrequence.getText())>0 || verifierEntier(valeurFrequence)) {
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

        if (!empecherJouer()){
            this.choixTemps();
            this.choixOrdre();
            this.choixFrequence();
            this.choixSmartMode();
            
            model.reinit();
            if (!model.checkPile()){
                model.setErrorMessage("Erreur avec le choix de pile: on ne peut pas jouer");
                model.afficherErreur();
                return;
            }
            
    
            model.sc.afficherParent("Jeu");
            model.sc.callFunctFromController("startQuestion");
            this.model.gestionFrequence();
            this.model.mettreOrdreCartesAleat();
            model.callObservers();
        };



        

    }

    public boolean empecherJouer() throws Exception{
        if (!verifierEntier(valeurFrequence) || !verifierEntier(valeurTemps)){
            model.setErrorMessage("Attention, veuillez entrer des valeurs entières");
            model.afficherErreur();
            return true;
        }
        if ((Long.parseLong(valeurTemps.getText())<1) || Integer.parseInt(valeurFrequence.getText())<1 ){
            model.setErrorMessage("Attention, le temps et la fréquence choisis doiventt être des entiers positifs.");
            model.afficherErreur();
            return true;
        }
        if ((Long.parseLong(valeurTemps.getText())>30) || Integer.parseInt(valeurFrequence.getText())>30 ){
            model.setErrorMessage("Attention, le jeu n'est pas intéressant pour un temps ou une fréquence trop élevés, veuillez choisir des valeurs raisonnables");
            model.afficherErreur();
            return true;
        }


    return false;        
    }

    private boolean verifierEntier(TextField f) 
    { 
        try {
            Integer.parseInt(f.getText());
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void refresh(){
        this.titrePile.setText(model.getCurrentPile().getNom());
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
