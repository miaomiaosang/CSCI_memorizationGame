package com.mms.memorizationgame;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Comparator;

public class SortByItemhard implements Comparator<User> {
        /*
         * (non-Javadoc)
         *
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         * lhs- 1st message in the form of json object. rhs- 2nd message in the form
         * of json object.
         */
        @Override
        public int compare(User lhs, User rhs) {

            return lhs.hard > rhs.hard ? 1 :
                    (lhs.hard < rhs.hard ? -1 : 0);



        }
    }

