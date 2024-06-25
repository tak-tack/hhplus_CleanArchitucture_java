/*
Domain
 */
package org.hhplus.cleanarchitucture.lectures.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class LectureDomain {
    Long userId;
    Long lectureId;
    LocalDateTime createDate;
}
