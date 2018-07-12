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
public class DeleteDataFragment extends Fragment {


    public DeleteDataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete_data, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Initializing widgets
        final EditText deleteReminderId = getActivity().findViewById(R.id.delete_reminder_id);
        Button deleteReminderBtn = getActivity().findViewById(R.id.reminder_delete_btn);

        final DBTable dbTable = new DBTable();

        deleteReminderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int deleteId = Integer.parseInt(deleteReminderId.getText().toString());
                dbTable.setId(deleteId);

                MainActivity.mainDatabase.dbOperations().deleteReminder(dbTable);

                Toast.makeText(getContext(), "Deleted successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
