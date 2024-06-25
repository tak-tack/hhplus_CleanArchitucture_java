/*
Domain
 */
package org.hhplus.cleanarchitucture.lectures.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LectureDomain {
    Long id; // 고유 번호
    String lectureName; // 특강 이름
    Date lectureOpenTime; // 특강
    Long studentCount;
    Long StudentLimit;
    Date createDate;
}
