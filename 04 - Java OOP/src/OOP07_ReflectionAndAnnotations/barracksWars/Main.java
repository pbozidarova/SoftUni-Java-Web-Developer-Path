package OOP07_ReflectionAndAnnotations.barracksWars;

import OOP07_ReflectionAndAnnotations.barracksWars.core.Engine;
import OOP07_ReflectionAndAnnotations.barracksWars.core.commands.CommandInterpreterImpl;
import OOP07_ReflectionAndAnnotations.barracksWars.core.factories.UnitFactoryImpl;
import OOP07_ReflectionAndAnnotations.barracksWars.data.UnitRepository;
import OOP07_ReflectionAndAnnotations.barracksWars.interfaces.CommandInterpreter;
import OOP07_ReflectionAndAnnotations.barracksWars.interfaces.Repository;
import OOP07_ReflectionAndAnnotations.barracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
