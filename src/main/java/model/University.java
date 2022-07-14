package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class University {

    @SerializedName("ID")
    @XmlElement(name = "universityId")
    String id;

    @SerializedName("Название")
    @XmlElement(name = "universityName")
    String fullName;

    @SerializedName("Аббревиатура")
    @XmlTransient
    String shortName;

    @SerializedName("год")
    @XmlTransient
    int yearOfFoundation;

    @SerializedName("Профиль")
    @XmlElement(name = "mainProfile")
    StudyProfile mainProfile;


    //BUILDER
    private University(UniversityBuilder universityBuilder) {
        id = universityBuilder.id;
        fullName = universityBuilder.fullName;
        shortName = universityBuilder.shortName;
        yearOfFoundation = universityBuilder.yearOfFoundation;
        mainProfile = universityBuilder.mainProfile;
    }

    //GETTERS
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        String specifiers = "%-10s %-55s %-10s %-10d %-10s";
        return String.format(specifiers, id, fullName, shortName, yearOfFoundation, mainProfile);
    }

    //Build Model.University
    public static class UniversityBuilder {
        private final String id;
        private final String fullName;
        private final String shortName;
        private final int yearOfFoundation;
        private final StudyProfile mainProfile;

        public UniversityBuilder(String id, String fullName, String shortName,
                                 int yearOfFoundation, StudyProfile mainProfile) {
            this.id = id;
            this.fullName = fullName;
            this.shortName = shortName;
            this.yearOfFoundation = yearOfFoundation;
            this.mainProfile = mainProfile;
        }

        public University build() {
            return new University(this);
        }
    }
}
