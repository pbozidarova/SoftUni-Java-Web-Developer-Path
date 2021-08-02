package OOP07_ReflectionAndAnnotations.barracksWars.core.commands;

import L7_Reflection.barracksWars.annotations.Inject;
import L7_Reflection.barracksWars.interfaces.Repository;

public class Retire extends Command {
    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        String result;
        try{
            this.repository.removeUnit(unitType);
            result = unitType + " retired!";
        }catch (IllegalArgumentException ex){
            result = ex.getMessage();
        }
        return result;
    }
}
