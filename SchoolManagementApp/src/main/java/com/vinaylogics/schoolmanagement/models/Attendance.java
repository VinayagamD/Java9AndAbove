package com.vinaylogics.schoolmanagement.models;

import com.vinaylogics.schoolmanagement.utils.SchoolUtils;

import java.time.LocalDateTime;
import java.util.Objects;

public class Attendance extends BaseModel{
    private LocalDateTime attendanceTime = LocalDateTime.now();
    private String subject;
    private String teacher;
    private String student;
    private boolean present;

    public LocalDateTime getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(LocalDateTime attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Attendance that = (Attendance) o;
        return present == that.present &&
                Objects.equals(attendanceTime, that.attendanceTime) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(teacher, that.teacher) &&
                Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attendanceTime, subject, teacher, student, present);
    }

    public static Attendance fromJson(String json){
        return SchoolUtils.getGson().fromJson(json, Attendance.class);
    }

    @Override
    public String toString() {
        return "Attendance{" +
                super.toString() +
                "attendanceTime=" + attendanceTime +
                ", subject='" + subject + '\'' +
                ", teacher='" + teacher + '\'' +
                ", student='" + student + '\'' +
                ", present=" + present +
                '}';
    }
}
