package MemoryCardGame;

public class Card {
    private int value;
    private boolean isFound = false;

    public Card clone() {

        return new Card(value, isFound);
    }

    public void addValue(int val) {
        value += val;
    }

    public void setFound(boolean found) {
        isFound = found;
    }

    public boolean isFound() {
        return isFound;
    }

    public String getDisplay() {
        if (isFound)
            return Integer.toString(getValue());
        else return "0";

    }

    public int getValue() {

        return value;
    }

    public Card(int value) {
        this.value = value;

    }

    public Card(int value, boolean found) {
        this.value = value;
        this.isFound = found;
    }

    public String toString() {
        return getDisplay();
    }


}
