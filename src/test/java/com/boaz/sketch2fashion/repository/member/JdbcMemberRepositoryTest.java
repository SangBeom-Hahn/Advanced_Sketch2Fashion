package com.boaz.sketch2fashion.repository.member;

import com.boaz.sketch2fashion.domain.Member;
import com.boaz.sketch2fashion.repository.member.dto.MemberUpdateDTO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class JdbcMemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void save() {
        // given
        Member memberA = new Member("a", "a", "a", "a");

        // when
        Member saveMember = memberRepository.save(memberA);

        // then
        assertThat(memberA).isEqualTo(saveMember);
        System.out.println(memberA);
        System.out.println(saveMember);
    }

    @Test
    @DisplayName("회원 저장 실패")
    void saveFail() {
        // given
        Member memberA = new Member("a", "a", "a", "a");

        // when
        memberRepository.save(memberA);

        // then
        Assertions.assertThatThrownBy(() -> memberRepository.save(memberA))
                .isInstanceOf(DuplicateKeyException.class);
    }
    @Test
    void findById() {
        // given
        Member memberA = new Member("a", "a", "a", "a");

        // when
        Member saveMember = memberRepository.save(memberA);
        log.info("{}", saveMember.getId());
        Member findMember = memberRepository.findById(saveMember.getId());
        log.info("{}", saveMember.getId());
        log.info("{}", findMember.getId());

        // then
        assertThat(saveMember).isEqualTo(findMember);
    }

    @Test
    void findByLoginId() {
        // given
        Member memberA = new Member("a", "a", "a", "a");

        // when
        Member saveMember = memberRepository.save(memberA);
        Member findMember = memberRepository.findByLoginId(saveMember.getLoginId()).orElse(null);

        // then
        assertThat(saveMember).isEqualTo(findMember);
    }

    @Test
    void update() {
        // given
        Member member = new Member("a", "a", "a", "a");

        // when
        Member saveMember = memberRepository.save(member);
        memberRepository.update(saveMember.getId(), new MemberUpdateDTO("b", "b", "b", "b"));
        Member updateMember = memberRepository.findByLoginId("b").orElse(null);

        // then
        assertThat(updateMember.getEmail()).isEqualTo("b");
    }

    @Test
    void delete() {
        // given
        Member member = new Member("a", "a", "a", "a");

        // when
        Member saveMember = memberRepository.save(member);
        memberRepository.delete(saveMember.getId());

        // then
        Assertions.assertThatThrownBy(() -> memberRepository.findByLoginId("a"))
                .isInstanceOf(EmptyResultDataAccessException.class);
    }
}
