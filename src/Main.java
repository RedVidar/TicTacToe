import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Engine gameEngine = new Engine();
        //  gameEngine.startGame();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TicTacToeGUI game = new TicTacToeGUI();
            }
        });
    }
}
