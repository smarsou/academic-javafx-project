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

    public void setQuestion(String q) {
        this.question = q;


    }

    public void setReponse(String rep) {
        this.reponse = rep;

    }

}
