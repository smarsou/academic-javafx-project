package eu.groupnine.codingweak;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import eu.groupnine.codingweak.stockage.Carte;
import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class VueQuestionController implements Observer, Initializable {
    private Model model;

    @FXML
    private Label Question;

    @FXML
    private Label Reponse;

    @FXML
    private ProgressBar bar;
                                                               
    @FXML
    private Button trouve;

    @FXML
    private Button pastrouve;

    @FXML
    private Button brep;

    private static int indexCourant = 0;

    public void start() throws InterruptedException {
        System.out.println("Game started");
        this.refresh();
        Answer();
        
    }

    public void initialize(URL location,ResourceBundle resouces) {
        int id = VueQuestionController.indexCourant;
        Carte c = this.model.PileCartes.get(id);
        this.Question.setText(c.getQuestion());
        
    }

    public VueQuestionController(Model model){
        this.model = model;
        this.model.setCard();
    }

    @FXML
    public void ShowAnswer() throws InterruptedException {
        
        
        int id = VueQuestionController.indexCourant;
        
        Carte c = this.model.PileCartes.get(id);
        //System.out.println(c.getReponse());
        this.Reponse.setText(c.getReponse());

        this.trouve.setText("TROUVE");
        this.pastrouve.setText("PAS TROUVE");
        this.trouve.setDisable(false);
        this.pastrouve.setDisable(false);
        this.brep.setDisable(true);

    }

    public void Answer() throws InterruptedException {
        //Set Time
        int id = VueQuestionController.indexCourant;
        Carte c = this.model.PileCartes.get(id);
        this.Reponse.setText(c.getReponse());

        this.trouve.setDisable(false);
        this.pastrouve.setDisable(false);
        this.brep.setDisable(true);
        
    }
    @FXML
    public void Found() throws InterruptedException {
        //mettre à jour les stats

        //Passer à carte suivante
        if (VueQuestionController.indexCourant < this.model.PileCartes.size()-1) {
            VueQuestionController.indexCourant++;
            this.refresh();
            this.Answer();

        }

    }

    @FXML
    public void NotFound() throws InterruptedException {
        //mettre à jour les stats
        //Passer à carte suivante
        if (VueQuestionController.indexCourant < this.model.PileCartes.size()-1) {
            VueQuestionController.indexCourant++;
            this.refresh();
            this.Answer();

        }
        
        

    }


    public void refresh() throws InterruptedException {
        //choisir question et reponses dans pile
        int id = VueQuestionController.indexCourant;
        Carte card = this.model.PileCartes.get(id);
        this.Question.setText(card.getQuestion());
        this.brep.setDisable(false);
        //Set le temps
        
        
        
    }
}
