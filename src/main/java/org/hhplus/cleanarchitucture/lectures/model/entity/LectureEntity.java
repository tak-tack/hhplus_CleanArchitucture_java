/*
entity
테이블과 1대1 매핑관계
*/
package org.hhplus.cleanarchitucture.lectures.model.entity;

import jakarta.persistence.*;
import lombok.*;

import org.hhplus.cleanarchitucture.lectures.model.domain.LectureDomain;
//import org.hhplus.cleanarchitucture.lectures.tool.StudentLimit;
import org.springframework.beans.BeanUtils;


@Getter
@Setter
@Builder
@Entity
@Table(name="lecture")
@AllArgsConstructor
@NoArgsConstructor
public class LectureEntity{

    @Id // PK를 뜻함
    @GeneratedValue (strategy = GenerationType.AUTO) // primary key 에 맞춰서 autoIncrement 옵션
    Long lectureId; // 고유 번호
    String lectureName; // 특강 이름
    Long studentCount; // 특강 신청 인원
    //StudentLimit studentLimit; // 특강 신청 인원 제한 enum 타입
    //Date createDate;

    public LectureEntity(LectureDomain lectureDomain){
        BeanUtils.copyProperties(lectureDomain,this);
    }

//    public static LectureEntity empty(Long id){
//        //return new LectureEntity(1L, null,null,null,null,null);
//    }

    public LectureDomain toDomain(){
        LectureDomain lectureDomain = new LectureDomain();
        BeanUtils.copyProperties(this, lectureDomain);
        return lectureDomain;
    }



}