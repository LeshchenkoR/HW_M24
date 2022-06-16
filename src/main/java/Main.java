import DataReader.ReadData;
import Model.Student;
import Model.University;
import Utils.Checking;
import Utils.JsonUtil;

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

//        System.out.println("serialized student object--------------------");
//        System.out.println(JsonUtil.serializeStudentObject(students.get(1)));

        System.out.println("serialized student list------------------------");
        String ssl = JsonUtil.serializeStudentList(students);
        System.out.println(ssl);

        System.out.println("deserialized student list----------------------");
        List<Student> newStudentList = JsonUtil.deserializeStudentList(ssl);
        newStudentList.forEach(System.out::println);

        Checking.checkSize(students, newStudentList);

        students.forEach(student -> {
            String studentJson = JsonUtil.serializeStudentObject(student);
            System.out.println("сериализация в stream ----------------------- \n" + studentJson);
            Student studentFromJson = JsonUtil.deserializeStudentObject(studentJson);
            System.out.println("десериализация в stream \n" + studentFromJson + "\n");
        });

//        System.out.println("university object-----------------------------");
//        System.out.println(JsonUtil.serializeUniversityObject(universities.get(0)));
//        System.out.println("university list--------------------------------");
//        System.out.println(JsonUtil.serializeUniversityList(universities));

//        StudentComparator studentComparator = SelectComparator.
//                getInstance().getStudentComparator(StudentCompareEnum.FULL_NAME);
//
//        UniversityComparator universityComparator = SelectComparator.
//                getInstance().getUniversityComparator(UniversityCompareEnum.UNIVERSITY_PROFILE);
//
//        students.stream().sorted(studentComparator).forEach(System.out::println);
//        universities.stream().sorted(universityComparator).forEach(System.out::println);
    }
}