package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

public class University {
    @SerializedName("ID")
    String id;
    @SerializedName("Название")
    String fullName;
    @SerializedName("Аббревиатура")
    String shortName;
    @SerializedName("год")
    int yearOfFoundation;
    @SerializedName("Профиль")
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
