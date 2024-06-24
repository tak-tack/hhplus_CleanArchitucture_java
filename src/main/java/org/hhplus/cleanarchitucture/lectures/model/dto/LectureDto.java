/*
Dto
 */
package org.hhplus.cleanarchitucture.lectures.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;


// DTO->DOMAIN 컨버팅?
@Getter
@Setter
@AllArgsConstructor // 모든 인자를 만들어주는 생성자 주입, 생성자를 만들 때 생성받을 인자값에 대해서 모든 값을 받는다.
@NoArgsConstructor // 인자값에 아무것도 안받는 생성자 행성(기본생성자)
public class LectureDto {
    Long id; // 고유 번호
    String lectureName; // 특강 이름
    @DateTimeFormat(pattern = "MM월 dd일 E요일 HH시")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM월 dd일 E요일 HH시", timezone = "Asia/Seoul")
        String lectureOpenTime; // 특강 오픈시간
    //SimpleDateFormat lectureOpenTime = new SimpleDateFormat("MM월 dd일 E요일 HH시");// 특강 오픈시간
    Long studentCount;
    Long StudentLimit;
    boolean applicationCheck;

}

