package dat3.car.repository;

import dat3.car.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class MemberRepositoryTest {


    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    void setUp(){}

    @Test
    void memberEmailSearch(){
        memberRepository.save(new Member("simo75m1", "testkode1", "simo75m1@stud.kea.dk", "Simon", "Hansen", "Elstarvej 24", "Valby", "2500"));

        assertThat(memberRepository.findByEmail("simo75m1@stud.kea.dk")).isNotNull();
    }
}