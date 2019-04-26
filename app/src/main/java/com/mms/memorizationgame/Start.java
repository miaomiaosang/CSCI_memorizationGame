package com.mms.memorizationgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wajahatkarim3.easyflipview.EasyFlipView;

public class Start extends Fragment {


    public Start() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_start, container, false);




        rootView.findViewById(R.id.easy).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fragmentTrasaction(new EasyLevel());
                    }
                });
        rootView.findViewById(R.id.hard).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fragmentTrasaction(new HardLevel());
                    }
                });
//        rootView.findViewById(R.id.rank).setOnClickListener(new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(getContext(), Rank.class);
//                        startActivity(intent);
//                    }
//        });




        return rootView;
    }

    private void fragmentTrasaction(Fragment f){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.layoutFragment, f);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}

