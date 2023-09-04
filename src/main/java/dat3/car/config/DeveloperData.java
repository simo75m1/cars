package dat3.car.config;

import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
public class DeveloperData implements ApplicationRunner{

    CarRepository carRepository;
    MemberRepository memberRepository;

    @Autowired
    public DeveloperData(CarRepository carRepository, MemberRepository memberRepository)
    {
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Car test data created by chat-gpt
        carRepository.save(new Car("Toyota", "Supra", 1500, 500));
        carRepository.save(new Car("Toyota", "Camry", 1200, 250));
        carRepository.save(new Car("Ford", "Mustang", 1000, 150));
        carRepository.save(new Car("Chevrolet", "Cruze", 800, 100));
        carRepository.save(new Car("Honda", "Civic", 900, 200));
        carRepository.save(new Car("Nissan", "Altima", 1100, 300));
        carRepository.save(new Car("BMW", "X5", 1500, 450));
        carRepository.save(new Car("Mercedes-Benz", "E-Class", 1400, 400));
        carRepository.save(new Car("Audi", "A4", 1300, 350));
        carRepository.save(new Car("Volkswagen", "Golf", 950, 180));
        carRepository.save(new Car("Tesla", "Model S", 2000, 500));
        carRepository.save(new Car("Hyundai", "Elantra", 850, 130));
        carRepository.save(new Car("Kia", "Soul", 750, 80));
        carRepository.save(new Car("Subaru", "Outback", 1300, 230));
        carRepository.save(new Car("Mazda", "CX-5", 1100, 210));
        carRepository.save(new Car("Lexus", "RX", 1800, 390));
        carRepository.save(new Car("Infiniti", "Q50", 1700, 350));
        carRepository.save(new Car("Porsche", "911", 3000, 500));
        carRepository.save(new Car("Ferrari", "488 GTB", 4000, 500));
        carRepository.save(new Car("Lamborghini", "Huracan", 4500, 500));
        carRepository.save(new Car("Maserati", "Ghibli", 2500, 480));
        carRepository.save(new Car("Jeep", "Wrangler", 1200, 220));
        carRepository.save(new Car("GMC", "Sierra", 1400, 280));
        carRepository.save(new Car("Ram", "1500", 1300, 300));
        carRepository.save(new Car("Chevrolet", "Silverado", 1500, 320));
        carRepository.save(new Car("Ford", "F-150", 1600, 350));
        carRepository.save(new Car("Toyota", "Tacoma", 1300, 270));
        carRepository.save(new Car("Nissan", "Titan", 1400, 280));
        carRepository.save(new Car("Honda", "Ridgeline", 1200, 250));
        carRepository.save(new Car("Dodge", "Charger", 1100, 220));
        carRepository.save(new Car("Chrysler", "300", 1000, 200));
        carRepository.save(new Car("Buick", "Regal", 900, 150));
        carRepository.save(new Car("Cadillac", "CTS", 1600, 320));
        carRepository.save(new Car("Lincoln", "Continental", 1800, 380));
        carRepository.save(new Car("Acura", "TLX", 1400, 260));
        carRepository.save(new Car("Volvo", "S60", 1500, 280));
        carRepository.save(new Car("Jaguar", "XF", 1700, 300));
        carRepository.save(new Car("Land Rover", "Range Rover", 2000, 420));
        carRepository.save(new Car("Mitsubishi", "Outlander", 1100, 210));
        carRepository.save(new Car("Mini", "Cooper", 900, 170));
        carRepository.save(new Car("Fiat", "500", 800, 150));
        carRepository.save(new Car("Smart", "Fortwo", 700, 130));
        carRepository.save(new Car("Genesis", "G70", 1600, 310));
        carRepository.save(new Car("Kia", "Stinger", 1400, 290));
        carRepository.save(new Car("Subaru", "Impreza", 950, 180));
        carRepository.save(new Car("Hyundai", "Tucson", 1100, 210));
        carRepository.save(new Car("Volkswagen", "Tiguan", 1200, 230));
        carRepository.save(new Car("Mazda", "Mazda3", 1000, 200));
        carRepository.save(new Car("Toyota", "Rav4", 1300, 240));
        carRepository.save(new Car("Ford", "Escape", 1200, 220));

        memberRepository.save(new Member("simo75m1", "testkode1", "simo75m1@stud.kea.dk", "Simon", "Hansen", "Elstarvej 24", "Valby", "2500"));
        memberRepository.save(new Member("simonhansen", "testkode1", "simonhansen2000@hotmail.com", "Simon", "Hansen", "Elstarvej 24", "Valby", "2500"));

    }
}
