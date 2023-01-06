package eu.groupnine.codingweak;

import java.net.URL;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import eu.groupnine.codingweak.stockage.Carte;
import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

public class VueQuestionController implements Observer {
    private Model model;

    @FXML
    private Label Question;

    @FXML
    private Label Reponse;
    @FXML
    private Label cartesRestantes;
    @FXML
    private ProgressBar progressbar;
                                                               
    @FXML
    private Button trouve;

    @FXML
    private Button pastrouve;

    @FXML
    private Button brep;

    private Timeline timeline;
    private Carte currentCarte;
    

    private static int indexCourant = 0;

    public void start()  {
        this.model.setCard();
        System.out.println("Game started");
        currentCarte = this.model.nexCarte();

        this.refresh();
        Answer();
        
        
    }
    
    public VueQuestionController(Model model){
        this.model = model;
        this.model.observers.add(this);
        
        // this.model.setCard();

    }

    @FXML
    public void ShowAnswer()  {
        
        
        int id = VueQuestionController.indexCourant;
        
        Carte c = this.model.PileCartes.get(id);
        
        this.Reponse.setText(c.getReponse());
        this.pastrouve.setVisible(true);
        this.trouve.setVisible(true);
        this.trouve.setDisable(false);
        this.pastrouve.setDisable(false);
        this.brep.setDisable(true);
        this.brep.setVisible(false);
        this.timeline.stop();

    }

    public void Answer()  {
        //Set Time
        this.timeline = new Timeline(
        new KeyFrame(Duration.ZERO, new KeyValue(this.progressbar.progressProperty(), 0)),
        new KeyFrame(Duration.seconds(this.model.time), e-> {
            // do anything you need here on completion...
            int id = VueQuestionController.indexCourant;
            Carte c = this.model.PileCartes.get(id);
            this.Reponse.setText(c.getReponse());
            this.pastrouve.setVisible(true);
            this.trouve.setVisible(true);
            this.trouve.setDisable(false);
            this.pastrouve.setDisable(false);
            this.brep.setDisable(true);
            this.brep.setVisible(false);
            //this.fin = true;
            this.timeline.stop();
            //System.out.println("Minute over");
        }, new KeyValue(this.progressbar.progressProperty(), 1)));
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.play();
        
        //timeline.stop();
        
        
    }
    @FXML
    public void Found()  {
        //mettre à jour les stats
        this.model.currentStats.cartesJouees++;
        this.model.currentStats.cartesTrouvees++;


        //Passer à carte suivante
        if (model.indexCurrentCarte < this.model.PileCartes.size()-1) {
            model.indexCurrentCarte++;
            this.refresh();
            this.Answer();
            currentCarte = this.model.nexCarte();

            //this.timeline.stop();

        }else{
            model.sc.afficherParent("StatPartie");
            model.callObservers();
        }

    }

    @FXML
    public void NotFound()  {
        // pour mettre à jour les stats
        
        this.model.currentStats.cartesJouees++;
        this.model.currentStats.cartesNonTrouvees++;
        this.model.ajouterCarteSmart();
        //Passer à carte suivante
        if (model.indexCurrentCarte < this.model.PileCartes.size()-1) {
            model.indexCurrentCarte++;
            this.refresh();
            this.Answer();
            currentCarte = this.model.nexCarte();

            //this.timeline.stop();

        }else{
            model.sc.afficherParent("StatPartie");
            model.callObservers();
        }
    }


    public void refresh()  {
        //choisir question et reponses dans pile
        this.Reponse.setText(null);
        int id = VueQuestionController.indexCourant;
        // Carte card = this.model.PileCartes.get(id);
        // Carte card = this.model.nexCarte();
        
        this.Question.setText(currentCarte.getQuestion());
        this.brep.setVisible(true);
        this.brep.setDisable(false);
        this.pastrouve.setDisable(true);
        this.trouve.setDisable(true);
        this.pastrouve.setVisible(false);
        this.trouve.setVisible(false);
        this.cartesRestantes.setText(Integer.toString(model.PileCartes.size()-model.indexCurrentCarte));
        
    }
}
