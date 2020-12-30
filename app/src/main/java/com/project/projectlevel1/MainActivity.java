package com.project.projectlevel1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AppFeatureAdaptor appFeatureAdaptor;

    private TextView username;
    private ShareParefrans shareParefrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        setRecyclerView();
        username = findViewById(R.id.userName);
        shareParefrans = new ShareParefrans(this);
        String user = shareParefrans.getUser().getUsername();
        username.setText(String.valueOf(user));


    }

    private void setRecyclerView() {
        recyclerView = findViewById(R.id.AppFeatureRecyclerView);
        appFeatureAdaptor = new AppFeatureAdaptor(this, DataGenerator.GetData(this));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(appFeatureAdaptor);

    }


}