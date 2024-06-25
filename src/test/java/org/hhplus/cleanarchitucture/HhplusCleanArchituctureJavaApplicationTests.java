package org.hhplus.cleanarchitucture;

import org.hhplus.cleanarchitucture.lectures.model.entity.LectureApplicationEntity;
import org.hhplus.cleanarchitucture.lectures.repository.LectureApplicationJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 테스트용 시간구하기
import java.time.LocalDate;


@SpringBootTest
@EnableJpaAuditing // 자동감지
class HhplusCleanArchituctureJavaApplicationTests {

    @Autowired
    LectureApplicationJpaRepository lectureApplicationJpaRepository;

    //현재 날짜 구하기 ... 엥? localDataTime 쓰는뎅
    LocalDate now = LocalDate.now();
    @Test
    void save(){
        for(int i =0; i<10; i++)
        {
            LectureApplicationEntity saved = lectureApplicationJpaRepository.save(LectureApplicationEntity.builder().UserId(1L).lectureId(1L).build());
            System.out.println("studentId : " + saved.getStudentId());
            System.out.println("userId : " + saved.getUserId());
            System.out.println("Date : " + saved.getLectureId());
            System.out.println("lectureId : "+  saved.getCreatedDate());
        }


    }

    @Test
    void select(){
        lectureApplicationJpaRepository.save(LectureApplicationEntity.builder().UserId(1L).lectureId(1L).build());
        LectureApplicationEntity lectureApplicationEntity = lectureApplicationJpaRepository.findById(1L).get();
        System.out.println(lectureApplicationEntity.getStudentId());
        System.out.println(lectureApplicationEntity.getUserId());
         System.out.println(lectureApplicationEntity.getLectureId());
        System.out.println(lectureApplicationEntity.getCreatedDate());

    }


}
