package io;

import model.Statistics;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {
    private XlsWriter() {
    }

    public static void createFileXls(List<Statistics> statisticsList, String filePath) throws IOException {
        XSSFWorkbook statisticBook = new XSSFWorkbook();
        XSSFSheet sheet = statisticBook.createSheet("Statistics");
        XSSFFont font = statisticBook.createFont();
        font.setBold(true);
        font.setColor(Font.COLOR_RED);
        font.setFontHeight(14);
        XSSFCellStyle style = statisticBook.createCellStyle();
        style.setFont(font);

        int rowNum = 0;
        Row row = sheet.createRow(rowNum++);

        //заполняем заголовки столбцов
        row.createCell(0).setCellValue("Профиль");
        row.createCell(1).setCellValue("Средний балл");
        row.createCell(2).setCellValue("Количество студентов");
        row.createCell(3).setCellValue("Количество университетов");
        row.createCell(4).setCellValue("Название университета");
        //применяем стиль первой строки
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            row.getCell(i).setCellStyle(style);
            sheet.autoSizeColumn(i);
        }

        // заполняем таблицу данными из statisticsList
        for (Statistics data : statisticsList) {
            ++rowNum;
            Row nextRow = sheet.createRow(rowNum);
            nextRow.createCell(0).setCellValue(data.getProfile().getProfileName());
            //   StudyProfile.valueOf(StudyProfile.class, row.createCell(0).getStringCellValue());
            nextRow.createCell(1).setCellValue(data.getAvgExamScore());
            nextRow.createCell(2).setCellValue(data.getCountStudents());
            nextRow.createCell(3).setCellValue(data.getCountUniversity());
            nextRow.createCell(4).setCellValue(data.getUniversityName());
        }
        //запись в файл
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            statisticBook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл статистики создан");
    }
}
