package eu.groupnine.codingweak;

import eu.groupnine.codingweak.stockage.Stats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

import java.io.IOException;

public class VueStatPartieController implements Observer{
    Model model;
    Stats stats = new Stats();


    @FXML
    private PieChart resultat = new PieChart();
    public VueStatPartieController(Model model){

        this.model = model;
        model.observers.add(this);
        this.stats = model.currentStats;
    }

    public void home(){
        model.sc.afficherParent("Page");
    }

    public ObservableList<PieChart.Data> initializeData(){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Réponses justes", stats.cartesTrouvees),
                new PieChart.Data("Réponses fausses", stats.cartesNonTrouvees));
        return pieChartData;
    }
    public void saveStats() throws IOException {
        model.stockFromDisk.EnsembleDesPiles.get(model.keyClicked).addStats(this.stats.cartesNonTrouvees,this.stats.cartesTrouvees, this.stats.cartesJouees, this.stats.cartesParMinutes, this.stats.tempsPasse, "" + this.stats.taux.nombrePartieJouer.size(), CalculTaux());
        model.stockFromDisk.save();
    }

    public void refresh(){
        System.out.println("Refresh stats");
        resultat.setData(initializeData());
        resultat.setLabelsVisible(true);
    }

    public Float CalculTaux(){
        Float taux = (float) (this.stats.cartesTrouvees/this.stats.taux.nombrePartieJouer.size());
        return taux;
    }
}