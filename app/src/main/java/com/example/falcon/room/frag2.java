package com.example.falcon.room;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class frag2 extends Fragment implements View.OnClickListener {
    private Button badd, bdis,bdel,bup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag2, container, false);
        badd = (Button) view.findViewById(R.id.add);
        bdis = (Button) view.findViewById(R.id.display);
        bdel=(Button)view.findViewById(R.id.delete);
        bup=(Button)view.findViewById(R.id.update);
        badd.setOnClickListener(this);
        bdis.setOnClickListener(this);
        bdel.setOnClickListener(this);
        bup.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                MainActivity.fm.beginTransaction().replace(R.id.frag1, new add_frag()).addToBackStack(null).commit();
                break;
            case R.id.display:
                MainActivity.fm.beginTransaction().replace(R.id.frag1, new display_frag()).addToBackStack(null).commit();
                break;
            case R.id.delete:
                MainActivity.fm.beginTransaction().replace(R.id.frag1,new del_frag()).addToBackStack(null).commit();
            case R.id.update:
                MainActivity.fm.beginTransaction().replace(R.id.frag1,new up_frag()).addToBackStack(null).commit();
        }
    }
}
