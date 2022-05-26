public class Student {

    String fullName;
    String universityId;
    int currentCourseNumber;
    float avgExamScore;

    //builder
    private Student(StudentBuilder studentBuilder) {
        fullName = studentBuilder.fullName;
        universityId = studentBuilder.universityId;
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
        return "Студент: " + fullName +
                ", идентификатор ВУЗа= " + universityId +
                ", курс= " + currentCourseNumber +
                ", средний балл= " + avgExamScore;
    }

    //Student Builder
    public static class StudentBuilder {
        private final String fullName;
        private final String universityId;
        private int currentCourseNumber;
        private float avgExamScore;

        public StudentBuilder(String fullName, String universityId) {
            this.fullName = fullName;
            this.universityId = universityId;
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
