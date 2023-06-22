package com.boaz.sketch2fashion.repository.member;

import com.boaz.sketch2fashion.domain.Member;
import com.boaz.sketch2fashion.repository.member.dto.MemberUpdateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class JdbcMemberRepository implements MemberRepository {
    private final NamedParameterJdbcTemplate template;

    public JdbcMemberRepository(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        String sql = "insert into member(name, login_id, password, email) values(:name, :loginId, :password, :email)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource param = new BeanPropertySqlParameterSource(member);
        template.update(sql, param, keyHolder);

        long key = keyHolder.getKey().longValue();
        member.setId(key);
        return member;
    }

    @Override
    public Member findById(Long id) {
        String sql = "select * from member where member_id = :id";
        Map<String, Object> param = Map.of("id", id);
        Member member = template.queryForObject(sql, param, memberRowMapper());
        return member;
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        String sql = "select * from member where login_id = :loginId";
        Map<String, Object> param = Map.of("loginId", loginId);
        Member member = template.queryForObject(sql, param, memberRowMapper());
        return Optional.ofNullable(member);
    }

    @Override
    public void update(Long id, MemberUpdateDTO memberUpdateDTO) {
        String sql = "update member set name = :name, login_id = :loginId, password = :password, email = :email where member_id = :id";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("name", memberUpdateDTO.getName())
                .addValue("loginId", memberUpdateDTO.getLoginId())
                .addValue("password", memberUpdateDTO.getPassword())
                .addValue("email", memberUpdateDTO.getEmail())
                .addValue("id", id);

        template.update(sql, param);
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from member where member_id = :id";
        Map<String, Object> param = Map.of("id", id);
        template.update(sql, param);
    }

    private RowMapper<Member> memberRowMapper() {
        return BeanPropertyRowMapper.newInstance(Member.class);
    }
}
