package eu.groupnine.codingweak;

import java.util.ArrayList;

public abstract class Observateur {
    ArrayList<Observer> observers;

    public void callObservers() throws InterruptedException{
        for (Observer ob : observers){
            ob.refresh();
        }
    }
}
