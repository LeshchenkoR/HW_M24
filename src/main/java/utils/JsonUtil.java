package utils;

import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class JsonUtil implements Serializable {
//    @Serial
//    private static final long serialVersionUID = 1L;

    private JsonUtil() {
    }

    public static String writeListToJson( List<?> list) {
       return new GsonBuilder().setPrettyPrinting().create().toJson(list);

//    public static String serializeStudentObject(Student student) {
//        return objGson.toJson(student);
//    }
//
//    public static String serializeUniversityObject(University university) {
//        return objGson.toJson(university);
//    }
//
//    public static String serializeStudentList(List<Student> list) {
//        return objGson.toJson(list);
//    }
//
//    public static String serializeUniversityList(List<University> list) {
//        return objGson.toJson(list);
//    }
//
//    public static Student deserializeStudentObject(String str) {
//        return objGson.fromJson(str, Student.class);
//    }
//
//    public static List<Student> deserializeStudentList(String str) {
//        Type listType = new TypeToken<List<Student>>() {
//        }.getType();
//        return objGson.fromJson(str, listType);
//    }
//
//    public static University deserializeUniversityObject(String str) {
//        return objGson.fromJson(str, University.class);
//    }
//
//    public static List<University> deserializeUniversityList(String str) {
//        Type listType = new TypeToken<List<University>>() {
//        }.getType();
//        return objGson.fromJson(str, listType);
//    }
    }
}
