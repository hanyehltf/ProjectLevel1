package com.project.projectlevel1;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {


    public static List<AppFeature>   GetData(Context context){
        List<AppFeature>appFeatures=new ArrayList<>();
        AppFeature appFeature=new AppFeature();
        appFeature.setId(AppFeature.REGISTER_ID);
        appFeature.setTitle(context.getString(R.string.register_icon));
        appFeature.setFeatureImage(R.drawable.register);
        appFeature.setDestinationActivity(RegisterActivity.class);
        appFeatures.add(appFeature);

        appFeature=new AppFeature();
        appFeature.setId(AppFeature.STUDENT_LIST_ID);
        appFeature.setTitle(context.getString(R.string.list_of_student_icon));
        appFeature.setFeatureImage(R.drawable.listofstudent);
        appFeature.setDestinationActivity(ListOfStudentActivity.class);
        appFeatures.add(appFeature);


        appFeature=new AppFeature();
        appFeature.setId(AppFeature.STUDENT_LIST_ID);
        appFeature.setTitle("سرگرمی");
        appFeature.setFeatureImage(R.drawable.entertaiment);
        appFeature.setDestinationActivity(PlayMusicActivity.class);
        appFeatures.add(appFeature);

        appFeature=new AppFeature();
        appFeature.setId(AppFeature.STUDENT_LIST_ID);
        appFeature.setTitle("نمونه ازمایشی");
        appFeature.setFeatureImage(R.color.design_default_color_on_primary);
        appFeature.setDestinationActivity(ListOfStudentActivity.class);
        appFeatures.add(appFeature);


        appFeature=new AppFeature();
        appFeature.setId(AppFeature.STUDENT_LIST_ID);
        appFeature.setTitle("نمونه ازمایشی");
        appFeature.setFeatureImage(R.color.design_default_color_on_primary);
        appFeature.setDestinationActivity(ListOfStudentActivity.class);
        appFeatures.add(appFeature);
        appFeature=new AppFeature();
        appFeature.setId(AppFeature.STUDENT_LIST_ID);
        appFeature.setTitle("نمونه ازمایشی");
        appFeature.setFeatureImage(R.color.design_default_color_on_primary);
        appFeature.setDestinationActivity(ListOfStudentActivity.class);
        appFeatures.add(appFeature);

        appFeature=new AppFeature();
        appFeature.setId(AppFeature.STUDENT_LIST_ID);
        appFeature.setTitle("نمونه ازمایشی");
        appFeature.setFeatureImage(R.color.design_default_color_on_primary);
        appFeature.setDestinationActivity(ListOfStudentActivity.class);
        appFeatures.add(appFeature);

        appFeature=new AppFeature();
        appFeature.setId(AppFeature.STUDENT_LIST_ID);
        appFeature.setTitle("نمونه ازمایشی");
        appFeature.setFeatureImage(R.color.design_default_color_on_primary);
        appFeature.setDestinationActivity(ListOfStudentActivity.class);
        appFeatures.add(appFeature);



        appFeature=new AppFeature();
        appFeature.setId(AppFeature.STUDENT_LIST_ID);
        appFeature.setTitle("نمونه ازمایشی");
        appFeature.setFeatureImage(R.color.design_default_color_on_primary);
        appFeature.setDestinationActivity(ListOfStudentActivity.class);
        appFeatures.add(appFeature);



        appFeature=new AppFeature();
        appFeature.setId(AppFeature.STUDENT_LIST_ID);
        appFeature.setTitle("نمونه ازمایشی");
        appFeature.setFeatureImage(R.color.design_default_color_on_primary);
        appFeature.setDestinationActivity(ListOfStudentActivity.class);
        appFeatures.add(appFeature);



        appFeature=new AppFeature();
        appFeature.setId(AppFeature.STUDENT_LIST_ID);
        appFeature.setTitle("نمونه ازمایشی");
        appFeature.setFeatureImage(R.color.design_default_color_on_primary);
        appFeature.setDestinationActivity(ListOfStudentActivity.class);
        appFeatures.add(appFeature);

return appFeatures;

    }
}
