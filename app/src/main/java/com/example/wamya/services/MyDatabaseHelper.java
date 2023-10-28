package com.example.wamya.services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mydatabase.db";
    public static final int DATABASE_VERSION = 1;

    // Table and column names
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_IS_BLOCKED = "is_blocked";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_ROLE = "role";

    // Constructor
    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the users table
        String createUserTable = "CREATE TABLE " + TABLE_USERS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_USERNAME + " TEXT," +
                COLUMN_PASSWORD + " TEXT," +
                COLUMN_EMAIL + " TEXT," +
                COLUMN_IS_BLOCKED + " INTEGER," +
                COLUMN_ADDRESS + " TEXT," +
                COLUMN_PHONE_NUMBER + " TEXT," +
                COLUMN_ROLE + " TEXT" +
                ");";
        db.execSQL(createUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle upgrades here
        // Example: db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS + ";");
        // onCreate(db);
    }
}

