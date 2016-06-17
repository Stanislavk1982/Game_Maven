public abstract class Player implements Comparable{
    private String name;
    private String lastName;
    private String middleName;
    private int age;
    private char type;

    public Player(String name, String lastName) {
        this(name, lastName, "Ivanovich");

    }

    public Player(String name, String lastName, String middleName) {
        this(name, lastName, middleName, 25);
    }

    Player(String name, String lastName, String middleName, int age) {
        this(name, lastName, middleName, age, 'X');

    }

    Player(String name, String lastName, String middleName, int age, char type) {
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setType(char type) {
        this.type = type;
    }

    public char getType() {
        return type;
    }

    public String toString() {
        return name + " " + lastName;
    }

    public abstract String makeMove();

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.name == null || this.lastName == null || this.middleName == null || this.age == 0) {
            return false;
        }
        Player player = (Player) obj;
        if (obj instanceof Player &&
                this.name.equals(player.name) &&
                this.lastName.equals(player.lastName) &&
                this.middleName.equals(player.middleName) &&
                this.age == player.age) {
            return true;
        }
        return false;
    }



}
