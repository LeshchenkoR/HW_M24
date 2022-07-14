package model;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)

public class XmlStructure {

    @XmlElementWrapper(name = "studentInfo")
    @XmlElement(name = "studentEntry")
    private List<Student> studentList;

    @XmlElementWrapper(name = "universityInfo")
    @XmlElement(name = "universityEntry")
    private List<University> universityList;

    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    private List<Statistics> statisticsList;

    @XmlElement(name = "processedAt")
    private Date processDate;

    public XmlStructure() {
    }

    public XmlStructure setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        return this;
    }

    public XmlStructure setUniversityList(List<University> universityList) {
        this.universityList = universityList;
        return this;
    }

    public XmlStructure setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
        return this;
    }

    public XmlStructure setProcessDate(Date processDate) {
        this.processDate = processDate;
        return this;
    }
}
