package DataReader;

import Model.Student;
import Model.University;
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

public class ReadData {
    private ReadData() {
    }

    private static final class InstanceHolder {
        private static final ReadData HOLDER_INSTANCE = new ReadData();
    }

    public static ReadData getInstance() {
        return InstanceHolder.HOLDER_INSTANCE;
    }

    //Доступ к файлу в папке resources  ------------------------------------------
    public URI readFileFromResources(String filename) throws Exception {
        return getClass().getResource(String.format("/%s", filename)).toURI();
    } // end of readTextResource -------------------------------------------------

    // метод для вывода заголовка таблицы на листе. Перспективная разработка------
    public static void PrintHeader(File file) throws IOException {
    }// end of PrintHeader  ------------------------------------------------------

    // метод для чтения студентов -----------------------------------------------------------
    public List<Student> readStudentsDataFromFile(File file) throws IOException {
        List<Student> students = new ArrayList<>();

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
        return students;
    } // end of readStudentsDataFromFile ---------------------------------------------------------

    // метод для чтения университетов -----------------------------------------------------------
    public List<University> readUniversityDataFromFile(File file) throws IOException {
        List<University> universities = new ArrayList<>();

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
                    University.StudyProfile.valueOf(University.StudyProfile.class,
                            currentRow.getCell(4).getStringCellValue()));
            universities.add(university.build());
        }
        return universities;
    } // end of readUniversityDataFromFile -------------------------------------------------------
}
