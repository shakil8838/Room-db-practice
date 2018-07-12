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
public class UpdateFragment extends Fragment {


    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Initializing all widgets
        final EditText updateId = getActivity().findViewById(R.id.reminder_update_id);
        final EditText updateTitle = getActivity().findViewById(R.id.reminder_update_title);
        final EditText updateDetails = getActivity().findViewById(R.id.reminder_update_Details);
        Button updateBtn = getActivity().findViewById(R.id.update_reminder);

        final DBTable dbTable = new DBTable();

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbTable.setId(Integer.parseInt(updateId.getText().toString()));
                dbTable.setReminderTitle(updateTitle.getText().toString());
                dbTable.setReminderDetails(updateDetails.getText().toString());

                MainActivity.mainDatabase.dbOperations().updateReminder(dbTable);

                updateId.setText("");
                updateTitle.setText("");
                updateDetails.setText("");

                Toast.makeText(getContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
