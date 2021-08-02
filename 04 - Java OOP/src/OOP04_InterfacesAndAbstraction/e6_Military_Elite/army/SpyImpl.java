package OOP04_InterfacesAndAbstraction.e6_Military_Elite.army;

import L4_Interfaces_And_Abstractions.e6_Military_Elite.army.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }
    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\r\nCode Number: " + this.getCodeNumber();
    }

}
