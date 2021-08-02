package OOP07_ReflectionAndAnnotations.barracksWars.core.commands;


import OOP07_ReflectionAndAnnotations.barracksWars.annotations.Inject;
import OOP07_ReflectionAndAnnotations.barracksWars.interfaces.Repository;
import OOP07_ReflectionAndAnnotations.barracksWars.interfaces.Unit;
import OOP07_ReflectionAndAnnotations.barracksWars.interfaces.UnitFactory;

public class Add extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";    }
}
