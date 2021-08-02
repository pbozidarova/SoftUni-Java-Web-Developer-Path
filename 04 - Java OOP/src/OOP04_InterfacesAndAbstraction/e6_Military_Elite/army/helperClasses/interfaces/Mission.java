package OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.helperClasses.interfaces;

import L4_Interfaces_And_Abstractions.e6_Military_Elite.army.enums.State;

public interface Mission {
    void completeMission();
    String getCodeName();
    State getState();
}
