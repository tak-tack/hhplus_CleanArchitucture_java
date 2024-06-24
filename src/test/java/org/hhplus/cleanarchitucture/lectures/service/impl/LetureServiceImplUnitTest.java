package org.hhplus.cleanarchitucture.lectures.service.impl;

import org.hhplus.cleanarchitucture.lectures.model.dto.LectureDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith("") //
//@WebMvcTest(LetureServiceImpl.class) // 서비스에서는 불필요! endpoint  mock객체를 유연하게 쓸라면
class LetureServiceImplUnitTest {

    //@Autowired
    //private MockMvc mockMvc;

    @InjectMocks
    LetureServiceImpl letureService;

    private final Long userId = 1L;
    private final Long studentCount = 1L;
    private final Long StudentLimit = 10L;

    @Test
    @DisplayName("특강 신청")
    public void apply() throws Exception{
        //given
        LectureDto lectureDto = new LectureDto(userId,"특강", "06월 23일 일요일 11시",studentCount,StudentLimit,true);
        letureService.apply(lectureDto.getId());
    }

    @Test
    @DisplayName("특강 신청 결과 조회")
    public void check()  throws Exception{
        //given
        LectureDto lectureDto = new LectureDto(userId,"특강", "06월 23일 일요일 11시",studentCount,StudentLimit,true);
        letureService.check(lectureDto.getId());
    }
}