package org.hhplus.cleanarchitucture.lectures.controller;

import org.hhplus.cleanarchitucture.lectures.service.LectureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest   //통합테스트
// webmockmvc : 어플리케이션 가동일 시키는거고
@AutoConfigureMockMvc // 통합테스트를 위해?
    // controller 테스트인데 service, repository 의존이 있으면 이상하다!
class LectureControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private LectureService lectureService;

    @BeforeEach
    @DisplayName("BeforeEach")
    void setUp(){
        lectureService.apply(1L); // 이 방법은 컨트롤러 테스트 위배됨!
    }



    @Test
    void specialLectureApp() throws Exception{
        //post
        mockMvc.perform(post("/lecture/apply"))
                .andExpect(status().isOk())
                .andDo(print())
                //.andExpect()
        ;
    }

    @Test
    void specialLectureCheck() throws Exception{
    }

    @Test
    void specialLecutreChoice() throws Exception{
    }
}