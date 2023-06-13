package com.boaz.sketch2fashion.repository.member.dto;

import lombok.Data;

@Data
public class MemberSaveDTO {
    private String name;
    private String loginId;
    private String password;
    private String email;
}