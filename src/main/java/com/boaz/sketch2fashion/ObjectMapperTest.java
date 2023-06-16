package com.boaz.sketch2fashion;

import com.boaz.sketch2fashion.domain.RequestDTO;
import com.boaz.sketch2fashion.domain.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperTest {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        RequestDTO requestDTO = new RequestDTO("test");

        // 요청할 때 객체를 json으로, 인자 : 데이터가 초기화된 객체
        String requestToString = objectMapper.writeValueAsString(requestDTO);
        System.out.println(requestToString);

        // 응답할 때 받은 json을 객체로, 인자 : 데이터가 담긴 json {"body":"test"}
        ResponseDTO responseDTO = objectMapper.readValue(requestToString, ResponseDTO.class);
        System.out.println(responseDTO);
    }
}
