package com.vinaylogics.springdata.jdbc.annotations.utils;

public interface QueryConstant {

    interface EmployeeTable {
        String TABLE_NAME = "employees";

        String C_ID = "id";
        String C_NAME = "name";
        String C_SALARY = "salary";

        String Q_FIND_ALL = "SELECT * FROM " + TABLE_NAME + ";";
        String Q_SAVE = "INSERT INTO EMPLOYEES ("+C_NAME+", "+C_SALARY+") VALUES (?,?)";
        String Q_UPDATE = "UPDATE EMPLOYEES  SET "+C_SALARY+" = ? WHERE " + C_ID + "=? ;";
    }
}
