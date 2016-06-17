import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Board2 {
    private char[][] board = new char[3][3];
    private Player playerX;
    private Player player0;
    private Player currentPlayer;
    private Player winner, looser;
    private boolean drow=false;
    private Statistic statistic;
    private List<JButton> buttons;

    public Board2(Statistic statistic, List<JButton> buttons) {
        this.buttons=buttons;
        this.statistic = statistic;
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], ' ');
        }

    }

    public void enterPlayer() {
        Player playerX = new Human("Ivanov", "Ivan", "Ivanovich", 25, 'X');
        Player playerO = new AI("Petrov", "Petr", "Petrovich", 35, 'O');

        this.player0 = playerO;
        this.playerX = playerX;
        currentPlayer = playerX;

    }

    public Boolean makeMove(String move) {


        int y = Character.getNumericValue(move.charAt(0));
        int x = Character.getNumericValue(move.charAt(1));
        while (isMoveValid(x, y)) {
            board[x][y] = currentPlayer.getType();
            System.out.println("TestBoard" + board[x][y]);
            changeCurrentPlayer();
            return true;
        }
        return false;

    }

    private void changeCurrentPlayer() {
        if (currentPlayer.getType() == 'X') {
            currentPlayer = player0;
            //System.out.println("TestChange1");
        } else {
            currentPlayer = playerX;
            //System.out.println("TestChange2");
        }
    }

    private boolean isMoveValid(int x, int y) {
        if (board[x][y] == 'X' || board[x][y] == 'O') {
            System.out.println("TestMoveValid");
            return false;
        }
        return true;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isDrow() {
        return drow;
    }

    public boolean gameFinished() {
        int counter = 0;
        drow=false;
        for (int i = 0; i < 9; i++) {
            int x = i / 3;
            int y = i % 3;
            if (board[x][y] == 'X' || board[x][y] == 'O') {
                counter++;
            }

        }
        //System.out.println("TestCounter:"+counter);
        if (counter == 9) {
            drow = true;
            deowAddStatistic(statistic);
            return true;

        }
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                calaculateWin(board[i][0]);
                return true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                calaculateWin(board[0][i]);
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            calaculateWin(board[0][0]);
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            calaculateWin(board[0][2]);
            return true;
        }
        return false;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getLooser() {
        return looser;
    }

    public void calaculateWin(char type) {
        if (type == 'X') {
            winner = playerX;
            looser = player0;
            winAndAddStatistic(statistic);
        } else {
            winner = player0;
            looser = playerX;
            winAndAddStatistic(statistic);
        }

    }

    public void winAndAddStatistic(Statistic statistic) {
        GameResult resultWinner = new GameResult(winner, "winner");
        GameResult resultLooser = new GameResult(looser, "looser");
        statistic.addResult(resultWinner);
        statistic.addResult(resultLooser);
    }

    public void deowAddStatistic(Statistic statistic) {
        GameResult resultWinner = new GameResult(playerX, "Drow");
        GameResult resultLooser = new GameResult(player0, "Drow");
        statistic.addResult(resultWinner);
        statistic.addResult(resultLooser);
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], ' ');
        }
        for (JButton btn1 : buttons) {
            btn1.setText("");
        }
        currentPlayer=playerX;
    }

    public void printBoard() {
        System.out.println("    0    1    2");
        System.out.println(" ┌──┬──┬──┐");
        for (int i = 0; i < 3; i++) {
            System.out.println(i + "│ " + board[i][0] + " │  " + board[i][1] + " │ " + board[i][2] + " │");
            if (i < 2) {
                System.out.println(" ├──┼──┼──┤");
            }
        }
        System.out.println(" └──┴──┴──┘");
    }
}
