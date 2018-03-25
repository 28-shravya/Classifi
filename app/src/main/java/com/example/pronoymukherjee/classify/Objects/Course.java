package com.example.pronoymukherjee.classify.Objects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is an object for subject details.
 */

public class Course {
    private String code, name, section, teacherID, collegeID;
    private List<Student> students; //students enrolled in this course.
    private Map<Student,Attendance> attendanceMap=new HashMap<>();
    private int semester;
    private Teacher teacher; //teacher who made and teaches the course.


    public Course(String code, String courseName){
        this.code = code;
        this.name = courseName;
        fillAttendanceMap();
    }

    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getSection() {return section;}
    public void setSection(String section) {this.section = section;}
    public String getTeacherID() {return teacherID;}
    public void setTeacherID(String teacherID) {this.teacherID = teacherID;}
    public String getCollegeID() {return collegeID;}
    public void setCollegeID(String collegeID) {this.collegeID = collegeID;}
    public int getSemester() {return semester;}
    public void setSemester(int semester) {this.semester = semester;}
    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    /**
     * This is the method to initialize the map with the students and the attendance.
     */
    private void fillAttendanceMap(){
        for(Student student: students){
            attendanceMap.put(student,new Attendance(student.getEmail(),code,0,0));
        }
    }

    /**
     * This is the method to update the attendance of the student who were present.
     * @param student: The student object who were present.
     */
    public void updateAttendanceMap(Student student){
        for(Map.Entry<Student,Attendance> studentAttendanceEntry: attendanceMap.entrySet()){
            if(studentAttendanceEntry.getKey().getEmail().equals(student.getEmail())){
                studentAttendanceEntry.getValue().incrementAttendance();
            }
        }
    }
}
