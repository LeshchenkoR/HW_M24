
import comparators.StudentComparator;
import comparators.UniversityComparator;
import enums.StudentCompareEnum;
import enums.UniversityCompareEnum;
import io.JsonWriter;
import io.XlsReader;
import io.XlsWriter;
import io.XmlWriter;
import model.Statistics;
import model.Student;
import model.University;
import model.XmlStructure;
import utils.CollectStatistics;
import utils.Java2Xml;
import utils.JsonUtil;
import utils.SelectComparator;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static utils.CreateFileUtil.createNewFile;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {

        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: : " + e.toString());
        }

        logger.info("Application started, Logger configured");

        XlsReader rd = XlsReader.getInstance();
        URI linkToFile = rd.readFileFromResources("universityInfo.xlsx");
        File file = new File(linkToFile);
        List<Student> students = rd.readStudentsDataFromFile(file);
        List<University> universities = rd.readUniversityDataFromFile(file);

        StudentComparator studentComparator = SelectComparator.
                getInstance().getStudentComparator(StudentCompareEnum.COURSE);
        students.sort(studentComparator);

        UniversityComparator universityComparator = SelectComparator.
                getInstance().getUniversityComparator(UniversityCompareEnum.UNIVERSITY_PROFILE);
        universities.sort(universityComparator);

        List<Statistics> statisticsList = CollectStatistics.processing(students, universities);
        XlsWriter.createFileXls(statisticsList, "statistics.xlsx");


        XmlStructure xmlStructure = new XmlStructure()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        //Метод из авторского кода для сравнения
        // XmlWriter.generateXmlReq(xmlStructure);

        File xmlFile = createNewFile("xmlReqs", "_Req.xml");
        Java2Xml.marshallingObject(xmlFile, xmlStructure);

        //     JsonWriter.writeJsonReq(xmlStructure);

        logger.info("Application finished");
    }
}
