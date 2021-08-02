package OOP09_Workshop2.repositories;

import L10_Workshop_2.exeptions.DuplicateModelException;
import L10_Workshop_2.exeptions.NonExistantModelException;
import L10_Workshop_2.models.interfaces.Model;

public interface Repository<T extends Model> {
    void add(T entity) throws DuplicateModelException;
    T get(String model) throws NonExistantModelException;

}
