import java.util.Date;

public class GameResult implements Comparable{
    private Player player;
    private String result;
    private Date date;

    public GameResult(Player player, String result) {
        this.result = result;
        this.player = player;
        this.date = new Date();

    }

    public String returnResult() {
        return result;
    }

    public Player returnPlayer() {
        return player;
    }

    public String toString() {
        return player.toString() + " -  " + result + " - " + date.toString() ;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != GameResult.class) {
            return false;
        }

        GameResult gameResult = (GameResult) obj;

        if (this.player.equals(gameResult.player) && this.result.equals(gameResult.result)) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        GameResult gameResult = (GameResult)o;
        return this.result.compareTo(gameResult.result);
    }
}
