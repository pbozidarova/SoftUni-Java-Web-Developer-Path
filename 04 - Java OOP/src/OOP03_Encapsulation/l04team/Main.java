package OOP03_Encapsulation.l04team;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> players = new ArrayList<>();

        Team team = new Team("Back Eagles");
        for (Person player : players) {
            team.addPlayer(player);
        }

        System.out.println( "First team have " + team.getFirstTeam().size() + " players");
        System.out.println( "Reserve team have " + team.getFirstTeam().size() + " players");


    }
}
