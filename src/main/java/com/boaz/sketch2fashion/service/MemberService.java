package com.boaz.sketch2fashion.service;

import com.boaz.sketch2fashion.domain.Member;
import com.boaz.sketch2fashion.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member join(Member member) {
        return memberRepository.save(member);
    }

    // 이미지 검색 로직 구현
}
