import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;


public class GraphicsButton extends JPanel {

    private JButton button1;
    private Board2 board2;
    private List<JButton> buttons;
    private JTextArea textArea;

    public GraphicsButton(final Board2 board2, List<JButton> buttons, final JTextArea textArea) {


        this.board2 = board2;
        this.buttons = buttons;
        this.textArea = textArea;
        board2.enterPlayer();
        Dimension dimension = new Dimension();
        dimension.height = 100;
        dimension.width = 100;

        LayoutManager layoutManager = new GridBagLayout();
        setLayout(layoutManager);
        GridBagConstraints gc = new GridBagConstraints();

        for (int i = 0; i < 9; i++) {
            JButton button = new JButton("");
            button.setPreferredSize(dimension);
            int x = i / 3;
            int y = i % 3;
            gc.gridx = x;
            gc.gridy = y;
            button.setName(String.valueOf(x) + String.valueOf(y));
            add(button, gc);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton btn = (JButton) e.getSource();
                    String move = btn.getName();
                    char type = board2.getCurrentPlayer().getType();
                    //board2.printBoard();
                    if (board2.makeMove(move)) {
                        btn.setText(String.valueOf(type));
                    }

                    try {
                        if (board2.gameFinished()) {
                            if (board2.isDrow()) {
                                System.out.println("Drow");
                                textArea.setText("DROW");
                                board2.clear();
                            } else {
                                System.out.println("Winner" + board2.getWinner());
                                System.out.println("Winner" + board2.getLooser());
                                textArea.setText("Winner is: " + board2.getWinner().toString() + "\n Looser: " + board2.getLooser().toString());
                                textArea.append("------------------------");
                                board2.clear();
                                JOptionPane.showMessageDialog(null, "New Game");
                            }
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            buttons.add(button);
        }

    }

}
