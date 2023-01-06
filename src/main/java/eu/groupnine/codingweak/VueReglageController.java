package eu.groupnine.codingweak;

import java.net.URL;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.ResourceBundle;

import eu.groupnine.codingweak.stockage.Carte;
import eu.groupnine.codingweak.stockage.Pile;
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
        this.model.setCard();
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
        Pile p = this.model.getCurrentPile();
        p.getNom();
        p.getDescription();
        String n = this.NomPile.getText();
        String d = this.Description.getText();
        if ((n != null)&&(d != null)) {
            this.model.getCurrentPile().setNom(n);
            this.model.getCurrentPile().setDescription(d);
            this.model.callObservers();

        }
        this.NomPile.setText(null);
        this.Description.setText(null);
        this.idCarte.setText(null);
        this.question.setText(null);
            
        this.reponse.setText(null);

    }



    @FXML
    public void Modify()  {
        String ind = this.idCarte.getText();
        if (ind != null) {
            int id = Integer.parseInt(ind);
            String q = this.question.getText();
            String rep = this.reponse.getText();
            Carte c = this.model.getCard(id);
            if (c != null) {
                this.model.ModifyQuestionCarte(this.model.PileCartes.indexOf(c),q);
            
                this.model.ModifyReponseCarte(this.model.PileCartes.indexOf(c),rep);
            
                this.model.callObservers();

            }
            
            this.idCarte.setText(null);
            this.question.setText(null);
            this.reponse.setText(null);

        }
        
    }

    @FXML
    public void Create()  {
        
        String q = this.question.getText();
        String rep = this.reponse.getText();
        if ((q != null)&&(rep != null)) {
            int indLast = this.model.PileCartes.size() -1;

            int lastId = this.model.PileCartes.get(indLast).getId();
    
            this.model.PileCartes.add(new Carte(lastId+1, q, rep));
    
            this.model.callObservers();
            this.idCarte.setText(null);
    
            this.question.setText(null);
    
            this.reponse.setText(null);

        }
    }



    @FXML
    public void Supp() {
        String id = this.idCarte.getText();
        String answer = this.reponse.getText();
        String quest = this.question.getText();
        
        for (Carte c : this.model.PileCartes) {
            if ((String.valueOf(c.getId()).equals(id))&&(c.getQuestion().equals(quest))&&(c.getReponse().equals(answer))) {
                
                this.model.suppCarte(this.model.PileCartes.indexOf(c));
                this.model.callObservers();
                break;
            }
           
            
            
        }
        
        
        
        this.idCarte.setText(null);
    
            
        this.question.setText(null);
    
            
        this.reponse.setText(null);


    }
    
    public void refresh() throws NullPointerException{
        try{
        this.NomPile.setText(null);
        this.Description.setText(null);
        Pile p = this.model.getCurrentPile();
        this.NomPile.setText(p.getNom());
        this.Description.setText(p.getDescription());
        
        this.idCartes.setCellValueFactory(new PropertyValueFactory<Carte, Integer>("idcard"));
        this.Questions.setCellValueFactory(new PropertyValueFactory<Carte, String>("infoquestion"));
        this.Reponses.setCellValueFactory(new PropertyValueFactory<Carte, String>("inforeponse"));
        this.Table.getItems().clear();
        
        ArrayList<Carte> CurrentCartes = this.model.PileCartes;
        
        
        
        for (int i = 0;i<CurrentCartes.size();i++) {
            this.Table.getItems().add(CurrentCartes.get(i));
        }
        this.nbCartes.setText(CurrentCartes.size() + " " +"Cartes");
    }catch(NullPointerException exception){
        
    }
        
    }

    
}
