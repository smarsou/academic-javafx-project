package eu.groupnine.codingweak.controller;

import eu.groupnine.codingweak.Model;

public class VueQuestionController implements Observer{
    Model model;

    public VueQuestionController(Model model){
        this.model = model;
    }
    public void refresh(){
        
    }
}
