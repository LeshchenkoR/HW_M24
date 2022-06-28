package comparator;

import model.Student;

public class StudentAvgExamScoreComparator implements StudentComparator {
    @Override
    public int compare(Student st1, Student st2) {
        return Float.compare(st1.getAvgExamScore(),st2.getAvgExamScore());
    }
}
