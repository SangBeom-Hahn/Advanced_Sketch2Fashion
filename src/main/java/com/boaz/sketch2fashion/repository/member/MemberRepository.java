package com.boaz.sketch2fashion.repository.member;

import com.boaz.sketch2fashion.domain.Member;
import com.boaz.sketch2fashion.repository.member.dto.MemberUpdateDTO;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Member findById(Long id);
    Optional<Member> findByLoginId(String loginId);
    void update(Long id, MemberUpdateDTO memberUpdateDTO);
    void delete(Long id);
}
