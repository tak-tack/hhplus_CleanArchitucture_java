package org.hhplus.cleanarchitucture.lectures.model.dto;

import java.util.Date;



// Dto

@Getter
public class lectureDto {
    Long id;
    String lectureName;
    Date lectureOpenTime;
    Long studentCount;
    Long StudentLimit;
    Date createDate;

}

// DTO->DOMAIN 컨버팅?