package OOP09_Workshop.core.engine;

import OOP09_Workshop.core.command.Command;
import OOP09_Workshop.core.command.factory.CommandFactory;
import OOP09_Workshop.core.system.SystemSplit;
import OOP09_Workshop.io.reader.Reader;
import OOP09_Workshop2.models.interfaces.Model;

public class Engine implements Model {
    private static final String END_COMMAND = "System Split";

    private SystemSplit systemSplit;
    private Reader reader;

    public Engine(SystemSplit systemSplit, Reader reader) {
        this.systemSplit = systemSplit;
        this.reader = reader;
    }

    public void run(){
        String line = this.reader.readLine();
        while (!END_COMMAND.equalsIgnoreCase(line)){
            String[] tokens = line.split("[\\(,\\s\\)]+");
            String commandName = tokens[0];
            Object[] params = new Object[tokens.length];
            params[0] = this.systemSplit;
            for (int i = 1; i < tokens.length; i++) {
                params[i] = tokens[i];
            }
            Command command = CommandFactory.buildCommand(commandName, params);
            command.execute();
            line = this.reader.readLine();
        }

        Command command = CommandFactory.buildCommand("SystemSplit", this.systemSplit);
        command.execute();
    }
}
