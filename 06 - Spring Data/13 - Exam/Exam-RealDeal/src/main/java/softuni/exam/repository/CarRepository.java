package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByMakeAndModelAndKilometers(String make, String model, Integer kilometers);

    Car findAllById(Long id);

    @Query("SELECT c from Car as c ORDER BY c.pictures.size DESC, c.make")
    List<Car> findByPicturesCountAndOrderByCountAndMake();
}
