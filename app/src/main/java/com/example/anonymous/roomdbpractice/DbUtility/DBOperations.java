package com.example.anonymous.roomdbpractice.DbUtility;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DBOperations {

    @Insert
    public void addInfoIntoDB(DBTable dbtable);

    @Query("select * from reminders")
    public List<DBTable> getAllReminders();

    @Delete
    public void deleteReminder(DBTable dbTable);

    @Update
    public void updateReminder(DBTable dbTable);

}
