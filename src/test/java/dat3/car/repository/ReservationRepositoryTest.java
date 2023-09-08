package dat3.car.repository;

import dat3.car.dto.MemberResponse;
import dat3.car.dto.ReservationResponse;
import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.entity.Reservation;
import dat3.car.service.MemberService;
import dat3.car.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ReservationRepositoryTest {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    MemberRepository memberRepository;
    Car c1, c2;
    Member m1, m2;
    //HAVE TO SAVE CAR AND MEMBER TO THEIR REPOS OR YOU GET INTEGRITY CONSTRAINT VIOLATION
    @BeforeEach
    void setUp(){
        c1 = new Car(1,"Toyota", "Aygo", 300, 100);
        c2 = new Car(2,"Toyota", "Supra", 600, 300);
        carRepository.save(c1);
        carRepository.save(c2);
        m1 = new Member("user1", "pw1", "email1", "fn1", "ln1",  "street1", "city1", "zip1");
        m2 = new Member("user2", "pw2", "email2", "fn2", "ln2", "street2", "city2", "zip2");
        memberRepository.save(m1);
        memberRepository.save(m2);
        reservationRepository.save(new Reservation(LocalDate.now().plusDays(5), c1, m1));
        reservationRepository.save(new Reservation(LocalDate.now().plusDays(10), c2, m1));
        //reservationService = new ReservationService(reservationRepository); //Set up memberService with the mock (H2) database

    }
    @Test
    void testFindReservationsByUsername(){
        List<Reservation> reservations = reservationRepository.findAllReservationsByMemberUsername(m1.getUsername());
        assertEquals(2, reservations.size());
    }


}