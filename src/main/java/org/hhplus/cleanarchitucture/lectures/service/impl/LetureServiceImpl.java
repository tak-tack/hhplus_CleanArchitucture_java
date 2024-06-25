package org.hhplus.cleanarchitucture.lectures.service.impl;

import lombok.RequiredArgsConstructor;
import org.hhplus.cleanarchitucture.lectures.model.domain.LectureDomain;
import org.hhplus.cleanarchitucture.lectures.repository.LetureRepository;
import org.hhplus.cleanarchitucture.lectures.service.LectureService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LetureServiceImpl implements LectureService {

    private final LetureRepository lectureRepository;

    public LectureDomain apply(long userId){ // LIST dto 처리하기

        LectureDomain lectureDomain = new LectureDomain();
        lectureRepository.save(userId);
        return lectureDomain;
    }
    public  boolean check(Long userId) { // dto 처리
        return true;

    }


}
