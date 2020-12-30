package com.project.projectlevel1;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class AddStudentTask extends AsyncTask<Void, Integer, String> {


    private static final String TAG = "DatabaseOpenHelper";
    private Context context;
    private List<Student> students;
    private StudentDB studentDB;
    private ProgressDialog progressDialog;


    private MyItemRecyclerViewAdapter myItemRecyclerViewAdapter;

    @Override
    protected String doInBackground(Void... voids) {

for(int i=0;i<students.size();i++) {

    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

Student student=students.get(i);
    ContentValues contentValues = new ContentValues();
    contentValues.put(studentDB.F_NAME, student.getF_name());
    contentValues.put(studentDB.L_NAME, student.getL_name());
    contentValues.put(studentDB.PHONE_NUMBER, student.getPhoneNumber());
    contentValues.put(studentDB.City_Name, student.getCity());
    contentValues.put(studentDB.INTERESTED, student.getInterested());
    contentValues.put(studentDB.AVATAR, student.getAvatar());
    SQLiteDatabase sqLiteDatabase = studentDB.getWritableDatabase();
    long isInstence = sqLiteDatabase.insert(studentDB.TABLE_NAME, null, contentValues);
    Log.i(TAG, "add_student: " + isInstence);


        publishProgress((i*100)/students.size());

}




        return "";


    }


    public AddStudentTask(Context context, List<Student>students, StudentDB studentDB) {
        this.context = context;
        this.students = students;
        this.studentDB = studentDB;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("درحال ذخیره سازی");
        progressDialog.setMessage("لطفا تا پایان ذخیزه سازی صبر کنید ");
        progressDialog.show();

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressDialog.hide();


    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressDialog.setProgress(values[0]);
    }
}
