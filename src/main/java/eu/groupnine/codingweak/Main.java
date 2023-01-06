package eu.groupnine.codingweak;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

import com.google.gson.Gson;

import eu.groupnine.codingweak.stockage.*;
import eu.groupnine.codingweak.MenuViewController;

public class Main extends Application {
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Parent root = FXMLLoader.load(getClass().getResource("Hello.fxml"));
        // Scene scene = new Scene(root);

        // primaryStage.setTitle("CodingWeak");
        // primaryStage.setScene(scene);
        // primaryStage.show();
        Model model = new Model();
        MenuViewController.setModel(model);
        MenuViewController.stage = primaryStage;
        SceneController sc = new SceneController();
        model.sc = sc;
        Parent root = sc.addScene("Page", "accueil-view.fxml", new VueAccueilController(model));
        sc.addScene("Jeu", "VueQuestionReponse.fxml", new VueQuestionController(model));
        sc.addScene("Reglage", "VueReglage.fxml", new VueReglageController(model));
        sc.addScene("Jouer", "VueJouer.fxml", new VueJouerController(model));
        sc.addScene("StatPartie", "VueStatPartie.fxml", new VueStatPartieController(model));
        sc.addScene("StatGlobal", "VueStatGlobal.fxml", new VueStatGlobalController(model));

        Scene scene = new Scene(root);
        sc.setMain(scene, "Page");

        primaryStage.setTitle("CodingWeak");
        primaryStage.setScene(scene);
        primaryStage.show();

<<<<<<< HEAD

        /* essais stockage louis */
        //Stockage stockage = new Stockage();

        //stockage.load();

        //stockage.init();

        //stockage.save();
=======
>>>>>>> 61b392b2b66c00563250e8376b7f352306563daf
        
    }
}
