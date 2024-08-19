package com.moa.gamemoa.repository;

import com.moa.gamemoa.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.id = :memberId")
    Optional<Member> findMember(Long memberId);

    boolean existsByIdAndUserPass(Long id, String userPass);
}
