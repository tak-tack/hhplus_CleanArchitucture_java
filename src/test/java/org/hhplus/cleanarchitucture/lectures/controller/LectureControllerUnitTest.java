package org.hhplus.cleanarchitucture.lectures.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest - 통합
// 통합 테스트... webmockmvc : 어플리케이션 가동일 시키는거고
// 단위테스트라고 보기힘듬
// 컨트롤러 테스트하는이유가 호출할때 데이터를 받기위해 사용.
// 컨트롤러 자체를 new로 생성. 또는 injectmock
//@AutoConfigureMockMvc
@WebMvcTest(LectureController.class) // - 단위테스트
class LectureControllerUnitTest {

    @Autowired
    private MockMvc mockMvc; // E2E 테스트.. api 호출 하려고 쓰는용도

    @InjectMocks
    LectureController lectureController;

    private final long userId = 1;

    @Test
    @DisplayName("특강 신청 API")
    void specialLectureApp() throws Exception {
        //post
        mockMvc.perform(post("/lecture/apply"))
                .andExpect(status().isOk())
                .andDo(print());
        lectureController.specialLectureApp();
    }

    @Test
    @DisplayName("특강 신청 완료 여부 조회 API")
    void specialLectureCheck() throws Exception {
        mockMvc.perform(get("/lecture/{userId}/application",userId))
                .andExpect(status().isOk())
                .andDo(print());
        ;
    }

    @Test
    @DisplayName("특강 선택 API")
    void specialLecutreChoice() throws Exception {
    }
}