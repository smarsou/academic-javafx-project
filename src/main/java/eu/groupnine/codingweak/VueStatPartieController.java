package eu.groupnine.codingweak;

import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

import java.io.IOException;

public class VueStatPartieController implements Observer{
    Model model;
    Stats stats = new Stats();

    @FXML private Label cpm;
    @FXML private Label temps;

    @FXML
    private PieChart resultat = new PieChart();
    public VueStatPartieController(Model model){

        this.model = model;
        model.observers.add(this);
        this.stats = model.currentStats;

    }

    public void home(){
        model.sc.afficherParent("Page");
        model.callObservers();
    }

    public ObservableList<PieChart.Data> initializeData(){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Correct: " + stats.cartesTrouvees, stats.cartesTrouvees),
                new PieChart.Data("Faux: " + stats.cartesNonTrouvees, stats.cartesNonTrouvees));
        return pieChartData;
    }

    public void saveStats() throws IOException {
        model.stockFromDisk.EnsembleDesPiles.get(model.keyClicked).addStats(this.stats.cartesNonTrouvees,this.stats.cartesTrouvees, this.stats.cartesJouees, this.stats.cartesParMinutes, this.stats.tempsPasse, "" + this.stats.taux.nombrePartieJouer.size(), CalculTaux(model.getCurrentPile()));
        model.stockFromDisk.save();
    }

    public void refresh(){
        this.stats = model.currentStats;
        float cpmValue = 0;
        // 60*stats.cartesJouees/stats.tempsPasse;
        if (model.currentStats.cartesJouees != 0){
            cpm.setText(model.currentStats.cartesTrouvees*100/model.currentStats.cartesJouees+ " %");
        }
        // temps.setText(Float.toString(stats.tempsPasse));
        resultat.setData(initializeData());
        resultat.setLabelsVisible(true);
    }

    public Float CalculTaux(Pile pile){
        Float taux = (float) (this.stats.cartesTrouvees/pile.stats.taux.nombrePartieJouer.size());
        return taux;
    }
    
}