package dat3.cars.repository;

import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class RepositoryTests
{
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(carRepository).isNotNull();
        assertThat(memberRepository).isNotNull();
    }

    @Test
    void carBrandSearch(){
        carRepository.save(new Car("Toyota", "Supra", 1500, 500));
        assertThat(carRepository.findCarByBrand("Toyota")).isNotNull();
    }

    @Test
    void carBrandAndModelSearch(){
        carRepository.save(new Car("BMW", "X5", 1000, 200));
        carRepository.save(new Car("BMW", "M3", 1000, 200));

        assertThat(carRepository.findCarByBrandAndModel("BMW", "M3")).isNotNull();
    }

    @Test
    void memberEmailSearch(){
        memberRepository.save(new Member("simo75m1", "testkode1", "simo75m1@stud.kea.dk", "Simon", "Hansen", "Elstarvej 24", "Valby", "2500"));

        assertThat(memberRepository.findByEmail("simo75m1@stud.kea.dk")).isNotNull();
    }
}