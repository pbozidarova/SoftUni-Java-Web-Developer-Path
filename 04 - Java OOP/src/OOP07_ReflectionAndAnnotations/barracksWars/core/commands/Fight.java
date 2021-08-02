package OOP07_ReflectionAndAnnotations.barracksWars.core.commands;

public class Fight extends Command {
    public Fight(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.getData()[0];
    }
}
