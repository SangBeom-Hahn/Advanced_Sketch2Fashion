package com.boaz.sketch2fashion.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private Long id;
    private String name;
    private String loginId;
    private String password;
    private String email;

    public Member(String name, String loginId, String password, String email) {
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.email = email;
    }

    public Member() {
    }
}
