package com.mms.memorizationgame;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

// The fragment that shows where the user completes the game within certain amount of time
// update the best score of the user to database
public class Result extends Fragment {




    public Result() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Bundle b=getArguments();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        final String level;
        int level_id;
        level_id = b.getInt("level");

        if(level_id==Constants.LEVEL_EASY){
            level = "easy";
        }
        else{
            level = "hard";
        }

        final int time;
        time = b.getInt("Time");
        // initiate database reference
        final DatabaseReference mUIDReference = FirebaseDatabase.getInstance().getReference()
                .child("user").child(uid);

        View rootView = inflater.inflate(R.layout.fragment_result, container, false);



        if (b.getString("Data").equals("win")){

            ((TextView)rootView.findViewById(R.id.status)).setText("You Win");
            ((TextView) rootView.findViewById(R.id.time)).setText("Time : "+b.get("Time").toString());



        }
        else{
            ((TextView)rootView.findViewById(R.id.status)).setText("Sorry, you lose.");
            ((TextView) rootView.findViewById(R.id.time)).setText("Time : "+b.get("Time").toString());

        }

        //mUIDReference.child(level).setValue(time);

        ValueEventListener user_name_listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //user_detail = dataSnapshot.getValue(User.class);
                int time_record = dataSnapshot.child(level).getValue(int.class);
                Log.d("hhh","hhh");
                Log.d("time record",Integer.toString(time_record));
                if(time < time_record){ //If the time that user uses in the current game is less
                    //than his personal record
                    mUIDReference.child(level).setValue(time);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("user_info_retrieve_err", "loadPost:onCancelled", databaseError.toException());
                // [START_EXCLUDE]

            }
        };


        mUIDReference.addListenerForSingleValueEvent(user_name_listener);
        mUIDReference.removeEventListener(user_name_listener);



        return rootView;
    }

}
