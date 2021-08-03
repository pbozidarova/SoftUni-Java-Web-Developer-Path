package OOP03_Encapsulation.l04team;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this.name = name;
        firstTeam = new ArrayList<>();
        reserveTeam = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Person> getFirstTeam() {
        return firstTeam;
    }

    public List<Person> getReserveTeam() {
        return reserveTeam;
    }
}
