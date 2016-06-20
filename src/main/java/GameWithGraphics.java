import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class GameWithGraphics {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Graphics();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}
