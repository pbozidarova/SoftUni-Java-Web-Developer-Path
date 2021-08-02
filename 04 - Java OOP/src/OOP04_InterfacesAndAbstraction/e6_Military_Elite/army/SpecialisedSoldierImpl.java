package OOP04_InterfacesAndAbstraction.e6_Military_Elite.army;

import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.enums.Corps;
import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    public Corps getCorps(){
        return  this.corps;
    }

    @Override
    public String toString() {
        return super.toString() + "\r\nCorps: " + this.getCorps().toString();
    }
}
