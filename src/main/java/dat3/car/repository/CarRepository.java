package dat3.car.repository;

import dat3.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
    List<Car> findCarByBrand(String brand);
    List<Car> findCarsByBrandAndModel(String brand, String model);
    Car findCarByBrandAndModel(String brand, String model);
    //double findAveragePricePerDayForAllCars();

}
