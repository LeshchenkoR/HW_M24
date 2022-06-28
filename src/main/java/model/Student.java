package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Student implements Serializable {

    @SerializedName("ID")
    private final String universityId;
    @SerializedName("Имя")
    private final String fullName;
    @SerializedName("Курс")
    private final int currentCourseNumber;
    @SerializedName("Ср.балл")
    private final float avgExamScore;

    //builder
    Student(StudentBuilder studentBuilder) {
        universityId = studentBuilder.universityId;
        fullName = studentBuilder.fullName;
        currentCourseNumber = studentBuilder.currentCourseNumber;
        avgExamScore = studentBuilder.avgExamScore;
    }

    //getters
    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    @Override
    public String toString() {
        String specifiers = "%-20s %-15s %-4d %-5.2f";
        return String.format(specifiers, fullName, universityId, currentCourseNumber, avgExamScore);
    }

    //Model.Student Builder
    public static class StudentBuilder {
        private final String universityId;
        private final String fullName;
        private int currentCourseNumber;
        private float avgExamScore;

        public StudentBuilder(String universityId, String fullName) {
            this.universityId = universityId;
            this.fullName = fullName;
        }

        //SETTERS
        public StudentBuilder setCurrentCourseNumber(int currentCourseNumber) {
            this.currentCourseNumber = currentCourseNumber;
            return this;
        }

        public StudentBuilder setAvgExamScore(float avgExamScore) {
            this.avgExamScore = avgExamScore;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
