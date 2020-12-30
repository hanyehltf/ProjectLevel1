package com.project.projectlevel1;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareParefrans  {
    private Context contax;
    private static final String USER_SHARED_PREF_NAME = "user_shared_pref";

    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private SharedPreferences sharedPreferences;
    public ShareParefrans(Context context ){



        sharedPreferences = context.getSharedPreferences(USER_SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }


    public void saveUser(User user) {
        if (user != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_USERNAME, user.getUsername());
            editor.putString(KEY_PASSWORD, (user.getPassword()));

            editor.apply();
        }
    }




    public User getUser() {
        User user = new User();
    user.setUsername(sharedPreferences.getString(KEY_USERNAME,null));
    user.setPassword(sharedPreferences.getString(KEY_PASSWORD,null));

        return user;
    }




}
