package Enum;

public enum UniversityCompareEnum {
    FULL_NAME("Название университета"),
    SHORT_NAME("Аббревиатура"),
    UNIVERSITY_ID("id университета"),
    YEAR_OF_FOUNDATION("Год образования"),
    UNIVERSITY_PROFILE("Профиль обучения");

    private final String parameter;

    UniversityCompareEnum(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return this.parameter;
    }
}
