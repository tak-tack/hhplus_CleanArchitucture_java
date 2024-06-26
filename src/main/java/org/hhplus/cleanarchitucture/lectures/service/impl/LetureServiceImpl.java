package org.hhplus.cleanarchitucture.lectures.service.impl;

import lombok.RequiredArgsConstructor;
import org.hhplus.cleanarchitucture.lectures.model.domain.LectureApplicationDomain;
import org.hhplus.cleanarchitucture.lectures.model.dto.LectureDto;
import org.hhplus.cleanarchitucture.lectures.repository.LectureApplicationJpaRepository;
import org.hhplus.cleanarchitucture.lectures.repository.LectureApplicationRepository;
import org.hhplus.cleanarchitucture.lectures.service.LectureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LetureServiceImpl implements LectureService {
    private static final Logger log = LoggerFactory.getLogger(LetureServiceImpl.class);
    private final LectureApplicationRepository lectureApplicationRepository;
    private final LectureApplicationJpaRepository lectureApplicationJpaRepository;

    @Override
    @Transactional
    public LectureDto apply(Long userId, Long lectureId) {
        log.info("specialLectureApp-service start");
        Long currentStudentCount =
                lectureApplicationJpaRepository.findSumStudentId(lectureId).orElseThrow(NullPointerException::new); // 예외발생// 선착순
        if (currentStudentCount > 30L) {
            log.info("specialLectureApp-service currentStudentcount over :  " + currentStudentCount);
            throw new RuntimeException();
        }
        log.info("specialLectureApp-service currentStudentcount now :  " + currentStudentCount);

        LectureApplicationDomain lectureApplicationDomain
                = lectureApplicationRepository.save(userId, lectureId);
        log.info("specialLectureApp-service end ");
        return lectureApplicationDomain.toDTO(); // Domain > DTO
    }

    @Override
    @Transactional
    public boolean check(Long userId) { // boolean타입 dto로 바꾸기,
        LectureApplicationDomain lectureApplicationDomain
                = lectureApplicationRepository.selectByUserId(userId);
        if (lectureApplicationDomain == null) {
            return false;
        } else {
            return true;
        }

    }
}

