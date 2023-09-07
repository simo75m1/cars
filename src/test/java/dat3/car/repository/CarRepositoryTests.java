package dat3.car.repository;

import dat3.car.entity.Car;
import dat3.car.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CarRepositoryTests
{
    @Autowired
    CarRepository carRepository;

    @BeforeEach
    void setUp(){}
    @Test
    void testCarBrandSearch(){
        carRepository.save(new Car("Toyota", "Supra", 1500, 500));
        assertThat(carRepository.findCarByBrand("Toyota")).isNotNull();
    }

    @Test
    void testCarBrandAndModelSearch(){
        carRepository.save(new Car("BMW", "X5", 1000, 200));
        carRepository.save(new Car("BMW", "M3", 1000, 200));

        assertThat(carRepository.findCarByBrandAndModel("BMW", "M3")).isNotNull();
    }


}