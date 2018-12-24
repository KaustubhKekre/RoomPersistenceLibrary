package com.example.falcon.room;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class display_frag extends Fragment {
    TextView display;
    List<student> stud;
    public String data="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);
        display = (TextView) view.findViewById(R.id.display_f);

        Executor executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> {
            stud = MainActivity.studentDB.sDAO().display();
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    
                    for (student stu : stud) {

                            int id = stu.getId();

                            String name = stu.getName();
                            String bname = stu.getBranch_name();
                            data = data + "\n\n" + "Id-" + String.valueOf(id) + "\nName-" + name + "\nBranch-" + bname;

                    }
                    display.setText(data);
                }
            });
        });


        return view;
    }

}
