package OOP09_Workshop2.core;


import OOP09_Workshop2.exeptions.ArgumentException;
import OOP09_Workshop2.exeptions.NonExistantModelException;
import OOP09_Workshop2.models.Boat;
import OOP09_Workshop2.models.Engine;
import OOP09_Workshop2.repositories.Repository;

public interface BoatFactory extends Repository<Boat> {
    Boat produce(String[] args) throws ArgumentException, NonExistantModelException;
    void setEngineRepository(Repository<Engine> engineRepository);
}
