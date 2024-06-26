package org.hhplus.cleanarchitucture.lectures.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hhplus.cleanarchitucture.lectures.model.domain.LectureApplicationDomain;
import org.hhplus.cleanarchitucture.lectures.model.entity.LectureApplicationEntity;
import org.hhplus.cleanarchitucture.lectures.repository.LectureApplicationJpaRepository;
import org.hhplus.cleanarchitucture.lectures.repository.LectureApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LectureApplicationRepositoryImpl implements LectureApplicationRepository {
    private static final Logger log = LoggerFactory.getLogger(LectureApplicationRepositoryImpl.class);
    private final LectureApplicationJpaRepository lectureApplicationJpaRepository;

    public LectureApplicationDomain selectByUserId(Long userId){
        log.info("specialLectureApp-Repo selectByUserId START");
        // 히스토리로 나누기. 지금 한테이블에 물려있음
       LectureApplicationEntity lectureApplicationEntity = lectureApplicationJpaRepository.findById(userId).orElse(null); // LectureApplicationEntity가 optional 객체라서 isPresent()사용가능..
        log.info("specialLectureApp-Repo selectByUserId END :");
        return Objects.isNull(lectureApplicationEntity) ? null : lectureApplicationEntity.toDomain();
    }
    @Override
    public LectureApplicationDomain save(Long userId, Long lectureId){
        log.info("specialLectureApp-Repo save START");
        if (lectureApplicationJpaRepository.findById(userId).isPresent()) // 성공했던 유저아이디로 특강 신청 불가
        {
            throw new RuntimeException();
        }
        else {
            LectureApplicationEntity lectureApplicationEntity =
                    lectureApplicationJpaRepository.save(
                            LectureApplicationEntity.builder().
                                    UserId(userId).
                                    lectureId(lectureId).
                                    build());
            log.info("specialLectureApp-Repo save  END");
            return lectureApplicationEntity.toDomain(); // Entity > Domain
        }

    }
}
