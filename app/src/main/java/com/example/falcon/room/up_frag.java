package com.example.falcon.room;

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


public class up_frag extends Fragment {
   EditText IDu,nameu,bnameu;
   Button butu;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_up_frag, container, false);
        IDu=(EditText)view.findViewById(R.id.IDu);
        nameu=(EditText)view.findViewById(R.id.nameu);
        bnameu=(EditText)view.findViewById(R.id.bnameu);
        butu=(Button)view.findViewById(R.id.butu);

        butu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(IDu.getText().toString());
                String name=nameu.getText().toString();
                String bname=bnameu.getText().toString();
                student stud2=new student();
                stud2.setId(id);
                stud2.setName(name);
                stud2.setBranch_name(bname);
                Executor executor=Executors.newFixedThreadPool(2);
                executor.execute(()->{
                    MainActivity.studentDB.sDAO().update(stud2);

                });
                Toast.makeText(getActivity(),"Update done",Toast.LENGTH_LONG).show();
                IDu.setText("");
                nameu.setText("");
                bnameu.setText("");
            }
        });

        return view;
    }


}
