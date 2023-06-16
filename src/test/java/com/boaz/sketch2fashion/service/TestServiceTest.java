package com.boaz.sketch2fashion.service;

import com.boaz.sketch2fashion.domain.RequestDTO;
import com.boaz.sketch2fashion.domain.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class TestServiceTest {
    @Autowired
    private TestService testService;

    @Test
    void objectMapperTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        RequestDTO requestDTO = new RequestDTO("test");

        // 요청할 때 객체를 json으로, 인자 : 데이터가 초기화된 객체
        String requestToString = objectMapper.writeValueAsString(requestDTO);
        System.out.println(requestToString);

        // 응답할 때 받은 json을 객체로, 인자 : 데이터가 담긴 json {"body":"test"}, 대입할 객체 타입
        ResponseDTO responseDTO = objectMapper.readValue(requestToString, ResponseDTO.class);
        System.out.println(responseDTO);
    }

    @Test
    void getAbstractive() throws Exception {
        RequestDTO requestDTO = new RequestDTO("test");
        ResponseDTO responseDTO = testService.getAbstractive(requestDTO);
        log.info("{}", responseDTO);
    }
}