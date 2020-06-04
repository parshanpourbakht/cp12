package TicTacToe;
import static Dialogs.Dialogs.*;
import TicTacToe.TicTacToe.GameOutcome;
public class Tester {
    private static class Point {
        public int row, column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            showDialog("Welcome to TicTacToe!");

            TicTacToe ticTacToe = new TicTacToe();

            GameOutcome someoneWon = GameOutcome.none;
            while (someoneWon == GameOutcome.none) {
                Point currentPoint;
                showDialog(ticTacToe.printGrid());
                currentPoint = coordinateInput();

                someoneWon = ticTacToe.nextPlayerTurn(currentPoint.row, currentPoint.column);
            }

            if (someoneWon == TicTacToe.GameOutcome.X) showDialog("X won!");

            else if (someoneWon == TicTacToe.GameOutcome.O) showDialog("O won!");

            else showDialog("Tie!");

        }

        if(showInputDialog("Would you like to play again? Y/N").equalsIgnoreCase("n")){
            showDialog("Thank you for playing!");
        }
    }

    public static Point coordinateInput() {
        int row = Integer.parseInt(showInputDialog("Enter in your Row")) - 1;
        int column = Integer.parseInt(showInputDialog("Enter in your Column")) - 1;

        return new Point(row, column);
    }


}

