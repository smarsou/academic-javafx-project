package eu.groupnine.codingweak.stockage;

import java.util.ArrayList;

public class Pile {
    private String nom;
    private String description;
    public ArrayList<Carte> cartes;
    public Stats stats;
    public Pile() {
        cartes = new ArrayList<>();
        this.stats = new Stats();
        this.stats.taux = new Couple();
        this.stats.taux.nombrePartieJouer = new ArrayList<String>();
        this.stats.taux.nombrePartieJouer.add("0");
        this.stats.taux.tauxDeReussite = new ArrayList<Float>();
        this.stats.taux.tauxDeReussite.add((float) 0);

    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setDescription(String desc){
        this.description = desc;
    }

    public String getNom(){
        return this.nom;
    }

    public String getDescription(){
        return this.description;
    }

    public Stats geStats(){
        return this.stats;
    }
    
    public void addStats(int cnt, int ct,int cj, String cnp, float cta){
        stats.cartesNonTrouvees+= cnt;
        stats.cartesTrouvees+=ct;
        stats.cartesJouees+=cj;
        // stats.cartesParMinutes+=cpm;
        // stats.tempsPasse+=tp;
        stats.taux.nombrePartieJouer.add(cnp);
        stats.taux.tauxDeReussite.add(cta);
    }

}
