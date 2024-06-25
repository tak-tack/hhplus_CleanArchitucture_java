package org.hhplus.cleanarchitucture.lectures.model.domain;

import lombok.Getter;
import lombok.Setter;
import org.hhplus.cleanarchitucture.lectures.model.dto.LectureDto;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Getter
@Setter
public class LectureApplicationDomain {
    Long userId;
    Long lectureId;
    LocalDateTime createDate;

    // domain > DTO converting
    public LectureDto toDTO(){
        LectureDto lectureDto = new LectureDto();
        BeanUtils.copyProperties(this, lectureDto);
        return lectureDto;
    }
}
