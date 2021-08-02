package OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.interfaces;

import L4_Interfaces_And_Abstractions.e6_Military_Elite.army.helperClasses.interfaces.Repair;

import java.util.Collection;

public interface Engineer {
    public void addRepair(Repair repair);
    public Collection<Repair> getRepairs();

}
