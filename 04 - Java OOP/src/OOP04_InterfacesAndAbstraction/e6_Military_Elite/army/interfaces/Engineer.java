package OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.interfaces;


import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.helperClasses.interfaces.Repair;

import java.util.Collection;

public interface Engineer {
    public void addRepair(Repair repair);
    public Collection<Repair> getRepairs();

}
