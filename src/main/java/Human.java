import java.util.Scanner;

public class Human extends Player {

    public Human(String name, String lastName) {
        super(name, lastName, "Ivanov");
    }
    public Human(String name, String lastName, String middleName) {
        super(name, lastName, middleName, 25);
    }
    public Human(String name, String lastName, String middleName, int age, char type) {
        super(name, lastName, middleName, age, type);
    }


    @Override
    public String makeMove() {
        Scanner scanner=new Scanner(System.in);
        String move = scanner.next();
        return move;
    }

    @Override
    public int compareTo(Object o) {
        Player player = (Player)o;
        return this.getName().compareTo(player.getName());
    }
}
