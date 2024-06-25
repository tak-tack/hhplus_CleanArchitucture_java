package org.hhplus.cleanarchitucture.lectures.service;

import org.hhplus.cleanarchitucture.lectures.model.domain.LectureDomain;

public interface LectureService {

    LectureDomain apply(long userId);
    boolean check(Long userId);



}
