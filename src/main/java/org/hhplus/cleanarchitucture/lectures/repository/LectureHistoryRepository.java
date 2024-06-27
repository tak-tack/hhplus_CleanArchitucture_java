package org.hhplus.cleanarchitucture.lectures.repository;

import org.hhplus.cleanarchitucture.lectures.model.domain.LectureHistoryDomain;
import org.hhplus.cleanarchitucture.lectures.tool.StudentStatus;

public interface LectureHistoryRepository{

    LectureHistoryDomain selectByParams(Long userId);

    LectureHistoryDomain save(Long userId, Long lectureId, StudentStatus studentStatus);
}
