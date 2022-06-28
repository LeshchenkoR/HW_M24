package enums;

public enum StudentCompareEnum {
    FULL_NAME("Имя"),
    COURSE("Курс"),
    UNIVERSITY_ID("id университета"),
    AVG_EXAM_SCORE("Ср. балл");

    private final String parameter;

    StudentCompareEnum(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return this.parameter;
    }
}
