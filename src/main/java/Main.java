import Comparator.UniversityComparator;
import Comparator.StudentComparator;
import DataReader.ReadData;
import Enum.StudentCompareEnum;
import Enum.UniversityCompareEnum;
import Model.Student;
import Model.University;
import Utils.SelectComparator;

import java.io.File;
import java.net.URI;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        ReadData rd = ReadData.getInstance();
        URI linkToFile = rd.readFileFromResources("universityInfo.xlsx");
        File file = new File(linkToFile);
        List<Student> students = rd.readStudentsDataFromFile(file);
        List<University> universities = rd.readUniversityDataFromFile(file);

        StudentComparator studentComparator = SelectComparator.
                getInstance().getStudentComparator(StudentCompareEnum.FULL_NAME);

        UniversityComparator universityComparator = SelectComparator.
                getInstance().getUniversityComparator(UniversityCompareEnum.UNIVERSITY_PROFILE);

        students.stream().sorted(studentComparator).forEach(System.out::println);
        universities.stream().sorted(universityComparator).forEach(System.out::println);
    }
}