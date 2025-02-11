package OOP09_Workshop.core.command;


import OOP09_Workshop.core.system.SystemSplit;

public class ReleaseSoftwareComponentCommand extends BaseCommand {
    private SystemSplit systemSplit;
    private String hardwareName;
    private String softwareName;

    public ReleaseSoftwareComponentCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
        this.hardwareName = args[1].toString();
        this.softwareName = args[2].toString();
    }

    @Override
    public void execute() {
        this.systemSplit.releaseToSoftware(hardwareName, softwareName);
    }
}
