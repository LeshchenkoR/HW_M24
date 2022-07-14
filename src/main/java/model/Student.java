package model;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.*;

import java.io.Serializable;

@XmlRootElement(name = "studentEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @SerializedName("ID")
    @XmlElement(name = "universityID")
    private String universityId;

    @SerializedName("Имя")
    @XmlElement(name = "studentName")
    private  String fullName;

    @SerializedName("Курс")
    @XmlTransient
    private int currentCourseNumber;

    @SerializedName("Ср.балл")
    @XmlElement(name = "avgScore")
    private  float avgExamScore;

    public Student(){}

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
