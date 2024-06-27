package org.hhplus.cleanarchitucture.lectures.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hhplus.cleanarchitucture.lectures.model.domain.LectureHistoryDomain;
import org.hhplus.cleanarchitucture.lectures.tool.StudentStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder // 몰까
@Entity // DB의 테이블을 뜻함. Spring Data JPA에서는 반드시 @Entity 을 추가해야함
@AllArgsConstructor
@NoArgsConstructor
public class LectureHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long historyId;
    Long userId;
    Long lectureId;
    StudentStatus studentStatus;
    @CreatedDate
    LocalDateTime createAt;


    public LectureHistoryDomain toDomain(){
        LectureHistoryDomain lectureHistoryDomain = new LectureHistoryDomain();
        BeanUtils.copyProperties(this,lectureHistoryDomain);
        return lectureHistoryDomain;
    }

}
