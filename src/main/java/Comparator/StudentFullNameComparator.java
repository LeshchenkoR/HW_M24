package Comparator;

import Model.Student;
import org.apache.commons.lang3.StringUtils;

public class StudentFullNameComparator implements StudentComparator {
    @Override
    public int compare(Student st1, Student st2) {
        return StringUtils.compare(st1.getFullName(), st2.getFullName());
    }
}
