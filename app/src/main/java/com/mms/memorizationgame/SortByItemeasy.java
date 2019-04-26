package com.mms.memorizationgame;



import java.util.Comparator;
// java comparator to sort user's game record, for hard level records
public class SortByItemeasy implements Comparator<User> {
        /*
         * (non-Javadoc)
         *
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         * lhs- 1st message in the form of json object. rhs- 2nd message in the form
         * of json object.
         */
        @Override
        public int compare(User lhs, User rhs) {

            return lhs.easy > rhs.easy ? 1 :
                    (lhs.easy < rhs.easy ? -1 : 0);



        }
    }

