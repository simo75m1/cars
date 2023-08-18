package dat3.cars.config;

import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.repository.CarRepository;
import dat3.cars.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
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
        memberRepository.save(new Member("simonhansen", "testkode2", "simonhansen2000@gmail.com", "Simon", "Hansen", "Elstarvej 24", "Valby", "2500"));
    }
}
