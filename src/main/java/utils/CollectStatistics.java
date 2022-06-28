package utils;

import enums.StudyProfile;
import model.Statistics;
import model.Student;
import model.University;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectStatistics {
    private CollectStatistics() {
    }

    public static List<Statistics> processing(List<Student> students, List<University> universities) {

        List<Statistics> statistics = new ArrayList<>();

        Stream.of(StudyProfile.values()).forEach(profile -> {
            List<String> profileUniversityId = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());

            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityId.contains(student.getUniversityId()))
                    .collect(Collectors.toList());

            Statistics data = new Statistics();
            statistics.add(data);
            data.setProfile(profile);

            data.setCountUniversity(profileUniversityId.size());
            data.setUniversityName(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> profileUniversityId.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> data.setUniversityName(
                            data.getUniversityName() + fullNameUniversity + ";"));
            data.setCountStudents(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
           // data.setAvgExamScore(0);
            avgExamScore.ifPresent(value -> data.setAvgExamScore(
                    (float) BigDecimal.valueOf(value).setScale(1, RoundingMode.HALF_UP).doubleValue()));
            // странная работа setScale: при 0 - округляет все значения, при 2 и больше - не округляет,
            // при 1 - самый интересный случай
        });
        return statistics;
    }
}