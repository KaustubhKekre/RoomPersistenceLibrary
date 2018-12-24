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


public class del_frag extends Fragment {
EditText del;
Button bdel;
int ID;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_del_frag, container, false);
        del=(EditText)view.findViewById(R.id.id);
        bdel=(Button)view.findViewById(R.id.delB);



        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID=Integer.parseInt(del.getText().toString());
                student stud1=new student();
                stud1.setId(ID);
                Executor executor=Executors.newFixedThreadPool(2);
                executor.execute(()->{
                    MainActivity.studentDB.sDAO().delete(stud1);
                });
                Toast.makeText(getActivity(),"Bye bye "+ID,Toast.LENGTH_LONG).show();
                del.setText("");
            }
        });
        return view;
    }

}
