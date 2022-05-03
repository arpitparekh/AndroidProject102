package com.arpitparekh.hardikbhagvatproject.room_crud;

import android.content.Context;

import androidx.room.Room;

public class DatabaseHelper {

    static EmpDatabase getDatabase(Context context){

        EmpDatabase database = Room.databaseBuilder(context,EmpDatabase.class,"EmpDatabase")
                .allowMainThreadQueries()
                .build();

        return database;

    }

}
