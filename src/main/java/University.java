public class University {

    String id;
    String fullName;
    String shortName;
    int yearOfFoundation;

    StudyProfile mainProfile;

    //ENUM
    public enum StudyProfile {
        MEDICINE("Медицина"), ECONOMY("Экономика"),
        MANAGEMENT("Управление"), BUILDING("Строительство");

        private String profileName;

        StudyProfile(String profileName) {
            this.profileName = profileName;
        }

        public String getProfileName() {
            return profileName;
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

//    public StudyProfile getMainProfile() {
//        return mainProfile;
//    }

    @Override
    public String toString() {
        return "Университет: " + id +", название= " + fullName +
                ", сокращенно= " + shortName +
                ", год образования= " + yearOfFoundation +
                ", направление обучения= " + mainProfile.profileName;
    }

    //Build University
    public static class UniversityBuilder {
        private String id;
        private String fullName;
        private String shortName;
        private int yearOfFoundation;
        private StudyProfile mainProfile;

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
