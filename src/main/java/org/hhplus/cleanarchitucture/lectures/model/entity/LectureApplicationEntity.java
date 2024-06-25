package org.hhplus.cleanarchitucture.lectures.model.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.hhplus.cleanarchitucture.lectures.model.domain.LectureApplicationDomain;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder // 몰까
@Entity // DB의 테이블을 뜻함. Spring Data JPA에서는 반드시 @Entity 을 추가해야함
@EntityListeners(AuditingEntityListener.class)
@Table(name="lectureApplication")
//@EntityListener(value = AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
public class LectureApplicationEntity {
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 증가 시퀀스 == AUTOINCREMENT
    Long studentId; // null 미허용 , auto increment 처리
    Long UserId; // 고유번호
    Long lectureId;
    // JPA 저장소가 save()할 때 자동으로 생성시간을 생성. 데이터포맷 수정 예정
    @CreatedDate @Column(updatable = false) private LocalDateTime createdDate;


    public LectureApplicationDomain toDomain(){
        LectureApplicationDomain lectureApplicationDomain = new LectureApplicationDomain();
        BeanUtils.copyProperties(this,lectureApplicationDomain);
        return lectureApplicationDomain;
    }
}


