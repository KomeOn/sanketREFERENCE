package com.example.dell.mysqlproject.db;

/**
 * Created by dell on 7/14/2017.
 */

public interface TableTask {
    String TABLE_NAME="tasks";
    String COLUMN_ID="id";
    String COLUMN_TASK="task";
    String COLUMN_IS_DONE="isdone";
    String CREATE=" CREATE TABLE ";
    String COMMA=" , ";
    String LBR=" ( ";
    String RBR=" ) ";
    String TERMINATE=" ; ";
    String INT_PK_AUTOIC=" INTEGER PRIMARY KEY AUTOINCREMENT ";
    String TYPE_INTEGER=" INTEGER ";
    String TYPE_REAL=" REAL ";
    String TYPE_TEXT=" TEXT ";
    String SELECT_ALL=" SELECT * ";
    String FROM=" FROM ";
    String WHEN_UPGRADING_FROM_1_2=null;
}
