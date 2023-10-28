package com.example.wamya.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wamya.models.User;

public class MyDatabaseOperations {

    private SQLiteDatabase database;
    private MyDatabaseHelper dbHelper;

    // Constructor
    public MyDatabaseOperations(Context context) {
        dbHelper = new MyDatabaseHelper(context);
    }

    // Open the database
    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    // Close the database
    public void close() {
        dbHelper.close();
    }

    // Insert a user into the database
    public long insertUser(User user) {
        ContentValues values = new ContentValues();
        values.put(MyDatabaseHelper.COLUMN_USERNAME, user.getUsername());
        values.put(MyDatabaseHelper.COLUMN_PASSWORD, user.getPassword());
        values.put(MyDatabaseHelper.COLUMN_EMAIL, user.getEmail());
        values.put(MyDatabaseHelper.COLUMN_IS_BLOCKED, user.isBlocked() ? 1 : 0);
        values.put(MyDatabaseHelper.COLUMN_ADDRESS, user.getAddress());
        values.put(MyDatabaseHelper.COLUMN_PHONE_NUMBER, user.getPhoneNumber());
        values.put(MyDatabaseHelper.COLUMN_ROLE, user.getRole().name());

        return database.insert(MyDatabaseHelper.TABLE_USERS, null, values);
    }

    // Query all users from the database
    public Cursor getAllUsers() {
        return database.query(MyDatabaseHelper.TABLE_USERS, null, null, null, null, null, null);
    }

    // MyDatabaseOperations.java

    public Cursor getUser(String username, String password) {
        String[] columns = {
                MyDatabaseHelper.COLUMN_USERNAME,
                MyDatabaseHelper.COLUMN_PASSWORD
        };

        String selection = MyDatabaseHelper.COLUMN_USERNAME + " = ? AND " +
                MyDatabaseHelper.COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};

        return database.query(MyDatabaseHelper.TABLE_USERS, columns, selection, selectionArgs, null, null, null);
    }

    // Other database operations as needed
}
