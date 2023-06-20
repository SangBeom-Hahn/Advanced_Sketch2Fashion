package com.boaz.sketch2fashion.domain;

import lombok.Data;

@Data
public class RequestDTO {
    private String body;

    public RequestDTO(String body) {
        this.body = body;
    }

    public RequestDTO() {
    }
}
