package OOP06_SOLID.solidLab.p05_DependencyInversion.p02_Worker;

public class Manager {

    private Worker worker;

    public Manager(Worker worker) {

        this.worker = worker;
    }

    private void init(){
        this.worker.work();
    }
}
