package com.example.anonymous.roomdbpractice.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anonymous.roomdbpractice.DbUtility.DBTable;
import com.example.anonymous.roomdbpractice.MainActivity;
import com.example.anonymous.roomdbpractice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InsertFragment extends Fragment {


    public InsertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insert, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Initailizing all widgets
        Button saveReminderBtn = getActivity().findViewById(R.id.save_reminder);
        final EditText reminderId = getActivity().findViewById(R.id.reminder_id);
        final EditText reminderTitle = getActivity().findViewById(R.id.reminder_title);
        final EditText reminderDetails = getActivity().findViewById(R.id.reminder_Details);

        // Initializing DBTable
        final DBTable dbTable = new DBTable();

        // Handeling Button click event
        saveReminderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Adding data into DB Tables
                dbTable.setId(Integer.parseInt(reminderId.getText().toString()));
                dbTable.setReminderTitle(reminderTitle.getText().toString());
                dbTable.setReminderDetails(reminderDetails.getText().toString());

                // Inserting data into database
                MainActivity.mainDatabase.dbOperations().addInfoIntoDB(dbTable);

                // Displaying a Toast message to user
                Toast.makeText(getContext(), "Data inserted successfully", Toast.LENGTH_SHORT).show();

                // Setting all fields to empty
                reminderId.setText("");
                reminderTitle.setText("");
                reminderDetails.setText("");
            }
        });
    }
}
