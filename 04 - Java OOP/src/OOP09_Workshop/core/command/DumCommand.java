package OOP09_Workshop.core.command;


import OOP09_Workshop.core.system.DumpExtension;

public class DumCommand extends BaseCommand {
    private DumpExtension dumpExtension;

    public DumCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.dumpExtension = (DumpExtension) args[0];
    }

    @Override
    public void execute() {
        System.out.println("5");
    }
}
