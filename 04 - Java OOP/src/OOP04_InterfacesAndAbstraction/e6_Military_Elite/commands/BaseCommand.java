package OOP04_InterfacesAndAbstraction.e6_Military_Elite.commands;

import L4_Interfaces_And_Abstractions.e6_Military_Elite.army.interfaces.Soldier;
import L4_Interfaces_And_Abstractions.e6_Military_Elite.commands.interfaces.Command;

import java.util.List;

public abstract class BaseCommand implements Command {
    private List<Soldier> soldiers;

    protected BaseCommand(List<Soldier> soldiers){
        this.soldiers = soldiers;
    }

    protected List<Soldier> getSoldier(){
        return this.soldiers;
    }

    public void add(Soldier soldier){
        this.soldiers.add(soldier);
    }

 }
