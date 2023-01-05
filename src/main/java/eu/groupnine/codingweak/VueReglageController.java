package eu.groupnine.codingweak;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import eu.groupnine.codingweak.stockage.Carte;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class VueReglageController implements Observer {
    Model model;
    @FXML
    private TextField  NomPile;

    @FXML
    private TextField Description;

    @FXML
    private TableView<Carte> Table;

    @FXML
    private TableColumn<Carte, Integer> idCartes;

    @FXML
    private TableColumn<Carte, String> Questions;

    @FXML
    private TableColumn<Carte, String> Reponses;

    @FXML
    private TextArea question;

    @FXML
    private TextArea reponse;

    @FXML
    private TextField idCarte;

    @FXML
    private Label nbCartes;






    public VueReglageController(Model model){
        this.model = model;
        this.model.observers.add(this);
    }

    



    @FXML
    public void rowClicked() {
        Carte clickCarte = this.Table.getSelectionModel().getSelectedItem();
        if (clickCarte != null) {
            this.idCarte.setText(clickCarte.getId()+"");
            this.question.setText(clickCarte.getQuestion());
            this.reponse.setText(clickCarte.getReponse());

        }

    }

    @FXML
    public void Register() {

    }



    @FXML
    public void Modify()  {
        int id = Integer.parseInt(this.idCarte.getText());
        String q = this.question.getText();
        String rep = this.reponse.getText();
        this.model.ModifyQuestionCarte(id,q);
        this.model.ModifyReponseCarte(id,rep);
        this.model.callObservers();
        this.question.setText(null);
        this.reponse.setText(null);

    }

    @FXML
    public void Create()  {
        String q = this.question.getText();
        String rep = this.reponse.getText();
        int indLast = this.model.PileCartes.size() -1;
        int lastId = this.model.PileCartes.get(indLast).getId();
        this.model.PileCartes.add(new Carte(lastId+1, q, rep));
        this.model.callObservers();
        this.question.setText(null);
        this.reponse.setText(null);

        


    }



    public void refresh(){
        this.idCartes.setCellValueFactory(new PropertyValueFactory<Carte, Integer>("IdCartes"));
        this.Questions.setCellValueFactory(new PropertyValueFactory<Carte, String>("Questions"));
        this.Reponses.setCellValueFactory(new PropertyValueFactory<Carte, String>("Reponses"));
        this.Table.getItems().clear();
        
        ArrayList<Carte> CurrentCartes = this.model.getCurrentPile().cartes;
        System.out.println(CurrentCartes.get(0));
        for (int i = 0;i<CurrentCartes.size();i++) {
            this.Table.getItems().add(CurrentCartes.get(i));
        }
        this.nbCartes.setText(CurrentCartes.size() + " " +"Cartes");

        
    }

    
}
