package org.hhplus.cleanarchitucture.lectures.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hhplus.cleanarchitucture.lectures.model.dto.LectureDto;
import org.hhplus.cleanarchitucture.lectures.service.LectureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest   //통합테스트
@EnableJpaAuditing // 자동감지 for localDateTime 필요없을거같은데 단위테스트는 어처피 안나와서
@AutoConfigureMockMvc // 통합테스트를 위해?
//@WebMvcTest(LetureServiceImpl.class) // 서비스에서는 불필요! endpoint  mock객체를 유연하게 쓸라면
// controller 테스트인데 service, repository 의존이 있으면 이상하다!
class LectureControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private LectureService lectureService;
    @Autowired
    private ObjectMapper jacksonObjectMapper;

    @BeforeEach
    void setUp(){

        lectureService.apply(1L,1L); // 이 방법은 컨트롤러 테스트 위배됨!
        lectureService.apply(2L,1L);
        //lectureService.apply(2L,1L); 성공했던 유저아이디로 특강 신청 불가!

    }
    @Test
    @DisplayName("apply")
    void specialLectureApp() throws Exception{
        //post
        LectureDto lectureDto = new LectureDto(3,1); // setUp에서 저장했던 userId로 다시 하면 예외처리!
        mockMvc.perform(post("/lecture/apply").content(
                 jacksonObjectMapper.writeValueAsString(lectureDto))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
        ;
    }

    @Test
    void specialLectureCheck() throws Exception{
        // get
        mockMvc.perform(get("/lecture/{id}/application",1L))
                .andExpect(status().isOk())
                .andDo(print())
        ;
    }

    @Test
    void specialLecutreChoice() throws Exception{
    }
}