package eu.telecomnancy.visualcards;

import javafx.scene.image.Image;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// Représente une jeu de cartes. Une variable référence l'image représentant le dos d'une carte.
public class DeckOfCards {
    private ArrayList<Card> deck;
    private Image backOfCardImage;

    int topCard=0;

    /**
     * This is a 1 argument constructor that passes in a collection
     * of Card objects
     * @param deck le jeu de carte pour initialiser le jeu
     */
    public DeckOfCards(ArrayList<Card> deck) {
        this.deck = deck;
        URL imageFile=getClass().getResource("images/black_joker.png");
        if (imageFile!=null) {
            backOfCardImage = new Image(imageFile.toString());
        }

    }

    /**
     * This is a zero argument constructor that will build a full Deck of Cards
     */
    public DeckOfCards()
    {

        deck = new ArrayList<>();

        for(CardColor color : CardColor.values()) {
            for (CardValue value : CardValue.values()) {
                deck.add(new Card(value,color));
            }
        }
        URL imageFile=getClass().getResource("images/black_joker.png");
        if (imageFile!=null) {
            backOfCardImage = new Image(imageFile.toString());
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public Image getBackOfCardImage() {
        return backOfCardImage;
    }

    public void setBackOfCardImage(Image backOfCardImage) {
        this.backOfCardImage = backOfCardImage;
    }

    /**
     * This method will "deal" the top card off the deck. At the end of the deck we start over at the beginning
     */
    public Card dealTopCard()
    {
        Card result=deck.get(topCard);
        topCard=topCard+1;
        if (topCard>51) {
            topCard=0;
        }
        return result;
    }

    /**
     * This method will shuffle the deck of cards
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    /**
     * This method will "sort" the deck
     */
    public void sort() {
        Collections.sort(deck);
    }

    /**
     * This method will draw a card from the deck at a defined place (i)
     */
    public Card drawACard(int i) {
        return deck.get(i);
    }

    /**
     * This method will draw a card from the deck at a random place
     */
    public Card drawARandomCard() {
        var index=new Random().nextInt(52);
        return deck.get(index);

    }


}
