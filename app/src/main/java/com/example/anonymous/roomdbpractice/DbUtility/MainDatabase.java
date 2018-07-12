package com.example.anonymous.roomdbpractice.DbUtility;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {DBTable.class}, version = 1)
public abstract class MainDatabase extends RoomDatabase {

    public abstract DBOperations dbOperations();
}
