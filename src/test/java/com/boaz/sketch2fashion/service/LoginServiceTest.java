package com.boaz.sketch2fashion.service;

import com.boaz.sketch2fashion.domain.Member;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginServiceTest {
    @Autowired
    private LoginService loginService;

    @Autowired
    private MemberService memberService;

    @Test
    void login() {
        //given
        Member memberA = new Member("A", "A", "A", "A");

        //when
        Member joinMember = memberService.join(memberA);
        Member loginMember = loginService.login(memberA.getLoginId(), memberA.getPassword());

        //then
        assertThat(joinMember).isEqualTo(loginMember);
    }

    @Test
    void loginFail() {
        //given
        Member memberA = new Member("A", "A", "A", "A");

        //when
        Member joinMember = memberService.join(memberA);

        //then
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> loginService.login("B", memberA.getPassword()))
                .isInstanceOf(EmptyResultDataAccessException.class);
    }
}