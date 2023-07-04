import java.util.Scanner;

public class Engine {

    private final Board board;
    private char currentPlayer;

    public Engine() {
        board = new Board();
        currentPlayer = 'X';
    }
/*
    public void startGame() {
        System.out.println("Game started: ");
       board.displayBoard();

        while (!gameFinished) {
            makeMove();
            board.displayBoard();
            checkGameStatus(currentPlayer);
            switchPlayer();
        }
    }



    public void makeMove() {
        System.out.println("Player " + currentPlayer + "'s turn.");
        int row = getPlayerInput("Enter row (1-3): ") - 1;
        int col = getPlayerInput("Enter column (1-3): ") - 1;

        if (board.isCellEmpty(row, col)) {
            board.makeMove(row, col, currentPlayer);
        } else {
            System.out.println("Invalid move rethink your life");
            makeMove();
        }
    }
    */

    public void makeMove(int row, int col) {

        if (board.isCellEmpty(row, col)) {
            board.makeMove(row, col, currentPlayer);
        } else {
            System.out.println("Invalid move rethink your life");

        }
    }
    private int getPlayerInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }

    public boolean checkGameStatus(char player) {
        boolean gameFinished = false;
        if (board.isDraw()) {
            System.out.println("Draw ");
            gameFinished = true;
        }

        if (board.checkWin(player)) {
            System.out.println("The winner is " + player);
            gameFinished = true;
        }
        return gameFinished;
    }


    void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }

    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isDraw() {
        return board.isDraw();
    }


    public void resetGame() {
        board.initializeBoard();
    }

    public char getWinner() {
        return  currentPlayer;
    }

    public boolean isCellEmpty(int finalRow, int finalCol) {
        return board.isCellEmpty(finalRow,finalCol);
    }
}