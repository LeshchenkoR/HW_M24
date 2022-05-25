public class Main {
    public static void main(String[] args) {
        Student student1 = new Student
                .StudentBuilder("Петров Николай", "111")
                .setCurrentCourseNumber(1)
                .setAvgExamScore(4.5F)
                .build();
        University university1 = new University
                .UniversityBuilder("111", "Высшая школа экономики",
                "ВШЭ", 2022, University.StudyProfile.ECONOMY)
                .build();
        System.out.println(student1);
        System.out.println(university1);
    }
}