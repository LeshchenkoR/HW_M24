package Utils;

import Comparator.*;
import Enum.StudentCompareEnum;
import Enum.UniversityCompareEnum;

public class SelectComparator {

    private SelectComparator() {
    }

    private static final class InstanceHolder {
        private static final SelectComparator HOLDER_INSTANCE = new SelectComparator();
    }

    public static SelectComparator getInstance() {
        return SelectComparator.InstanceHolder.HOLDER_INSTANCE;
    }

    public  StudentComparator getStudentComparator(StudentCompareEnum myEnum) {

        return switch (myEnum) {
            case FULL_NAME -> new StudentFullNameComparator();
            case COURSE -> new StudentCourseComparator();
            case UNIVERSITY_ID -> new StudentUniversityIdComparator();
            case AVG_EXAM_SCORE -> new StudentAvgExamScoreComparator();
        };
    }

    public  UniversityComparator getUniversityComparator(UniversityCompareEnum myEnum) {

        return switch (myEnum) {
            case FULL_NAME -> new UniversityFullNameComparator();
            case SHORT_NAME -> new UniversityShortNameComparator();
            case UNIVERSITY_ID -> new UniversityIdComparator();
            case YEAR_OF_FOUNDATION -> new UniversityYearOfFoundationComparator();
            case UNIVERSITY_PROFILE -> new UniversityProfileComparator();
        };
    }
}
