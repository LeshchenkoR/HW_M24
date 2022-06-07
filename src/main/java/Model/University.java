package Model;

public class University {

    String id;
    String fullName;
    String shortName;
    int yearOfFoundation;
    StudyProfile mainProfile;

    //ENUM
    public enum StudyProfile {
        MEDICINE("Медицина"), ECONOMY("Экономика"),
        MANAGEMENT("Управление"), MATHEMATICS("Математика"),
        PHYSICS("Физика"), LINGUISTICS("Лингвистика"),
        ;

        private final String profileName;

        StudyProfile(String profileName) {
            this.profileName = profileName;
        }

        public String getProfileName() {
            return this.profileName;
        }
    }

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

//    public University setMainProfile(StudyProfile mainProfile) {
//        this.mainProfile = mainProfile;
//        return this;
//    }

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
