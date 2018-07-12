package com.example.anonymous.roomdbpractice.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.anonymous.roomdbpractice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        // Initializing widgets
        Button insertBtn = getActivity().findViewById(R.id.insert_btn);
        Button viewBtn = getActivity().findViewById(R.id.view_btn);
        Button deleteBtn = getActivity().findViewById(R.id.delete_btn);
        Button updateBtn = getActivity().findViewById(R.id.update_btn);

        insertBtn.setOnClickListener(this);
        viewBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.insert_btn:

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new InsertFragment(), null)
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.view_btn:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new RemindersFragment(), null)
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.delete_btn:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new DeleteDataFragment(), null)
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.update_btn:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new UpdateFragment(), null)
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
