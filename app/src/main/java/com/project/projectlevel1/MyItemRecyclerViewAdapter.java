package com.project.projectlevel1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;


import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.Instant;
import java.util.List;

/**
 *
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private final List<Student> students;

    public MyItemRecyclerViewAdapter(Context context, List<Student> items) {
        this.context = context;
        students = items;
    }


    public void AddItem(Student student) {
        students.add(student);
        notifyDataSetChanged();

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_list_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Student student = students.get(position);
        byte[] decodedString = Base64.decode(student.getAvatar(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

            holder.Avatar.setImageBitmap(decodedByte);
        holder.f_name.setText(student.getF_name());
        holder.l_name.setText(student.getL_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                ShowStudentInfo showStudentInfo=new ShowStudentInfo(student);
                AppCompatActivity activity = (AppCompatActivity) v.getContext();

               activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentListHolder,showStudentInfo,"Test Fragment").addToBackStack(null).commit();






            }
        });

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView f_name;
        private TextView l_name;
        private ImageView Avatar;


        public ViewHolder(View view) {
            super(view);

            f_name = view.findViewById(R.id.studens_item_f_name);
            l_name = view.findViewById(R.id.studens_item_L_name);
            Avatar = view.findViewById(R.id.students_item_avatar);

        }


    }
}