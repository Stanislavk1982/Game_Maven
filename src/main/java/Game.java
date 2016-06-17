import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Statistic statistic = Statistic.newInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Start the Game?");
        String input = scanner.next();
        while (!input.equals("exit")) {
            System.out.println("Let's play game");

            //Player playerX = new Human("Ivanov", "Ivan", "Ivanovich", 25);
            //Player playerO = new AI("Petrov", "Petr", "Petrovich", 35);
            Board board = new Board();
            board.enterPlayer();
            board.printBoard();
            while (!board.gameFinished()) {
                board.currentPlayerMove();
                board.makeMove();
                board.printBoard();
            }
            board.winAndAddStatistic(statistic);
            System.out.println("Do you play again?");
            input = scanner.next();
        }

        //System.out.println(statistic);

    }
}
