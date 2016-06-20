import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Statistic {

    private static Statistic statistic = null;
    private List<GameResult> results = new ArrayList<GameResult>();
    Scanner scanner = new Scanner(System.in);
    //JDBC jdbc = new JDBC();
    Connection connection;

    private Statistic() throws IOException, SQLException {
        Properties properties = loadProperties();

        connection = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));
        System.out.println("connection esteblished");
    }


    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        InputStream stream = getClass().getResourceAsStream("db.properties");
        properties.load(stream);
        return properties;
    }

    public String getStatisticFromJDBC() throws SQLException {
        String sql = "select * from players";
        String str = "";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            //str = "";
            str += resultSet.getString("id") + ", ";
            str += resultSet.getString("lastname") + ", ";
            str += resultSet.getString("firstname") + ", ";
            str += resultSet.getString("middlename") + ", ";
            System.out.println(str);
        }
        return str;
    }

    public void addResult(GameResult result) throws SQLException {
        int player;
        if (result.getPlayer().getName().equals("Ivanov")) {
            player = 1;
        } else player = 2;
        String resultGame = result.getResult();
        Date date = result.getDate();
        String sql = "insert into gameresult (playerId, result) value (? , ?)";
        //String sql = "insert into gameresult (playerId, result) value (player , resultGame)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, player);
        preparedStatement.setString(2, resultGame);
        // preparedStatement.setDate(3, (java.sql.Date) date);
        preparedStatement.execute();
        //results.add(result);
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

    public static Statistic newInstance() throws IOException, SQLException {
        if (statistic == null) {
            statistic = new Statistic();
        }
        return statistic;
    }
}
