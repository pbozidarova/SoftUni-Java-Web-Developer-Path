package OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.interfaces;

import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.helperClasses.interfaces.Mission;

import java.util.Collection;

public interface Commando {
    void addMission(Mission mission);
    Collection<Mission> getMissions();


}
