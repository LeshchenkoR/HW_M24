package io;

import model.XmlStructure;
import utils.JsonUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class JsonWriter {

    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    private JsonWriter() {
    }

    public static void writeJsonReq(XmlStructure xmlStructure) {

        logger.info("JSON writing started");

        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            logger.info("Directory created successfully");
        } catch (IOException ioEx) {
            logger.fine("Directory already created");
        }


        writeStudents(xmlStructure);
        writeUniversities(xmlStructure);
        writeStatisticsList(xmlStructure);

        logger.info("JSON writing finished successfully");
    }

    private static void writeStudents(XmlStructure xmlStructure) {
        String studentsJson = JsonUtil.writeListToJson(xmlStructure.getStudentList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/students" + xmlStructure.getProcessDate().getTime() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.severe("Students JSON writing failed");
        }
    }

    private static void writeUniversities(XmlStructure xmlStructure) {
        String universitiesJson = JsonUtil.writeListToJson(xmlStructure.getUniversityList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/universities" + xmlStructure.getProcessDate().getTime() + ".json");
            outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.severe("Universities JSON writing failed");
        }
    }

    private static void writeStatisticsList(XmlStructure xmlStructure) {
        String studentsJson = JsonUtil.writeListToJson(xmlStructure.getStatisticsList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/statistics" + xmlStructure.getProcessDate().getTime() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.severe("Statistics JSON writing failed");
        }
    }
}
