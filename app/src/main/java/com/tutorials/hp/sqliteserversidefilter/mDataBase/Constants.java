package com.tutorials.hp.sqliteserversidefilter.mDataBase;

/**
 * Created by Oclemmy on 5/2/2016 for ProgrammingWizards Channel and http://www.Camposha.com.
 */
public class Constants {
    //columns
    static final String ROW_ID="id";
    static final String NAME="name";

    //DB
    static final String DB_NAME="gg_DB";
    static final String TB_NAME="gg_TB";
    static final int DB_VERSION=1;

    //CREATE STMT
    static final String CREATE_TB="CREATE TABLE gg_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name TEXT NOT NULL);";

    //DROP  TB STMT
     static final String DROP_TB="DRP TABLE IF EXISTS "+TB_NAME;





}
