package OOP07_ReflectionAndAnnotations.barracksWars.core.commands;

import L7_Reflection.barracksWars.annotations.Inject;
import L7_Reflection.barracksWars.interfaces.Repository;

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
