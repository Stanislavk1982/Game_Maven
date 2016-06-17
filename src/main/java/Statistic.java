import java.util.*;

public class Statistic {

    private static Statistic statistic = null;
    private List<GameResult> results = new ArrayList<GameResult>();
    Scanner scanner = new Scanner(System.in);

    private Statistic() {

    }

    public void addResult(GameResult result) {
        results.add(result);
    }

    //public void viewStatistics() {
    public String getWinner() {

        String statisticOut = "";
        Collections.sort(results);
        for (GameResult tempresult : results) {
            if (tempresult.returnResult().equals("winner")) {
                statisticOut = statisticOut + "\n" + tempresult;
            }
        }
        return statisticOut;
    }

    public String getLooser() {

        String statisticOut = "";
        Collections.sort(results);
        System.out.println(results);
        for (GameResult tempresult : results) {
            if (tempresult.returnResult().equals("looser")) {
                statisticOut = statisticOut + "\n" + tempresult;
            }
        }
        return statisticOut;
    }

    public String getAllGamers() {
        Collections.sort(results, new Comparator<GameResult>() {
            @Override
            public int compare(GameResult o1, GameResult o2) {
                return o1.returnPlayer().getName().compareTo(o2.returnPlayer().getName());
            }
        });
        return results.toString();
    }

    public static Statistic newInstance() {
        if (statistic == null) {
            statistic = new Statistic();
        }
        return statistic;
    }
}
