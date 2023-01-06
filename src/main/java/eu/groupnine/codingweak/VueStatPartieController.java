package eu.groupnine.codingweak;

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
                new PieChart.Data("Réponses justes", stats.cartesTrouvees),
                new PieChart.Data("Réponses fausses", stats.cartesNonTrouvees));
        return pieChartData;
    }
    public void saveStats() throws IOException {
        //model.stockFromDisk.EnsembleDesPiles.get(model.keyClicked).addStats(this.stats.cartesNonTrouvees,this.stats.cartesTrouvees, this.stats.cartesJouees, this.stats.cartesParMinutes, this.stats.tempsPasse, "aaaa", CalculTaux());
        System.out.println("aaaaaaaaaaaa    " + model.currentStats.cartesNonTrouvees);
        model.stockFromDisk.save();
    }

    public void refresh(){
        this.stats = model.currentStats;
        System.out.println("Refresh stats");
        System.out.println(stats.cartesJouees + " " + stats.tempsPasse);
        float cpmValue = 60*stats.cartesJouees/stats.tempsPasse;
        cpm.setText(Float.toString(cpmValue));
        temps.setText(Float.toString(stats.tempsPasse));
        resultat.setData(initializeData());
        resultat.setLabelsVisible(true);
    }

    public Float CalculTaux(){
        if (this.stats.cartesNonTrouvees == 0){
            return (float) (this.stats.cartesTrouvees);
        }
        else{
            Float taux = (float) (this.stats.cartesTrouvees/this.stats.cartesNonTrouvees);
            return taux;
        }
    }
}