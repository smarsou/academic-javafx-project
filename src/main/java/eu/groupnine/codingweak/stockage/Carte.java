package eu.groupnine.codingweak.stockage;

public class Carte {
    private int id;
    private String question;
    private String reponse;  

    public Carte(int id,String question,String rep) {
        this.id = id;
        this.question = question;
        this.reponse = rep;
    }

    public int getId() {
        return this.id;

    }

    public String getQuestion() {
        return this.question;

    }

    public String getReponse() {
        return this.reponse;

    }

}
