package org.hhplus.cleanarchitucture.lectures.repository;

import org.hhplus.cleanarchitucture.lectures.model.entity.LectureHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureHistoryJpaRepository extends JpaRepository <LectureHistoryEntity, Long> {


}
