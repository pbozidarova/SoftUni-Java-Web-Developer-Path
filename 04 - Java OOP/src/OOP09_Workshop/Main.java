package OOP09_Workshop;

import OOP09_Workshop.core.engine.Engine;
import OOP09_Workshop.core.system.DumpExtension;
import OOP09_Workshop.core.system.SystemSplit;
import OOP09_Workshop.io.reader.ConsoleReader;
import OOP09_Workshop.io.reader.Reader;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        SystemSplit systemSplit = new DumpExtension();
        Engine engine = new Engine(systemSplit, reader);
        engine.run();
    }


}
