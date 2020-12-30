package com.project.projectlevel1;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;


/**
 * A fragment representing a list of Items.
 */
public class ListStudentFragment extends Fragment {


    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private Context context;

    private StudentDB studentDB;
    private MyItemRecyclerViewAdapter myItemRecyclerViewAdapter;
    private RecyclerView recyclerView;

    private ApiService apiService;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListStudentFragment(Context context) {
        this.context = context;
        apiService = new ApiService(context);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_student_list, container, false);

        studentDB = new StudentDB(context);

        apiService.getData(new ApiService.onGetStudent() {
            @Override
            public void onReceived(List<Student> studentList) {
                studentDB.AddStudent(studentList);
            }
        });
        if (studentDB.getStudents() != null) {

            setRecycleView(view);
            setStudentDataInRecyclerView();

        } else {
            Toast.makeText(context, "درحال حاضر دانشجویی وارد نکرده اید", Toast.LENGTH_LONG).show();

        }


        return view;
    }

    private void setStudentDataInRecyclerView() {
        myItemRecyclerViewAdapter = new MyItemRecyclerViewAdapter(context, studentDB.getStudents());


        recyclerView.setAdapter(myItemRecyclerViewAdapter);
    }

    private void setRecycleView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

}