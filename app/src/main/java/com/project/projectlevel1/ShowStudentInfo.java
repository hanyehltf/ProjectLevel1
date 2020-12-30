package com.project.projectlevel1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ShowStudentInfo extends Fragment {
    private ImageView avatar;
    private TextView f_name;
    private TextView l_name;
    private TextView interested;
    private TextView phoneNumber;
    private TextView sex;
    private TextView city;
    private TextView Id_student;
    private Context context;
    private Student student;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_show_student_info, container, false);
        f_name = view.findViewById(R.id.f_name_info);
        l_name = view.findViewById(R.id.l_name_info);
        phoneNumber = view.findViewById(R.id.phone_number_info);
        interested = view.findViewById(R.id.address_info);
        Id_student = view.findViewById(R.id.id_info);
        avatar = view.findViewById(R.id.avatar_student_info);
        sex = view.findViewById(R.id.father_name_info);
city=view.findViewById(R.id.city_info);

        f_name.setText(student.getF_name());
        l_name.setText(student.getL_name());
        phoneNumber.setText(student.getPhoneNumber());
        interested.setText(student.getInterested());
        sex.setText(student.getSex());
        city.setText(student.getCity());
        Id_student.setText(String.valueOf(student.getID()));
        Uri uri=Uri.parse(student.getAvatar());
        Picasso.with(context).load(uri).into(avatar);




        return view;
    }

    public ShowStudentInfo(Student student){
        this.student = student;
    }
}