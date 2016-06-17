import java.util.Random;

public class AI extends Player {
    AI(String name, String lastName) {
        super(name, lastName, "Petrovich");
    }

    AI(String name, String lastName, String middleName) {
        super(name, lastName, middleName, 25);
    }

    AI(String name, String lastName, String middleName, int age, char type) {
        super(name, lastName, middleName, age, type);
    }

    @Override
    public String makeMove() {
        Random rnd = new Random();
        int x = rnd.nextInt(3);
        int y = rnd.nextInt(3);
        System.out.println(" X:" + x + " y:" + y);
        return String.valueOf(x) + String.valueOf(y);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
