package com.smartcoaching.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "mark_configs")
public class MarkConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long courseId;

    @Column(nullable = false)
    private Long subjectId;

    private double attendanceTotal;
    private int bestCtCount;
    private double assignmentTotal;

    @ElementCollection
    private List<String> ctExamNames;

    public MarkConfig() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }
    public Long getSubjectId() { return subjectId; }
    public void setSubjectId(Long subjectId) { this.subjectId = subjectId; }
    public double getAttendanceTotal() { return attendanceTotal; }
    public void setAttendanceTotal(double attendanceTotal) { this.attendanceTotal = attendanceTotal; }
    public int getBestCtCount() { return bestCtCount; }
    public void setBestCtCount(int bestCtCount) { this.bestCtCount = bestCtCount; }
    public double getAssignmentTotal() { return assignmentTotal; }
    public void setAssignmentTotal(double assignmentTotal) { this.assignmentTotal = assignmentTotal; }
    public List<String> getCtExamNames() { return ctExamNames; }
    public void setCtExamNames(List<String> ctExamNames) { this.ctExamNames = ctExamNames; }
}
