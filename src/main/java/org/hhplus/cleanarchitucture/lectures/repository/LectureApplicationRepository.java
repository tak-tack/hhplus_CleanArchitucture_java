package org.hhplus.cleanarchitucture.lectures.repository;

import org.hhplus.cleanarchitucture.lectures.model.domain.LectureApplicationDomain;

public interface LectureApplicationRepository {

     LectureApplicationDomain selectByUserId(Long userId);
     LectureApplicationDomain save(Long userId, Long lectureId);

}
