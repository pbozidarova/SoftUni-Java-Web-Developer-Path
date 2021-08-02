package OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.helperClasses;


import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.enums.State;
import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.helperClasses.interfaces.Mission;

public class MissionImpl implements Mission {
    private String codeName;
    private State state;

    public MissionImpl(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public void completeMission() {
        this.state = State.Finished;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                this.getCodeName(),
                this.getState().toString()
        );
    }
}
