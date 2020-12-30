package com.project.projectlevel1;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class setAnimationOnButton {


    private Context context;
    private Button button;

    public setAnimationOnButton(Context context, Button button){
        this.context = context;
        this.button = button;



        final Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.animation);
        button.startAnimation(myAnim);





    }





}
