/*
entity
테이블과 1대1 매핑관계
*/

package org.hhplus.cleanarchitucture.lectures.model.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hhplus.cleanarchitucture.lectures.model.domain.LectureDomain;
import org.springframework.beans.BeanUtils;


@Getter
@Setter
@Entity // DB의 테이블을 뜻함. Spring Data JPA에서는 반드시 @Entity 을 추가해야함
@Table(name="lecture")
@AllArgsConstructor
@NoArgsConstructor
public class LectureEntity{
    //@Colunm 필수는 아니지만 생성할때 create테이블 할 때 옵션이다!
    // 안쓰면 적용
    // 하이버!
    // 하이버 설정했는데 어플리케이션.properties 에 .yml 둘중하나만 정의되어있으면된닫.
    // ddr auto 에 create, update 옵션등 있는데 이게 create 라면 자동으로 생성해준다.
    // createdrop은 create는 기존에 있더라도 새로 생성하다
    // 그냥 create만 있으면 아무것도 안하고 없으면 생성한다
    // update도 잇는데 건님은 update를 선언.
    //테이블에 옵션들을 적용해서 구축하고 어플리케이션을 기동하면 테이블이날라갈수있음
    // 테이블이랑 옵션 = 엔티티랑 옵션 을 권장한다
    // ORM! 은 개념이고 JPA는 ORM을 형상화하기위한 인터페이스.. JAVA에서 사용하도록 JPA를 구현한 구현체가 Hiberhnate
    // hibernate이용하여 JPA를 적용했따! ORM(Object Riew Model) : 테이블을 sql문 직접적으로 작성하는게아니라 오브젝트를 매핑하여
    // 사용할수있도록 좀 더 객체지향적으로 도와주는 하는 개념! jpa사용하는걸보면 엔티티를 정의하고 필드들을 토대로 조건을 조회를 할 수 있도록
    // 컬럼매핑을 기준으로 작동

    // JPA 에 영속성 컨텍스트, 1차캐쉬, 2차캐쉬 << 알아두면좋음
    @Id // PK를 뜻함
            String lectureId; // 고유 번호
    String lectureName; // 특강 이름
    Date lectureOpenTime; // 특강
    Long studentCount; // 특간 신청 인원
    Long StudentLimit; // 특강 신청 인원 제한 30
    Date createDate;

    public LectureEntity(LectureDomain lectureDomain){
        BeanUtils.copyProperties(lectureDomain,this);
    }


    public static LectureEntity empty(Long id){
        return new LectureEntity("1", null,null,null,null,null);
    }

    public LectureDomain toDomain(){
        LectureDomain lectureDomain = new LectureDomain();
        BeanUtils.copyProperties(this, lectureDomain);
        return lectureDomain;
    }



}