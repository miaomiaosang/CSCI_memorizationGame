package com.mms.memorizationgame;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import java.util.Random;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

public abstract class Level extends Fragment {

    public void shuffle(int cards[], int n){
        Random random = new Random();

        for (int i=0;i<n;i++){
            int r = random.nextInt(n-i);

            int temp = cards[r];
            cards[r] = cards[i];
            cards[i] = temp;
        }
    }

    public void fragmentTransaction(Bundle b){
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        final Result r= new Result();
        r.setArguments(b);
        transaction.replace(R.id.layoutFragment, r);
        transaction.commit();
    };
}
