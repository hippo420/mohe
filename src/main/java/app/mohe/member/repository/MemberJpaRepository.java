package app.mohe.member.repository;

import app.mohe.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberJpaRepository extends JpaRepository<Member,String> {

    //Member findByUserIdAndPassword(String userId, String password);
    //List<Member> findAll();
    Optional<Member> findMemberByUSERID(String userId);
    //Object save(Member member);
}
