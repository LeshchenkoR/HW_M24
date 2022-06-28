package model;

import enums.StudyProfile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {

    private StudyProfile profile;
    private float avgExamScore;
    private int countStudents;
    private int countUniversity;
    private String universityName;

}
