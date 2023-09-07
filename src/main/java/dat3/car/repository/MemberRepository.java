package dat3.car.repository;

import dat3.car.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    Member findByEmail(String email);
    //List<Member> findAllMembersWithReservations();

}
