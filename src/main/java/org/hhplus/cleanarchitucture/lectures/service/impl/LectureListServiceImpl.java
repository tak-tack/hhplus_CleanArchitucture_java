package org.hhplus.cleanarchitucture.lectures.service.impl;

import org.hhplus.cleanarchitucture.lectures.model.dto.LectureListDto;
import org.hhplus.cleanarchitucture.lectures.service.LectureService;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public class LectureServiceImpl extends LectureService {
    @Override
    @Transactional
    public LectureListDto lectureRegister(LocalDate lectureDate){
        return lectureRepository.save(lectureDate).toDTO();

    }
}
