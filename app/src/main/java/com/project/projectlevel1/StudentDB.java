package com.project.projectlevel1;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class StudentDB extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseOpenHelper";
    public static final String F_NAME = "f_name";
    public static final String L_NAME = "l_name";
    public static final String DB_NAME = "REGISTER";
    public static final String TABLE_NAME = "STUDENT";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String SEX = "sex";
    public static final String City_Name = "city_name";

    public static final String INTERESTED = "interested";

    public static final String ID = "ID";
    public static final String AVATAR = "Avatar";
    public static final String CREATE_TABLE_STUDENT = "CREATE TABLE IF NOT EXISTS  " + TABLE_NAME + " (" +
            F_NAME + " TEXT, " +
            L_NAME + " TEXT ," +
            PHONE_NUMBER + " TEXT  , " +
            SEX + "  TEXT ," +
            City_Name + "  TEXT  ," +
            INTERESTED + "  TEXT  , " +
            AVATAR + "  TEXT  ," +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT  );";
    private Context context;

    public StudentDB(@Nullable Context context) {
        super(context, DB_NAME, null, 2);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE_STUDENT);


        } catch (SQLException e) {
            Log.e(TAG, "onCreate: " + e.toString());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }


    public void AddStudent(List<Student> students) {
        AddStudentTask addStudentTask = new AddStudentTask(context, students, this);
        addStudentTask.execute();


    }

    public List<Student> getStudents() {

        List<Student> students = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM  " + TABLE_NAME, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            while (!cursor.isAfterLast()) {
                Student student = new Student();
                student.setF_name(cursor.getString(0));
                student.setL_name(cursor.getString(1));
                student.setPhoneNumber(cursor.getString(2));
                student.setSex(cursor.getString(3));
                student.setCity(cursor.getString(4));
                student.setInterested(cursor.getString(5));
                student.setAvatar(cursor.getString(6));
                student.setID(cursor.getInt(7));


                students.add(student);


                cursor.moveToNext();

            }


        }
        cursor.close();
        sqLiteDatabase.close();
        return students;
    }


}
