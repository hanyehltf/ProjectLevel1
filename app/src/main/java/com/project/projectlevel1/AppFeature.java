package com.project.projectlevel1;

import androidx.annotation.DrawableRes;

public class AppFeature {



    public static final int REGISTER_ID=0;
    public static final int STUDENT_LIST_ID=1;
    private int id;
    private String title;
    @DrawableRes
    private int featureImage;
    private Class DestinationActivity;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFeatureImage() {
        return featureImage;
    }

    public void setFeatureImage(int featureImage) {
        this.featureImage = featureImage;
    }

    public Class getDestinationActivity() {
        return DestinationActivity;
    }

    public void setDestinationActivity(Class destinationActivity) {
        DestinationActivity = destinationActivity;
    }
}
