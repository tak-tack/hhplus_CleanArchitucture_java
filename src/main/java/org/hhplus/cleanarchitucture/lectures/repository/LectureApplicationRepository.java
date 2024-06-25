package org.hhplus.cleanarchitucture.lectures.repository;

import org.hhplus.cleanarchitucture.lectures.model.domain.LectureDomain;

public interface LectureApplicationRepository {

     void selectByUserId(Long userId);
     void save(Long userId);

}
