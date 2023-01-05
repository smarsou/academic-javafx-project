package eu.groupnine.codingweak;

import eu.groupnine.codingweak.stockage.Stats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class VueStatPartieController implements Observer{
    Model model;
    Stats stats = new Stats();
    @FXML
    private PieChart resultat;
    public VueStatPartieController(Model model){

        this.model = model;
        model.observers.add(this);
    }

    public void home(){
        model.sc.afficherParent("Page");
    }

    public PieChart initializeData(){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Réponses justes", stats.cartesTrouvees),
                new PieChart.Data("Réponses fausses", stats.cartesNonTrouvees) );
        return new PieChart(pieChartData);
    }
    public void saveStats(){
    }
    public void refresh(){
        System.out.println("Refresh stats");
        resultat = initializeData();
        resultat.setLabelsVisible(true);
    }
}