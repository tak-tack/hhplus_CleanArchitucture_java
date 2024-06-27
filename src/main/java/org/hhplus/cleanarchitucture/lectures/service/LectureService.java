package org.hhplus.cleanarchitucture.lectures.service;

import org.hhplus.cleanarchitucture.lectures.model.dto.LectureDto;

public interface LectureService {

    LectureDto apply(Long userId, Long lectureId);
    boolean check(Long userId);



}
