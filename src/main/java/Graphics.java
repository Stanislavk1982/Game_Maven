import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Graphics extends JFrame {

    private JTextArea textArea;


    //private JButton button;


    public Graphics() {
        super("Sea battle");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        int x = screen.width;
        int y = screen.height;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((int) Math.round(x * 0.4), (int) Math.round(y * 0.4));
        setLocationRelativeTo(null);
        setVisible(true);

        LayoutManager layoutManager = new BorderLayout(5, 5);
        setLayout(layoutManager);

        textArea = new JTextArea();
        Dimension textAreaSize = textArea.getPreferredSize();

        textAreaSize.width = 400;
        textAreaSize.height = 100;
        textArea.setRows(10);
        textArea.setPreferredSize(textAreaSize);

        //board2.enterPlayer();
        List<JButton> list = new ArrayList<JButton>();
        Statistic statistic = Statistic.newInstance();
        Board2 board2 = new Board2(statistic, list);
        GraphicsButton gb = new GraphicsButton(board2, list, textArea);
        GraphicButtonStatistic gbStatistics = new GraphicButtonStatistic(list, textArea, board2, statistic);
        add(gb, BorderLayout.WEST);
        add(textArea, BorderLayout.EAST);
        add(gbStatistics, BorderLayout.SOUTH);

    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

}
