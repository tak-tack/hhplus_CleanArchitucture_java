package org.hhplus.cleanarchitucture.lectures.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hhplus.cleanarchitucture.lectures.model.domain.LectureHistoryDomain;
import org.hhplus.cleanarchitucture.lectures.model.entity.LectureHistoryEntity;
import org.hhplus.cleanarchitucture.lectures.repository.LectureHistoryJpaRepository;
import org.hhplus.cleanarchitucture.lectures.repository.LectureHistoryRepository;
import org.hhplus.cleanarchitucture.lectures.tool.StudentStatus;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class LectureHistoryRepositoryImpl implements LectureHistoryRepository {

    private final LectureHistoryJpaRepository lectureHistoryJpaRepository;

    // 특강 신청 목록 조회
    public LectureHistoryDomain selectByParams(Long userId){
        LectureHistoryEntity lectureHistoryEntity =
        lectureHistoryJpaRepository.findById(userId).orElse(null);
        return Objects.isNull(lectureHistoryEntity) ? null : lectureHistoryEntity.toDomain();

    }

    // 특강 신청 저장
    public LectureHistoryDomain save(Long userId, Long lectureId, StudentStatus studentStatus){
        LectureHistoryEntity lectureHistoryEntity
                = lectureHistoryJpaRepository.save(
                LectureHistoryEntity.builder().userId(userId).lectureId(lectureId).studentStatus(studentStatus).build());
        return lectureHistoryEntity.toDomain();

    }
}
