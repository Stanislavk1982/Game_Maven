import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class GraphicButtonStatistic extends JPanel {
    private JButton buttonWinner = new JButton("Winner");
    private JButton buttonLoser = new JButton("Loser");
    private JButton buttonNewGame = new JButton("NewGame");
    private JButton buttonAllGamers = new JButton("All Gamers");

    private List<JButton> buttons;
    private JTextArea textArea;
    private Board2 board2;
    private Statistic statistic;

    public JButton getButtonWinner() {
        return buttonWinner;
    }

    public void setButtonWinner(JButton buttonWinner) {
        this.buttonWinner = buttonWinner;
    }

    public GraphicButtonStatistic(final List<JButton> buttons, final JTextArea textArea, final Board2 board2, final Statistic statistic) {
        this.statistic = statistic;
        this.board2 = board2;
        this.textArea = textArea;
        this.buttons = buttons;
        LayoutManager layoutManager = new FlowLayout((FlowLayout.CENTER));
        setLayout(layoutManager);

        add(buttonNewGame, layoutManager);
        add(buttonWinner, layoutManager);
        add(buttonLoser, layoutManager);
        add(buttonAllGamers,layoutManager);

        buttonWinner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(statistic.getWinner());
            }
        });

        buttonLoser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(statistic.getLooser());
            }
        });
        buttonNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board2.clear();
                for (JButton btn : buttons) {
                    btn.setText("");
                }
            }
        });

        buttonAllGamers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea.setText(statistic.getStatisticFromJDBC());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                ;
            }
        });
    }
}
