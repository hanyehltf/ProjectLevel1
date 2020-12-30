package com.project.projectlevel1;

import android.content.Context;
import android.content.Intent;

public class HomePageLoader {
    private Context context;
    public HomePageLoader(Context context){
        this.context=context;
        Intent intent=new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }
}
