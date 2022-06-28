import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentCompareEnum;
import enums.UniversityCompareEnum;
import io.ReadData;
import io.XlsWriter;
import model.Statistics;
import model.Student;
import model.University;
import utils.Checking;
import utils.CollectStatistics;
import utils.JsonUtil;
import utils.SelectComparator;

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
                getInstance().getStudentComparator(StudentCompareEnum.COURSE);
        students.sort(studentComparator);

//        System.out.println("serialized student object--------------------");
//        System.out.println(JsonUtil.serializeStudentObject(students.get(1)));

        System.out.println("serialized student list------------------------");
        String studentsJson = JsonUtil.serializeStudentList(students);
        System.out.println(studentsJson);

        System.out.println("deserialized student list----------------------");
        List<Student> studentsFromJson = JsonUtil.deserializeStudentList(studentsJson);
        studentsFromJson.forEach(System.out::println);

        Checking.checkSize(students, studentsFromJson);

        students.forEach(student -> {
            String studentJson = JsonUtil.serializeStudentObject(student);
            System.out.println("сериализация в stream ----------------------- \n" + studentJson);
            Student studentFromJson = JsonUtil.deserializeStudentObject(studentJson);
            System.out.println("десериализация в stream \n" + studentFromJson + "\n");
        });

        UniversityComparator universityComparator = SelectComparator.
                getInstance().getUniversityComparator(UniversityCompareEnum.UNIVERSITY_PROFILE);
        universities.sort(universityComparator);

//        System.out.println("serialized university object------------------");
//        System.out.println(JsonUtil.serializeUniversityObject(universities.get(0)));

        System.out.println("serialized university list------------------------");
        String universitiesJson = JsonUtil.serializeUniversityList(universities);
        System.out.println(universitiesJson);

        System.out.println("deserialized university list----------------------");
        List<University> universityFromJson = JsonUtil.deserializeUniversityList(universitiesJson);
        universityFromJson.forEach(System.out::println);

        Checking.checkSize(universities, universityFromJson);

        List<Statistics> statisticsList = CollectStatistics.processing(students, universities);
        XlsWriter.createFileXls(statisticsList, "statistics.xlsx");
    }
}