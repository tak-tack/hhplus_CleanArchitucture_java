package org.hhplus.cleanarchitucture.lectures.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hhplus.cleanarchitucture.lectures.model.dto.LectureDto;
import org.hhplus.cleanarchitucture.lectures.service.LectureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// 컨트롤러 테스트하는이유가 호출할때 데이터를 받기위해 사용.
// 컨트롤러 자체를 new로 생성. 또는 injectmocks
@WebMvcTest(LectureController.class)
class LectureControllerUnitTest {

    @Autowired
    private MockMvc mockMvc; // 서버 실행 없이 Controller 테스트 환경 지원 모든 컨트롤러테스트에 사용

    @MockBean
    private LectureService lectureService; // 가짜 서비스..
    @InjectMocks
    LectureController lectureController;

    private final Long userId = 1L;


    @Test
    @DisplayName("특강 신청 API")
    void specialLectureApp() throws Exception {
        LectureDto lectureDto = new LectureDto(0,0);
        ObjectMapper objectMapper = new ObjectMapper();
        //post
        mockMvc.perform(post("/lecture/apply").content(
                objectMapper.writeValueAsString(lectureDto))
                        .contentType(APPLICATION_JSON))  // post 방식으 어뜨케? 걍 하믄되나?.. 똑같다! 패치랑동일하다!
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("특강 신청 완료 여부 조회 API")
    void specialLectureCheck() throws Exception {
        //get
        mockMvc.perform(get("/lecture/{id}/application",1L))
                .andExpect(status().isOk())
                .andDo(print());

    }

    // 잠시보류
    @Test
    @DisplayName("특강 선택 API")
    void specialLecutreChoice() throws Exception {
    }
}