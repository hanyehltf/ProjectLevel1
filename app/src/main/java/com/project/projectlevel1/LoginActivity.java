package com.project.projectlevel1;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class LoginActivity extends AppCompatActivity {
    private EditText userName;
    private EditText password;
    private Button submit;
    private ShareParefrans shareParefrans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpView();
        setAnimationOnButton setAnimationOnButton=new setAnimationOnButton(this,submit);
    }

    public void setUpView() {
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.login_btn);
        shareParefrans = new ShareParefrans(LoginActivity.this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText() != null && password.getText() != null) {
                    User user = new User();
                    user.setUsername(userName.getText().toString());
                    user.setPassword(password.getText().toString());
                    shareParefrans.saveUser(user);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(LoginActivity.this,
                            "لطفا فیلد هارا پر کنید", Toast.LENGTH_LONG).show();
                }
            }
        });

    }




}