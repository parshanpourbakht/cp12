package TicTacToe;

import java.util.Random;

public class TicTacToe {

    private static final int PLAYER1_TURN = 0, PLAYER2_TURN = 1;
    GameOutcome[][] TTGrid = new GameOutcome[3][3];
    private int playerTurn, moveCounter = 0;
    GameOutcome shape;

    enum GameOutcome {
        none, X, O, draw;
    }

    public TicTacToe() {
        Random r = new Random();

        playerTurn = r.nextInt(2);
        setShape();

        for (int row = 0; row < TTGrid.length; row++) {
            for (int col = 0; col < TTGrid[0].length; col++) {
                TTGrid[row][col] = GameOutcome.none;
            }
        }
    }

    private void setShape() {
        if (playerTurn == PLAYER1_TURN) {
            shape = GameOutcome.X;
        } else {
            shape = GameOutcome.O;
        }
    }

    public GameOutcome nextPlayerTurn(int row, int column) {
        moveCounter++;
        setShape();

        if (TTGrid[row][column] == GameOutcome.none) {
            TTGrid[row][column] = shape;
        } else {
            return GameOutcome.none;
        }

        if (moveCounter == (Math.pow(TTGrid.length, 2) - 1)) {
            return GameOutcome.draw;
        }

        if (checkGrid(row, column)) {
            return shape;
        } else {
            setPlayerTurns();
            return GameOutcome.none;
        }
    }

    private void setPlayerTurns() {
        if (playerTurn == PLAYER1_TURN) {
            playerTurn++;
        } else {
            playerTurn--;
        }
    }

    private boolean checkGrid(int row, int column) {
        boolean check1 = checkRow(row);
        boolean check2 = checkColumn(column);
        boolean check3 = checkDiagonal(row, column);

        return check1 || check2 || check3;
    }

    private boolean checkRow(int row) {
        for (int colCounter = 0; colCounter < TTGrid.length; colCounter++) {
            if (TTGrid[row][colCounter] != shape) {
                break;
            }
            if (colCounter == TTGrid.length - 1) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn(int column) {
        for (int rowCounter = 0; rowCounter < TTGrid.length; rowCounter++) {
            if (TTGrid[rowCounter][column] != shape) {
                break;
            }
            if (rowCounter == TTGrid.length - 1) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal(int row, int column) {
        if (row == column) {

            for (int i = 0; i < TTGrid.length; i++) {
                if (TTGrid[i][i] != shape)
                    break;
                if (i == TTGrid.length - 1) {
                    return true;
                }
            }
        }

        if (row + column == TTGrid.length - 1) {
            for (int i = 0; i < TTGrid.length; i++) {
                if (TTGrid[i][(TTGrid.length - 1) - i] != shape)
                    break;
                if (i == TTGrid.length - 1) {
                    return true;
                }
            }
        }

        return false;


    }

    public String printGrid() {

        String result = "";
        for (int row = 0; row < TTGrid.length; row++) {
            for (int column = 0; column < TTGrid[0].length; column++) {
                if (TTGrid[row][column] == GameOutcome.none) {
                    result += " ";
                } else {
                    result += TTGrid[row][column];
                }
                if (column != TTGrid[0].length - 1)
                    result += "|";
            }
            if (row != TTGrid.length - 1)
                result += "\n-------\n";

        }
        return result;
    }
}