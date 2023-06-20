package com.boaz.sketch2fashion.domain;

import lombok.Data;

@Data
public class ResponseDTO {
    private String body;

    public ResponseDTO(String body) {
        this.body = body;
    }

    public ResponseDTO() {
    }
}
