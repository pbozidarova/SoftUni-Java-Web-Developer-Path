package OOP07_ReflectionAndAnnotations.barracksWars.core.commands;


import OOP07_ReflectionAndAnnotations.barracksWars.interfaces.Executable;

public abstract class Command implements Executable {
    private String[] data;


    protected Command(String data[]) {
        this.data = data;
    }

    protected String[] getData() {
        return this.data;
    }

    public abstract String execute();
}
