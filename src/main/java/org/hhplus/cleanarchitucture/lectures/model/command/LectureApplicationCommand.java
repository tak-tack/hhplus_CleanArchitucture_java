package org.hhplus.cleanarchitucture.lectures.model.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.Assert;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LectureApplicationCommand {
    //
    private Long lectureId;
    private Long userId;

//    public void validate() {
//        Assert.hash hasText(this.lectureId, "Lecture ID is required");
//        Assert.hasText(this.userId, "User ID is required");
//    }
}