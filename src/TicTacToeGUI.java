import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame {

    private Engine engine;
    private JButton[][] buttons;
    private JButton resetButton;

    public TicTacToeGUI() {
        engine = new Engine();
        buttons = new JButton[3][3];

        setTitle("Kółko i krzyżyk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 350);
        setLayout(new BorderLayout());

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 3));
        initializeButtons(gamePanel);
        add(gamePanel, BorderLayout.CENTER);

        resetButton = new JButton("Resetuj grę");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        add(resetButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void initializeButtons(JPanel panel) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));

                int finalRow = row;
                int finalCol = col;
                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (engine.isCellEmpty(finalRow, finalCol)) {
                            char currentPlayer = engine.getCurrentPlayer();
                            buttons[finalRow][finalCol].setText(String.valueOf(currentPlayer));
                            engine.makeMove(finalRow, finalCol);

                            if (engine.checkGameStatus(currentPlayer)) {
                                if (engine.isDraw()) {
                                    JOptionPane.showMessageDialog(null, "Remis!");
                                } else {
                                    char winner = engine.getWinner();
                                    JOptionPane.showMessageDialog(null, "Wygrał gracz " + winner + "!");
                                }
                                resetGame();
                            } else {
                                engine.switchPlayer();
                            }
                        }
                    }
                });
                panel.add(buttons[row][col]);
            }
        }
    }

    private void resetGame() {
        engine.resetGame();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToeGUI();
            }
        });
    }
}