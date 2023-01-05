package eu.groupnine.codingweak;

import java.util.ArrayList;

public abstract class Observateur {
    ArrayList<Observer> observers;

    public Observateur(){
        observers = new ArrayList<>();
    }

    public void callObservers()  {
        for (Observer ob : observers){
            ob.refresh();
        }
    }
}
