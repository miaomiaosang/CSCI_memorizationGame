package com.mms.memorizationgame;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mms.memorizationgame.Adapters.AdapterRank;

import java.util.ArrayList;

public class EasyRank extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<User> list;
    AdapterRank adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rank_list);

        // initiate Firebase connection
        reference = FirebaseDatabase.getInstance().getReference().child("user");
        //get data
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<User>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    // put user's play records in a list
                    User p = dataSnapshot1.getValue(User.class);
                    if(p.easy!=10000){
                        list.add(p);
                        Log.d("user",p.name);
                    }
                    //list.add(p);
                    //Log.d("user",p.name);
                }
                //is the data is ready, we start the recyclerView
                recyclerView = (RecyclerView) findViewById(R.id.ranklist);

                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                adapter = new AdapterRank(list,"easy");
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getBaseContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

}