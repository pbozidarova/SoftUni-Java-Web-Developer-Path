package OOP09_Workshop;

import L10_Workshop.core.engine.Engine;
import L10_Workshop.core.system.DumpExtension;
import L10_Workshop.core.system.SystemSplit;
import L10_Workshop.io.reader.ConsoleReader;
import L10_Workshop.io.reader.Reader;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        SystemSplit systemSplit = new DumpExtension();
        Engine engine = new Engine(systemSplit, reader);
        engine.run();
    }


}
