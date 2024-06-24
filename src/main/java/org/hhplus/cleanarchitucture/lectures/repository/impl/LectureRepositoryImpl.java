package org.hhplus.cleanarchitucture.lectures.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hhplus.cleanarchitucture.lectures.model.domain.LectureDomain;
//import org.hhplus.cleanarchitucture.lectures.model.entity.LectureEntity;
import org.hhplus.cleanarchitucture.lectures.repository.LectureJpaRepository;
import org.hhplus.cleanarchitucture.lectures.repository.LetureRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LectureRepositoryImpl implements LetureRepository {
    //private final LectureJpaRepository lectureJpaRepository;

    public void selectByUserId(Long userId){

    }

    @Override
    public void save(Long userId){
        //LectureEntity lectureEntity = new LectureEntity();
       // return lectureEntity.toDomain();


    }
}
