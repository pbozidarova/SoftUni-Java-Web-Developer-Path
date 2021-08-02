package OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.helperClasses;


import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.helperClasses.interfaces.Repair;

public class RepairImpl implements Repair {
    private String name;
    private int hoursWorked;

    public RepairImpl(String name, int hoursWorked){
        this.name = name;
        this.hoursWorked = hoursWorked;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.getName(), this.hoursWorked );
    }
}
