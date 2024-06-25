package org.hhplus.cleanarchitucture.lectures.service.impl;

import lombok.RequiredArgsConstructor;
import org.hhplus.cleanarchitucture.lectures.model.domain.LectureApplicationDomain;
import org.hhplus.cleanarchitucture.lectures.model.dto.LectureDto;
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

    @Override
    @Transactional
    public LectureDto apply(Long userId, Long lectureId){
        log.info("specialLectureApp-service");
            LectureApplicationDomain lectureApplicationDomain
                    = lectureApplicationRepository.save(userId, lectureId);
            return lectureApplicationDomain.toDTO(); // Domain > DTO

    }
    public boolean check(Long userId) {
        LectureApplicationDomain lectureApplicationDomain
                = lectureApplicationRepository.selectByUserId(userId);
        if (lectureApplicationDomain==null) {
            return false;
        }else{
            return true;
        }

    }


}
