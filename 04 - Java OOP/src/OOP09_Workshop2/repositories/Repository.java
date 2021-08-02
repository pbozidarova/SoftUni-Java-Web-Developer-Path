package OOP09_Workshop2.repositories;


import OOP09_Workshop2.exeptions.DuplicateModelException;
import OOP09_Workshop2.exeptions.NonExistantModelException;
import OOP09_Workshop2.models.interfaces.Model;

public interface Repository<T extends Model> {
    void add(T entity) throws DuplicateModelException, DuplicateModelException;
    T get(String model) throws NonExistantModelException, NonExistantModelException;

}
