package enums;

//ENUM
public enum StudyProfile {
    MEDICINE("Медицина"), ECONOMY("Экономика"),
    MANAGEMENT("Управление"), MATHEMATICS("Математика"),
    PHYSICS("Физика"), LINGUISTICS("Лингвистика"),
    ;

    private final String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}
