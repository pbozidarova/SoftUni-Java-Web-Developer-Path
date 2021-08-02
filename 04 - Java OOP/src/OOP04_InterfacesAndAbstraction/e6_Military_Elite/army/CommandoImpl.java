package OOP04_InterfacesAndAbstraction.e6_Military_Elite.army;

import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.enums.Corps;
import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.helperClasses.interfaces.Mission;
import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.interfaces.Commando;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl  implements Commando {
    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {

        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {

        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator())
                .append("Missions:")
                .append(System.lineSeparator());

        for (Mission mission : this.missions) {
            sb.append("  ")
                    .append(mission.toString())
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
