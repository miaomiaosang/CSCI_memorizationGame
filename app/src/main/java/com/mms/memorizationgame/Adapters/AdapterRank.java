package com.mms.memorizationgame.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mms.memorizationgame.SortByItemhard;
import com.mms.memorizationgame.SortByItemeasy;
import com.mms.memorizationgame.User;
import com.mms.memorizationgame.R;

import java.util.ArrayList;
import java.util.Collections;

public class AdapterRank extends RecyclerView.Adapter<AdapterRank.ViewHolder> {

    //Context context;
    ArrayList<User> users;
    String level;
    public AdapterRank(ArrayList<User> userlist, String level) {
        //this.context = c;
        this.users = userlist;
        this.level = level;

        if(this.level == "hard") {
            Collections.sort(users, new SortByItemhard());
        }else{
            Collections.sort(users, new SortByItemeasy());
        }
    }

    @Override
    public AdapterRank.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rank_item, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRank.ViewHolder holder, int position) {
        holder.user_name.setText(users.get(position).name);
        holder.level_view.setText(level);
        if (level == "hard") {
            holder.score.setText(Integer.toString(users.get(position).hard));
        } else {
            holder.score.setText(Integer.toString(users.get(position).easy));
        }
    }

    @Override
    public int getItemCount() {
        if (users == null) {
            return 0;
        } else {
            return users.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView user_name;
        private TextView score;
        private TextView level_view;

        public ViewHolder(View itemView) {
            super(itemView);
            user_name = itemView.findViewById(R.id.user_name);
            score = itemView.findViewById(R.id.time);
            level_view = itemView.findViewById(R.id.level);
        }
    }


    }

