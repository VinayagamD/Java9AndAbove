package com.vinaylogics.springboot.springmvccore.utils;

public interface QueryConstant {

    interface BaseTable {
        String COL_ID = "id";
        String COL_CREATED_AT = "created_at";
        String COL_UPDATED_AT = "updated_at";
    }

    interface MessageTable extends BaseTable{
        String TBL_NAME = "message";

        String COL_NAME = "name";
        String COL_MESSAGE = "message";
        String COL_MESSAGE_TIME = "message_time";

        String Q_FIND_ALL = "SELECT * FROM " + TBL_NAME+";";
        String Q_FIND_BY_ID = "SELECT * FROM " + TBL_NAME +" WHERE " + COL_ID + "=?";
        String QN_FIND_BY_ID = "SELECT * FROM " + TBL_NAME +" WHERE " + COL_ID + "=:id";
        String Q_SAVE = "INSERT INTO " + TBL_NAME + "(" + COL_NAME +","+ COL_MESSAGE +") VALUES (?,?);";
        String QN_SAVE = "INSERT INTO " + TBL_NAME + "(" + COL_NAME +","+ COL_MESSAGE +") VALUES (:name,:message);";
    }
}
