package OOP07_ReflectionAndAnnotations.barracksWars;

import L7_Reflection.barracksWars.core.commands.CommandInterpreterImpl;
import L7_Reflection.barracksWars.interfaces.CommandInterpreter;
import L7_Reflection.barracksWars.interfaces.Repository;
import L7_Reflection.barracksWars.interfaces.Runnable;
import L7_Reflection.barracksWars.interfaces.UnitFactory;
import L7_Reflection.barracksWars.core.Engine;
import L7_Reflection.barracksWars.core.factories.UnitFactoryImpl;
import L7_Reflection.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
