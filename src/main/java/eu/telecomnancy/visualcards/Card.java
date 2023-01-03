package eu.telecomnancy.visualcards;

import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

// représente une carte à jouer. Elle a une couleur, une valeur. ELle a aussi une référence vers une représentation visuelle
public class Card implements Comparable<Card> {
    private String suit;
    private CardColor color;
    private CardValue value;
    private Image image;

    public Card(CardValue value, CardColor color) {
        setValue(value);
        setColor(color);
        String fileName = getValidFaceNames().get(value.ordinal()) + "_of_"+getValidSuits().get(color.ordinal())+".png";
        image = new Image(getClass().getResource("images/"+fileName).toString());
    }

    public String getFaceName() {
        return getValidFaceNames().get(getValue().ordinal());
    }

    /**
     * This method returns a list of face names that are valid for
     * Card objects
     */
    public static List<String> getValidFaceNames()
    {
        return Arrays.asList("2","3","4","5","6","7","8","9","10","jack",
                            "queen","king","ace");
    }

    /**
     * This method will return a list of valid suits
     * @return spades, hearts, clubs, diamonds
     */
    public static List<String> getValidSuits()
    {
        return Arrays.asList("hearts","diamonds","spades","clubs");
    }


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card c) {
        if (this.getValue().ordinal() < c.getValue().ordinal()) return -1;
        if (this.getValue().ordinal() > c.getValue().ordinal()) return 1;
        return this.getColor().compareTo(c.getColor());
    }

    @Override
    public String toString() {
        return "Card{" +
                "color=" + getColor() +
                ", value=" + getValue() +
                '}';
    }


    public CardColor getColor() {
        return color;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }

    public CardValue getValue() {
        return value;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }
}
