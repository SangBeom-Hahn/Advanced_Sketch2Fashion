package com.boaz.sketch2fashion.controller;

import com.boaz.sketch2fashion.domain.RequestDTO;
import com.boaz.sketch2fashion.domain.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TestController {
    @PostMapping("/test")
    public ResponseEntity<ResponseDTO> testApi(@RequestBody RequestDTO requestDTO) {
        ResponseDTO responseDTO = new ResponseDTO(requestDTO.getBody());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
