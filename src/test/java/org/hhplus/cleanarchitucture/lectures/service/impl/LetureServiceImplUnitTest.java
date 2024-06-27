package org.hhplus.cleanarchitucture.lectures.service.impl;

import org.hhplus.cleanarchitucture.lectures.model.dto.LectureDto;
import org.hhplus.cleanarchitucture.lectures.model.entity.LectureApplicationEntity;
import org.hhplus.cleanarchitucture.lectures.repository.LectureApplicationJpaRepository;
import org.hhplus.cleanarchitucture.lectures.repository.LectureApplicationRepository;
import org.hhplus.cleanarchitucture.lectures.tool.StudentStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.JpaMetamodelMappingContextFactoryBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) // !서비스 단위테스트 필수!
@EnableJpaAuditing // 자동감지 for localDateTime 필요없을거같은데 단위테스트는 어처피 안나와서
@MockBean(JpaMetamodelMappingContextFactoryBean.class)
class LetureServiceImplUnitTest {

   @Mock // 단위테스트를 위한 모킹 처리
    private LectureApplicationRepository lectureApplicationRepository;

   @Mock
   private LectureApplicationJpaRepository lectureApplicationJpaRepository;

    @InjectMocks
    private LetureServiceImpl lectureService;

    //현재 날짜 구하기
    LocalDateTime now = LocalDateTime.now();
    private final Long userId = 4L;
    private final Long studentId = 1L; // null 미허용 , auto increment 처리
    // DTO 객체 생성
    final LectureDto lectureDto = new LectureDto(105,1,true, StudentStatus.SUCCESS);
    // 서비스 단위테스트 반환 타입 domain (반환 시 entity.toDomain) domain 클래스 불필요
    final LectureApplicationEntity lectureApplicationEntity =
            new LectureApplicationEntity(studentId,userId,1L,now);


    @BeforeEach
    void setUp(){
        lectureApplicationRepository.save(1L,1L);
        lectureApplicationRepository.save(2L,1L);
        //lectureApplicationRepository.save(2L,2L);

    }

    @Test
    @DisplayName("특강 신청")
    public void apply() throws Exception{
        //given
        given(lectureApplicationRepository.save(lectureDto.getUserId(), lectureDto.getLectureId()))
                .willReturn(lectureApplicationEntity.toDomain());
        //when
        Long getId = lectureService.apply(userId,studentId).getUserId(); // setUp에서 저장했던 userId로 다시 하면 예외처리!
        //then
        Assertions.assertEquals(lectureApplicationEntity.toDomain().getUserId(), getId); // DTO == Domain  생성 객체 비교
        // createDate,StudentId 는 Repository 에서 생성 되므로 단위 테스트단계에서는 확인 불가?
        System.out.println(lectureService.apply(userId,studentId).toString());
    }

    @Test
    @DisplayName("특강 신청 결과 조회")
    public void check()  throws Exception{
        //given
        given(lectureApplicationRepository.selectByUserId(lectureDto.getUserId()))
                .willReturn(lectureApplicationEntity.toDomain());
        //when
        //then
        Assertions.assertTrue(lectureService.check(2L).getStudentStatus().equals(StudentStatus.SUCCESS)); // 조회하여 존재할경우 true 존재하지않으면 false

    }
}