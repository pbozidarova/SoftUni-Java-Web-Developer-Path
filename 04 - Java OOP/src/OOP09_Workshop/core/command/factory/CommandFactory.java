package OOP09_Workshop.core.command.factory;

import OOP09_Workshop.core.command.Command;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class CommandFactory {
    private static final String BASE_COMMAND_PACKAGE = "L10_Workshop.core.command.";
    private static final String COMMAND_SUFFIX = "Command";

    @SuppressWarnings("unchecked")
    public static Command buildCommand(String name, Object... args){
        try {
            Class commandClass = Class.forName(BASE_COMMAND_PACKAGE + name + COMMAND_SUFFIX);
            Constructor<Command> constructor = commandClass.getDeclaredConstructors()[0];
            return constructor.newInstance(new Object[]{args});
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;

    }

}
