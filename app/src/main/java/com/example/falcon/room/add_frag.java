package com.example.falcon.room;

import android.app.IntentService;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class add_frag extends Fragment {
    EditText ID,Name,Bname;
    Button bt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_frag, container, false);
        ID=(EditText)view.findViewById(R.id.ID);
        Name=(EditText)view.findViewById(R.id.Name);
        Bname=(EditText)view.findViewById(R.id.Bname);
        bt=(Button)view.findViewById(R.id.button1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int uID=Integer.parseInt(ID.getText().toString());
                String uName=Name.getText().toString();
                String uBname=Bname.getText().toString();


                student stu=new student();
                stu.setBranch_name(uBname);
                stu.setName(uName);
                stu.setId(uID);
                Executor executor=Executors.newFixedThreadPool(2);
                executor.execute(()->{
                    MainActivity.studentDB.sDAO().insert(stu);
                });


                Toast.makeText(getActivity(),"Success",Toast.LENGTH_LONG).show();
                ID.setText(null);
                Name.setText(null);
                Bname.setText(null);
            }
        });
    return view;
    }


    }



