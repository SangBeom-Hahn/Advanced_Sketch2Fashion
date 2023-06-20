package com.boaz.sketch2fashion.config;

import com.boaz.sketch2fashion.domain.Member;
import com.boaz.sketch2fashion.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
public class TestInitData {
    private final MemberRepository memberRepository;
    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
//        memberRepository.save(new Member("a", "a", "a", "a"));
    }
}
