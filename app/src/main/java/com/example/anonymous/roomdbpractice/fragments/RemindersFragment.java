package com.example.anonymous.roomdbpractice.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anonymous.roomdbpractice.DbUtility.DBTable;
import com.example.anonymous.roomdbpractice.MainActivity;
import com.example.anonymous.roomdbpractice.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RemindersFragment extends Fragment {


    public RemindersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reminders, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView allRemindersView = getActivity().findViewById(R.id.all_reminders);

        List<DBTable> getAlldataFromDB = MainActivity.mainDatabase.dbOperations().getAllReminders();

        String allReminders = "";
        for (DBTable dbTable : getAlldataFromDB){

            int reminderId = dbTable.getId();
            String reminderTitle = dbTable.getReminderTitle();
            String reminderDetails = dbTable.getReminderDetails();

            allReminders += reminderId + "\n" + reminderTitle + "\n" + reminderDetails + "\n";
        }

        allRemindersView.setText(allReminders);
    }
}
