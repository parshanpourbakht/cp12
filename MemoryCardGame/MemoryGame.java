package MemoryCardGame;


import java.util.Arrays;
import java.util.SplittableRandom;

public class MemoryGame {
    static final int GAME_GRID_LENGTH = 4;

    private static final Card[] rowTemplate = new Card[GAME_GRID_LENGTH];
    private Card[][] GameGrid = new Card[GAME_GRID_LENGTH][GAME_GRID_LENGTH];
    private int moveCounter = 0;

    private Card[] cloneCardArr(Card[] arr) {
        Card[] cards = new Card[GAME_GRID_LENGTH];

        for (int i = 0; i < cards.length; i++) cards[i] = arr[i].clone();
        return cards;
    }

    private void generateGrid() {
        int increment = 4;
        Card[] row = rowTemplate.clone();
        for (int i = 0; i < GameGrid.length; i++) {
            GameGrid[i] = cloneCardArr(row);
            if ((i + 1) % 2 == 0)
                for (int j = 0; j < GameGrid[i].length; j++) row[j].addValue(increment);

        }

    }

    public boolean isGameOver() {
        return (GAME_GRID_LENGTH * 2) == moveCounter;
    }

    public String getDisplay() {
        StringBuilder displayStrBuilder = new StringBuilder();
        int colLen = GameGrid[0].length;
        for (Card[] cards : GameGrid) {
            for (int j = 0; j < colLen; j++) {
                displayStrBuilder.append(cards[j]);
                if (j != colLen - 1)
                    displayStrBuilder.append("|");
            }
            displayStrBuilder.append("\n");
        }


        return displayStrBuilder.toString();
    }

    public String getDebugDisplay() {
        StringBuilder displayStrBuilder = new StringBuilder();
        int colLen = GameGrid[0].length;
        for (Card[] cards : GameGrid) {
            for (int j = 0; j < colLen; j++) {
                displayStrBuilder.append(cards[j].getValue());
                if (j != colLen - 1)
                    displayStrBuilder.append("|");
            }
            displayStrBuilder.append("\n");
        }


        return displayStrBuilder.toString();
    }

    public void reset() {
        moveCounter = 0;

    }

    public String revealDisplay(Point first) {
        StringBuilder displayStrBuilder = new StringBuilder();
        int colLen = GameGrid[0].length;
        Card cardToFind = GameGrid[first.x][first.y];

        for (int i = 0; i < GameGrid.length; i++) {
            Card[] cards = GameGrid[i];
            for (int j = 0; j < colLen; j++) {
                boolean isCurrentCard = cardToFind.getValue() == cards[j].getValue();
                String cardDisplay = isCurrentCard ? Integer.toString(cards[j].getValue()) : cards[i].getDisplay();

                displayStrBuilder.append(cardDisplay);
                if (j != colLen - 1)
                    displayStrBuilder.append("|");
            }
            displayStrBuilder.append("\n");
        }


        return displayStrBuilder.toString();
    }

    public boolean nextSelection(Point first, Point second) {
        Card one = GameGrid[first.x][first.y];
        Card two = GameGrid[second.x][second.y];
        if (one.getValue() == two.getValue()) {
            one.setFound(true);
            two.setFound(true);
            moveCounter++;
            return true;
        }

        return false;
    }

    public void build() {
        generateGrid();
        ArrayUtils.shuffle(GameGrid);
    }

    public MemoryGame() {
        for (int i = 0; i < GameGrid[0].length; i++) rowTemplate[i] = new Card(i + 1);

    }


}
