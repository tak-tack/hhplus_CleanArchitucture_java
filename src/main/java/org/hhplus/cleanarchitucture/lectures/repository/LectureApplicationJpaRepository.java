package org.hhplus.cleanarchitucture.lectures.repository;


import org.hhplus.cleanarchitucture.lectures.model.entity.LectureApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
JPA Repository
Spring Data JPA는 JPA의 구현체인 Hibernate를 이용하기 위한 여러 API를 제공한다
그중에 가장 많이 사용되는 것이 JPA Repository라는 인터페이스
 */


/*
jpaRepository에 상속
- 작성된 LectureJpaRepository 는 JpaRepository를 상속하는 것만으로 모든 작업 끝난다.
- LectureJpaRepository 를 이용해서 작성된 테이블에 SQL문 없이 CRUD 작업을 할 수 있게 된다.
- JpaRepository의 제너릭 타입으로는 <Entity, PK의 타입>을 지정해주면 Spring Data JPA는 자동으로 스프링의 빈(bean)으로
등록된다.
- Spring 이 내부적으로 인터페이스 타입에 맞는 객체를 생성해서 bean으로 등록
 */
public interface LectureJpaRepository extends JpaRepository<LectureApplicationEntity> {
    //public List<LectureEntity>
}
