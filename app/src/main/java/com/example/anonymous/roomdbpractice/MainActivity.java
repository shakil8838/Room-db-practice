package com.example.anonymous.roomdbpractice;

import android.app.FragmentManager;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.anonymous.roomdbpractice.DbUtility.DBTable;
import com.example.anonymous.roomdbpractice.DbUtility.MainDatabase;
import com.example.anonymous.roomdbpractice.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    public static MainDatabase mainDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing db
        mainDatabase = Room.databaseBuilder(MainActivity.this, MainDatabase.class, "reminders")
                .allowMainThreadQueries()
                .build();

        if (findViewById(R.id.fragment_container) != null){

            if (savedInstanceState != null){
                return;
            }

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new HomeFragment(), null)
                    .commit();
        }
    }
}
