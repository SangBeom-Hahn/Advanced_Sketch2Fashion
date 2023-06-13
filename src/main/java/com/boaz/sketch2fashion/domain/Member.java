package com.boaz.sketch2fashion.domain;

import lombok.Getter;

@Getter
public class Member {
    private Long id;
    private String name;
    private String loginId;
    private String password;
    private String email;
}
