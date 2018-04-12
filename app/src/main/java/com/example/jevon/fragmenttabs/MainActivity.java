package com.example.jevon.fragmenttabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    Button addTabButton;
    Button clearAllButton;
    Button createTabButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);
        addTabButton = findViewById(R.id.add_tab_button);
        clearAllButton = findViewById(R.id.clear_all_button);
        createTabButton = findViewById(R.id.create_tab_button);
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.add_tab_button:
                // Add to ListView
            case R.id.clear_all_button:
                // Clear ListView
            case R.id.create_tab_button:
                // Intent to Tab Activity
        }
    }
}
