package com.mms.memorizationgame;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

// User data profile

public class User {
    public String name;
    public String email;
    public int hard;
    public int easy;

    public User(){

    }


    public User(String name, String email, int hard, int easy) {
        this.name = name;
        this.email = email;
        this.hard = hard;
        this.easy = easy;
    }

//    public String getName() {
//        return name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getHard() {
//        return hard;
//    }
//
//    public String getEasy() {
//        return easy;
//    }

//    public User(String name) {
//        this.name = name;
//    }

//    @Exclude
//    public Map<String, Object> toMap(){
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("name",name);
//        result.put("hard", hard);
//        result.put("easy",easy);
//
//        return result;
//    }





}
