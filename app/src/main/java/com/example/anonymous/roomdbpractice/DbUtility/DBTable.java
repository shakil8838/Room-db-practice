package com.example.anonymous.roomdbpractice.DbUtility;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "reminders")
public class DBTable {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "reminder_title")
    private String reminderTitle;

    @ColumnInfo(name = "reminder_details")
    private String reminderDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReminderTitle() {
        return reminderTitle;
    }

    public void setReminderTitle(String reminderTitle) {
        this.reminderTitle = reminderTitle;
    }

    public String getReminderDetails() {
        return reminderDetails;
    }

    public void setReminderDetails(String reminderDetails) {
        this.reminderDetails = reminderDetails;
    }
}
