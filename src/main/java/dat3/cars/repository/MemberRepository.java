package dat3.cars.repository;

import dat3.cars.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>
{
    @Query
    Member findByEmail(String email);
}
