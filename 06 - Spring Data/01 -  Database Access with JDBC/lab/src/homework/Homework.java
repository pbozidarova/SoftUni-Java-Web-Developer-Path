package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;


public class Homework {

    private static final String CONNECTION_STRING =
            "jdbc:mysql://localhost:3306/";

    private static final String MINIONS_TABLE_NAME = "minions_db";

    private Connection connection;

    private BufferedReader reader;

    public Homework() {
        this.reader = new BufferedReader( new InputStreamReader( System.in ));
    }

    public void setConnection(String user, String password) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);


        connection = DriverManager
                .getConnection(CONNECTION_STRING + MINIONS_TABLE_NAME, properties);

    }

    public void getVillainsNamesEx2() throws SQLException {
        String query = "SELECT v.name, COUNT(mv.minion_id) AS 'count' FROM villains as v " +
                "JOIN minions_villains mv on v.id = mv.villain_id " +
                "GROUP BY v.id " +
                "HAVING `count` > 15 " +
                "ORDER BY `count` DESC;";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            System.out.printf("%s %d%n", resultSet.getString("name"),
                                         resultSet.getInt(2));
        }
    }

    public void getMinionNamesEx3() throws IOException, SQLException {

        System.out.println("Enter Villain ID: ");
        int villainId = Integer.parseInt(reader.readLine());

        String villainName = getEntityNameById(villainId, "villains");

        if(villainName == null){
            System.out.printf("No villain with %d exists in the database.", villainId);
            return;
        }

        System.out.printf("Villain: %s%n", villainName);

        String query = "SELECT m.name, m.age FROM minions as m " +
                "JOIN minions_villains mv on m.id = mv.minion_id " +
                "WHERE mv.villain_id = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, villainId);

        ResultSet resultSet = statement.executeQuery();

        int counter = 0;
        while (resultSet.next()) {
            System.out.printf("%d. %s %d%n",
                    ++counter, resultSet.getString("name"), resultSet.getInt("age"));
        }
    }

    private String getEntityNameById(int entityId, String tableName) throws SQLException {
        String query = String.format("SELECT name FROM %s WHERE id = ?", tableName);

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, entityId);

        ResultSet resultSet = statement.executeQuery();

        return resultSet.next() ? resultSet.getString("name") : null;
    }

    public void addMinionEx4() throws IOException, SQLException {
        System.out.printf("Enter minions info: name, age, town name: ");
        String[] minionInfo = reader.readLine().split("\\s+");
        String minionName = minionInfo[0];
        Integer age = Integer.parseInt(minionInfo[1]);
        String townName = minionInfo[2];

        int townId = getEntityIdByName(townName, "towns" );

        if(townId < 0){
            insertEntityInTowns(townName);

            //TODO insert into towns
        }

        System.out.println(townId);
        
    }

    private void insertEntityInTowns(String townName) throws SQLException {
        String query = "INSERT INTO towns(name) value(?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, townName);
        statement.execute();
    }

    private int getEntityIdByName(String entityName, String tableName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = ?", tableName);

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, entityName);
        ResultSet resultSet = statement.executeQuery();

        return resultSet.next() ? resultSet.getInt(1) : -1;


    }

    public void changeTownNameCasingEx5() throws IOException, SQLException {
        System.out.println("Enter country name: ");
        String countryName = reader.readLine();

        String query = "UPDATE towns SET name = UPPER(name) WHERE country = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, countryName);

        int townsAffected = statement.executeUpdate();

        System.out.printf("%d town names were affected.",  townsAffected);
//                "[SOFIA, PLOVDIV, BURGAS]\n");
    }

    public void increaseAgeWithStoredProcedure() throws IOException, SQLException {
        System.out.println("Enter minion id: ");
        int minionId = Integer.parseInt(reader.readLine());

        String query = "CALL usp_get_older(?)";

        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setInt(1, minionId);
        callableStatement.execute();
    }
}
