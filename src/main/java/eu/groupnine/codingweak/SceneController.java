package eu.groupnine.codingweak;

import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneController {
    //Le scene controller permet de changer de Scene...
    private HashMap<String, Parent> sceneMap = new HashMap<>();
    public HashMap<String, Observer> controllerMap = new HashMap<>();
    private Scene main;
    public String strMain;

    public SceneController(){}

    public Observer getController(String name){
        return controllerMap.get(name);
    }

    public void setMain(Scene main, String name) throws Exception{
        this.main = main;
        this.strMain = name;
    }
    

    protected Parent addScene(String name, String view, Object controller) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(view));
        loader.setController(controller);
        controllerMap.put(name,loader.getController());
        Parent root = loader.load();
        sceneMap.put(name, root);
        return root;
    }

    protected void removeScene(String name){
        sceneMap.remove(name);
    }

    protected void afficherParent(String name){
        main.setRoot(sceneMap.get(name));
        strMain = name;
    }

    public void callFunctFromController(String name) throws InterruptedException{
        if (name == "startQuestion"){
            if (this.getController("Jeu").getClass().getName() == "eu.groupnine.codingweak.VueQuestionController"){
                VueQuestionController ctrl = (VueQuestionController) this.getController("Jeu");
                ctrl.start();
            };
        }
        
    }
}
