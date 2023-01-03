package eu.groupnine.codingweak.controller;
import eu.groupnine.codingweak.Model;
public class VueReponseController implements Observer{
    Model model;

    public VueReponseController(Model model){
        this.model = model;
    }
    public void refresh(){
        
    }
}
