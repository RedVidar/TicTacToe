public class Board {

    private final char[][] boardArray;

    public Board() {
        boardArray = new char[3][3];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                boardArray[row][col] = ' ';
            }
        }
    }

    public void displayBoard() {
        System.out.println("  1 2 3");
        for (int row = 0; row < 3; row++) {
            System.out.print(row + 1);
            for (int col = 0; col < 3; col++) {
                System.out.print(" " + boardArray[row][col]);
            }
            System.out.println();
        }
    }

    public void makeMove(int row, int col, char player) {
        boardArray[row][col] = player;
    }

    public boolean isCellEmpty(int row, int col) {
        // Sprawdzam czy jest pusto
        return boardArray[row][col] == ' ';
    }

    public boolean isDraw() {
        boolean draw = true;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (boardArray[row][col] == ' ') {
                    draw = false;
                    break;
                }
            }
        }
        return draw;
    }

    public boolean checkWin(char player) {
        //check row
        for (int row = 0; row < 3; row++) {
            if (boardArray[row][0] == player && boardArray[row][1] == player && boardArray[row][2] == player) {
                return true;
            }
        }
        // check column
        for (int col = 0; col < 3; col++) {
            if (boardArray[0][col] == player && boardArray[1][col] == player && boardArray[2][col] == player) {
                return true;
            }

            // check cross
            if (boardArray[0][0] == player && boardArray[1][1] == player && boardArray[2][2] == player) {
                return true;
            }
            // check opposite cross
            if (boardArray[0][2] == player && boardArray[1][1] == player && boardArray[2][0] == player) {
                return true;
            }


        }
        return false;
    }


}