import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class MemoryTrainingFrame extends JFrame implements ActionListener, Runnable {
    private final JButton[] buttons = new JButton[9];
    private final JButton startButton;
    private final JButton exitButton;
    private final JTextField scoreText;

    private final ArrayList<Integer> solution = new ArrayList<>();
    private final ArrayList<Integer> input = new ArrayList<>();
    private int currentScore = 0;
    private Thread thread;

    public MemoryTrainingFrame() {
        super("Memory Training");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        JPanel north = new JPanel();
        JLabel scoreLabel = new JLabel("Current score");
        scoreText = new JTextField(20);
        scoreText.setEditable(false);
        updateScore();
        north.add(scoreLabel);
        north.add(scoreText);
        add(north, BorderLayout.NORTH);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 5, 5));
        for (int i = 0; i < 9; i++) {
            JButton temp = new JButton("" + (i + 1));
            temp.addActionListener(this);
            temp.setEnabled(false);
            buttons[i] = temp;
            center.add(temp);
        }
        add(center, BorderLayout.CENTER);

        JPanel south = new JPanel();
        startButton = new JButton("Start next round");
        startButton.addActionListener(this);
        south.add(startButton);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        south.add(exitButton);
        add(south, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(startButton)) {
            startRound();
        } else if (e.getSource().equals(exitButton)) {
            onExit();
        } else {
            onUsersTurn(Integer.parseInt(e.getActionCommand()) - 1);
        }
    }

    @Override
    public void run() {
        // TODO Teilaufgabe a)
    }

    private void startRound() {
        // TODO Teilaufgabe b)
    }

    private void onExit() {
        // TODO Teilaufgabe c)
    }

    private void onUsersTurn(int n) {
        input.add(n);
        if (input.size() == solution.size()) {
            if (checkSolution()) {
                currentScore++;
            } else {
                solution.clear();
                currentScore = 0;
            }
            updateScore();
            setButtonsEnabled(false);
            startButton.setEnabled(true);
            input.clear();
        }
    }

    private void updateScore() {
        scoreText.setText("" + currentScore);
    }

    private void setButtonsEnabled(boolean enabled) {
        for (JButton btn : buttons) {
            btn.setEnabled(enabled);
        }
    }

    private boolean checkSolution() {
        for (int i = 0; i < solution.size(); i++) {
            if (!solution.get(i).equals(input.get(i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new MemoryTrainingFrame();
    }
}
