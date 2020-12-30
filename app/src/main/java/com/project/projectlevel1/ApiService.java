package com.project.projectlevel1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApiService {
    private static final String TAG ="save in database log " ;
    Context context;
    JSONArray jsonArray=new JSONArray();
    FileOutputStream fos ;
    String encImage;
    static  int i=1;
    public ApiService(Context context) {
        this.context = context;

        try {
        fos=    context.openFileOutput("jsonfile", Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getData(final onGetStudent onGetStudentn) {
        StudentDB studentDB=new StudentDB(context);

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        Student student=new Student();
        student.setF_name(jsonObject.getString("f_name"));
        student.setL_name(jsonObject.getString("l_name"));
        student.setAvatar(jsonObject.getString("image_url"));
        student.setInterested(jsonObject.getString("interested"));
        student.setSex(jsonObject.getString("sex"));
        student.setCity(jsonObject.getString("city"));
        student.setPhoneNumber(jsonObject.getString("phonenumber"));

        students.add(student);

    }

    public void SavaData(Student student, final onSaveStudent saveStudent) {



        JSONObject jsonObject = new JSONObject();






        try {
            jsonObject.put("f_name", student.getF_name());
            jsonObject.put("l_name", student.getL_name());
            jsonObject.put("imageUrl", student.getAvatar());
            jsonObject.put("interested", student.getInterested());
            jsonObject.put("sex", student.getSex());
            jsonObject.put("city", student.getCity());
            jsonObject.put("phonenumber", student.getPhoneNumber());
saveStudent.onReceived(true);

            jsonArray.put(i,jsonObject);
            i++;

            String jsonString = jsonObject.toString();

            FileOutputStream fos = null;
            try {
                fos = context.openFileOutput("jsonfile", Context.MODE_PRIVATE);
                try {
                    fos.write(jsonString.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }








    }


    public interface onSaveStudent {
        void onReceived(boolean responseStatus);


    }

    public interface onGetStudent {

        void onReceived(List<Student> studentList);
    }


}
