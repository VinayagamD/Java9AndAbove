package com.vinaylogics.schoolmanagement.utils;

public interface QueryConstants {

    interface BaseColumn {
        String ID = "id";
        String CREATED_AT = "created_at";
        String UPDATED_AT = "updated_at";
    }


    interface AttendanceTable extends BaseColumn {
        String ATTENDANCES = "attendances";



        String ATTENDANCE_TIME = "attendance_time";

        String TEACHER_NAME = "teacher_name";

        String STUDENT_NAME = "student_name";

        String PRESENT = "present";

        String SUBJECT = "subject";

        String INSERT = "INSERT INTO "+ATTENDANCES+"("+ATTENDANCE_TIME+ ","+TEACHER_NAME+
                ","+STUDENT_NAME+" , "+PRESENT+", "+SUBJECT+") VALUES (?,?,?,?,?);";

        String FIND_ALL = "SELECT * FROM " + ATTENDANCES + ";";

        String FIND_BY_ID = "SELECT * FROM " + ATTENDANCES + " WHERE " + ID +"= ? ;";

    }
}
