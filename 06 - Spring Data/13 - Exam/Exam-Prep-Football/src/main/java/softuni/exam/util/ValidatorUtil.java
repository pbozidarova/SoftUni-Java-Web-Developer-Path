package softuni.exam.util;


import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidatorUtil {

    <E> boolean isValid(E entity);
    <T> Set<ConstraintViolation<T>> violations(T entity);



}
