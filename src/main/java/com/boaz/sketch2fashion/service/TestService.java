package com.boaz.sketch2fashion.service;

import com.boaz.sketch2fashion.domain.RequestDTO;
import com.boaz.sketch2fashion.domain.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Service
public class TestService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    public ResponseDTO getAbstractive(RequestDTO requestDTO) throws Exception {
        //헤더 설정
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        // Object Mapper를 통한 JSON 바인딩
        requestDTO.setBody("test");
        String params2 = objectMapper.writeValueAsString(requestDTO);

        // HttpEntity에 헤더 및 params 설정
        HttpEntity entity = new HttpEntity(params2, httpHeaders);

        // RestTemplate의 exchange 메소드를 통해 URL에 HttpEntity와 함께 요청
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:5000/image/test", HttpMethod.POST,
                entity, String.class);

        // 요청 후 응답 확인
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());

        // String to Object
        ResponseDTO responseDTO = objectMapper.readValue(
                responseEntity.getBody(), ResponseDTO.class
        );
        return responseDTO;
    }
}
