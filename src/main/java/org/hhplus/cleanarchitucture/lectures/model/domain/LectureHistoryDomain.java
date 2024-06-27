package org.hhplus.cleanarchitucture.lectures.model.domain;

import lombok.Getter;
import lombok.Setter;
import org.hhplus.cleanarchitucture.lectures.model.dto.LectureDto;
import org.hhplus.cleanarchitucture.lectures.tool.StudentStatus;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class LectureHistoryDomain {

    Long historyId;
    Long userId;
    Long lectureId;
    StudentStatus studentStatus;

    public LectureDto toDTO(){
        LectureDto lectureDto = new LectureDto();
        BeanUtils.copyProperties(this, lectureDto);
        return lectureDto;
    }

}


