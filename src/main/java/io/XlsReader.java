package io;

import enums.StudyProfile;
import model.Student;
import model.University;
import org.apache.logging.log4j.LogManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XlsReader {
    private XlsReader() {
    }

    private static final Logger logger = Logger.getLogger(XlsReader.class.getName());

    private static final class InstanceHolder {
        private static final XlsReader HOLDER_INSTANCE = new XlsReader();
    }

    public static XlsReader getInstance() {
        return InstanceHolder.HOLDER_INSTANCE;
    }

    //Доступ к файлу в папке resources  ------------------------------------------
    public URI readFileFromResources(String filename) throws Exception {
        return getClass().getResource(String.format("/%s", filename)).toURI();
    } // end of readTextResource -------------------------------------------------

    // метод для чтения студентов -----------------------------------------------------------
    public List<Student> readStudentsDataFromFile(File file) {
        List<Student> students = new ArrayList<>();

        try {
            logger.info("Excel reading started");
            XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet myExcelSheet = myExcelBook.getSheet("Студенты");

            Iterator<Row> rowIterator = myExcelSheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row currentRow = rowIterator.next();
                Student.StudentBuilder student = new Student.StudentBuilder(
                        currentRow.getCell(0).getStringCellValue(),
                        currentRow.getCell(1).getStringCellValue());
                student.setCurrentCourseNumber((int) currentRow.getCell(2).getNumericCellValue());
                student.setAvgExamScore((float) currentRow.getCell(3).getNumericCellValue());
                students.add(student.build());
            }
        } catch (IOException e) {
            logger.severe("Excel reading failed");
            return students;
        }
        logger.info("Excel reading finished successfully");
        return students;
    } // end of readStudentsDataFromFile ---------------------------------------------------------

    // метод для чтения университетов -----------------------------------------------------------
    public List<University> readUniversityDataFromFile(File file) throws IOException {
        List<University> universities = new ArrayList<>();

        try {
            logger.info("Excel reading started");
            XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet myExcelSheet = myExcelBook.getSheet("Университеты");

            Iterator<Row> rowIterator = myExcelSheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row currentRow = rowIterator.next();
                University.UniversityBuilder university = new University.UniversityBuilder(
                        currentRow.getCell(0).getStringCellValue(),
                        currentRow.getCell(1).getStringCellValue(),
                        currentRow.getCell(2).getStringCellValue(),
                        (int) currentRow.getCell(3).getNumericCellValue(),
                        StudyProfile.valueOf(StudyProfile.class,
                                currentRow.getCell(4).getStringCellValue()));
                universities.add(university.build());
            }
        } catch (IOException e) {
            logger.severe("Excel reading failed");
            return universities;
        }
        logger.info("Excel reading finished successfully");
        return universities;
    } // end of readUniversityDataFromFile -------------------------------------------------------
}
