package com.boaz.sketch2fashion.repository.member;

import com.boaz.sketch2fashion.domain.Member;
import com.boaz.sketch2fashion.repository.member.dto.MemberSaveDTO;
import com.boaz.sketch2fashion.repository.member.dto.MemberUpdateDTO;

public interface MemberRepository {
    Member save(Member member);
    Member findById(Long id);
    Member findByLoginId(String loginId);
    void update(Long id, MemberUpdateDTO memberUpdateDTO);

    void delete(Long id);
}
