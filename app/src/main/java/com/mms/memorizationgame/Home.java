package com.mms.memorizationgame;

import android.app.DownloadManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


// The container that contains fragments of games
//changing of game scenario are based on changing of game fragments
public class Home extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layoutFragment, new Start());
        transaction.commit();

        //SharedPreferences prefs = getSharedPreferences("user_email", MODE_PRIVATE);
        //String email = prefs.getString("email", null);
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//        //Log.d("uid",uid);   UID is correct
//        b_uid.putString("uid",uid);
//        DatabaseReference mUIDReference = FirebaseDatabase.getInstance().getReference()
//                .child("user").child(uid);
//        ValueEventListener user_name_listener = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                //user_detail = dataSnapshot.getValue(User.class);
//                user_name = dataSnapshot.child("name").getValue(String.class);
//                Log.d("username",user_name);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Log.w("user_info_retrieve_err", "loadPost:onCancelled", databaseError.toException());
//                // [START_EXCLUDE]
//                Toast.makeText(Home.this, "Failed to load user.",
//                        Toast.LENGTH_SHORT).show();
//
//            }
//        };
//
//
//        mUIDReference.addListenerForSingleValueEvent(user_name_listener);




    }

    int counter = 0;
    // deal with back press button events
    @Override
    public void onBackPressed() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.layoutFragment);

        counter++;
        if (currentFragment instanceof Start){
            AlertDialog.Builder exit = new AlertDialog.Builder(this);
            exit.setTitle("Do you really want to go?");
            exit.setPositiveButton("Yes, please.", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            exit.setNegativeButton("Umm, I can stay.", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(Home.this, "Welcome back.", Toast.LENGTH_SHORT).show();
                }
            });

            exit.show();
        }
        else if(currentFragment instanceof Result){
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            super.onBackPressed();
        }
        else{
            super.onBackPressed();
        }

    }
}