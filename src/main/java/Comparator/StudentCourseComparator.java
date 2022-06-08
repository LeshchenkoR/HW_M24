package Comparator;

import Model.Student;

public class StudentCourseComparator implements StudentComparator {
    @Override
    public int compare(Student st1, Student st2) {
        return Integer.compare(st1.getCurrentCourseNumber(),st2.getCurrentCourseNumber());
    }
}
