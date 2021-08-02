package OOP07_ReflectionAndAnnotations.barracksWars.core.commands;


import OOP07_ReflectionAndAnnotations.barracksWars.annotations.Inject;
import OOP07_ReflectionAndAnnotations.barracksWars.interfaces.Repository;

public class Report extends Command {
    @Inject
    private Repository repository;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
