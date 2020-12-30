package com.project.projectlevel1;

import android.graphics.drawable.Drawable;

public class Student {
    private String F_name;
    private String L_name;
    private String PhoneNumber;
    private int  ID;
    private String Avatar;
    private  String sex;
    private String City;
private String interested;
    public String getF_name() {
        return F_name;
    }

    public void setF_name(String f_name) {
        F_name = f_name;
    }

    public String getL_name() {
        return L_name;
    }

    public void setL_name(String l_name) {
        L_name = l_name;
    }



    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }




    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getInterested() {
        return interested;
    }

    public void setInterested(String interested) {
        this.interested = interested;
    }
}
