package com.project.projectlevel1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class RegisterActivity extends AppCompatActivity {
    private TextView F_name;
    private TextView L_name;
    private TextView PhoneNumber;
    private String CityName;
    private TextView interested;
    private ImageView Avatar;
    private Button Submit;
    private Button Load_Pic;
    private StudentDB studentDB;
    private Uri ImageUri;
    private ApiService apiService;
    private Spinner list_city;
    String encodedImage;
    RadioButton Female;
    RadioButton Male;
    private setAnimationOnButton setAnimationOnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        SetUpView();
        SppinerSetUp();
        setAnimationOnButton = new setAnimationOnButton(this, Load_Pic);
        setAnimationOnButton = new setAnimationOnButton(this, Submit);
        apiService = new ApiService(this);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataInSql();
            }
        });

    }

    private void SppinerSetUp() {
        list_city = findViewById(R.id.sppiner_city);
        String[] cities = {"تهران ", "رشت ", "شیراز ", "اصفهان ", "مازندران", "مشهد", "اردبیل", "کیش"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cities);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        list_city.setAdapter(arrayAdapter);
        CityName = String.valueOf(list_city.getSelectedItem());


    }

    private void saveDataInSql() {
        if (F_name.getText() != null && L_name.getText() != null
                && interested.getText() != null && PhoneNumber.getText() != null && Avatar.getDrawable() != null) {
            studentDB = new StudentDB(this);

            Student student = new Student();
            try {
                student.setF_name(F_name.getText().toString());
                student.setL_name(L_name.getText().toString());
                student.setInterested(interested.getText().toString());
                student.setCity(CityName);
                student.setPhoneNumber(PhoneNumber.getText().toString());
                if (Female.isChecked())
                    student.setSex(Female.getText().toString());
                else
                    student.setSex(Male.getText().toString());
                student.setAvatar(encodedImage);
                apiService.SavaData(student, new ApiService.onSaveStudent() {
                    @Override
                    public void onReceived(boolean responseStatus) {
                        if (responseStatus == true) {

                            Toast.makeText(RegisterActivity.this, "ثبت نام با موفقیت انجام شد ", Toast.LENGTH_LONG).show();
                            F_name.setText(null);
                            L_name.setText(null);
                            Female.setChecked(false);
                            Male.setChecked(false);
                            interested.setText(null);
                            PhoneNumber.setText(null);
                            Avatar.setImageDrawable(null);


                        } else {

                            Toast.makeText(RegisterActivity.this, "ثبت نام موفقیت امیز نبود  ", Toast.LENGTH_LONG).show();


                        }
                    }
                });


            } catch (Exception e) {

                Log.e("error in save data", "onCreate: " + e.toString());
            }
        } else {

            Snackbar.make(findViewById(R.id.coordinator1), "لطفا فیلد هارا پر کنید ", Snackbar.LENGTH_LONG).show();
        }

    }


    private void SetUpView() {
        F_name = findViewById(R.id.f_name_student);
        L_name = findViewById(R.id.l_name_student);
        PhoneNumber = findViewById(R.id.phone_number);
        Female = findViewById(R.id.female);
        Male = findViewById(R.id.male);
        interested = findViewById(R.id.address);
        Avatar = findViewById(R.id.student_pic);
        Load_Pic = findViewById(R.id.load_avatar);
        Submit = findViewById(R.id.submit);


        Load_Pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                String[] mimeTypes = {"image/jpeg", "image/png"};
                intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
                startActivityForResult(intent, 1);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 1 && resultCode == RESULT_OK) {
            try {
                this.ImageUri = data.getData();
                Bitmap bitmap;

                    bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(ImageUri));
                    Avatar.setImageBitmap(bitmap);
                final int COMPRESSION_QUALITY = 100;

                ByteArrayOutputStream byteArrayBitmapStream = new ByteArrayOutputStream();
               bitmap.compress(Bitmap.CompressFormat.PNG, COMPRESSION_QUALITY,
                        byteArrayBitmapStream);
                byte[] b = byteArrayBitmapStream.toByteArray();
                encodedImage = Base64.encodeToString(b, Base64.DEFAULT);




                Toast.makeText(this, "     بارگزاری موفقیعت امیز بود    " + ImageUri, Toast.LENGTH_LONG).show();

            } catch (Exception e) {
                Toast.makeText(this, "در بارگزاری عکس مشکلی پیش امده است ", Toast.LENGTH_LONG).show();
            }
        }
    }


}