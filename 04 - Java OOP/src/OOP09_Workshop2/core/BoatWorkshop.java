package OOP09_Workshop2.core;


import OOP09_Workshop2.exeptions.ArgumentException;
import OOP09_Workshop2.exeptions.DuplicateModelException;
import OOP09_Workshop2.exeptions.NonExistantModelException;
import OOP09_Workshop2.models.*;
import OOP09_Workshop2.repositories.Repository;

public class BoatWorkshop implements BoatFactory {
    private Repository<Engine> engineRepository;

    @Override
    public void setEngineRepository(Repository<Engine> engineRepository){
        this.engineRepository = engineRepository;
    }

    @Override
    public Boat produce(String[] args) throws ArgumentException, NonExistantModelException {
        String typeContainer =  args[0];

        Boat boat = null;

        if(typeContainer.contains("RowBoat")){
            boat = new RowBoat(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        }else if(typeContainer.contains("SailBoat")){
            boat = new SailBoat(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));

        }else if(typeContainer.contains("PowerBoat")){
            boat = new PowerBoat(args[1], Integer.parseInt(args[2]),
                    this.engineRepository.get(args[3]),
                    this.engineRepository.get(args[4]));
        }else if(typeContainer.contains("Yacht")){
            boat = new Yacht(args[1], Integer.parseInt(args[2]),
                    this.engineRepository.get(args[3]),
                    Integer.parseInt(args[4]));
        }
        return boat;
    }

    @Override
    public void add(Boat entity) throws DuplicateModelException {

    }

    @Override
    public Boat get(String model) throws NonExistantModelException {
        return null;
    }
}
