package OOP09_Workshop.core.command;

import OOP09_Workshop.core.model.hardware.Hardware;
import OOP09_Workshop.core.model.hardware.HeavyHardware;
import OOP09_Workshop.core.system.SystemSplit;

public class RegisterHeavyHardwareCommand extends BaseCommand {
    private SystemSplit systemSplit;
    private String name;
    private int capacity;
    private int memory;

    public RegisterHeavyHardwareCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
        this.name = args[1].toString();
        this.capacity = Integer.parseInt(args[2].toString());
        this.memory = Integer.parseInt(args[3].toString());
    }

    @Override
    public void execute() {
        Hardware hardware = new HeavyHardware(this.name, this.capacity, this.memory);
        this.systemSplit.addHardwareComponent(hardware);
    }
}
