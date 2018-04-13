package com.example.jevon.fragmenttabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    ListView listView;
    ListViewAdapter listViewAdapter;

    EditText nameEditText;
    EditText bioEditText;

    Button addTabButton;
    Button clearAllButton;
    Button createTabButton;

    String[] names = new String[3];
    String[] bios = new String[3];

    int counter = 0;

    public static final String NAMES = "names";
    public static final String BIOS = "bios";
    public static final String AMOUNT = "arrayAmount";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        listViewAdapter = new ListViewAdapter(this);
        listView.setAdapter(listViewAdapter);

        nameEditText = findViewById(R.id.name_editView);
        bioEditText = findViewById(R.id.biography_editView);

        addTabButton = findViewById(R.id.add_tab_button);
        clearAllButton = findViewById(R.id.clear_all_button);
        createTabButton = findViewById(R.id.create_tab_button);
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.add_tab_button:
                verfiyEntry();
                // Add to ListView
                break;
            case R.id.clear_all_button:
                listViewAdapter.clearData();
                clearData();
                clearEditText();
                // Clear ListView
                break;
            case R.id.create_tab_button:
                // Intent to Tab Activity

                if (counter <= 0) {
                    Toast.makeText(this, R.string.please_add_a_bio_and_name, Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent(this, TabActivity.class);

                intent.putExtra(NAMES, names);
                intent.putExtra(BIOS, bios);
                intent.putExtra(AMOUNT, counter);
                startActivity(intent);

                break;

        }
    }

    private void verfiyEntry() {
        String name = String.valueOf(nameEditText.getText());
        String bio = String.valueOf(bioEditText.getText());

        if (name.isEmpty()) {
            Toast.makeText(this, R.string.name_cannot_be_empty, Toast.LENGTH_LONG).show();
            return;
        }

        if (bio.isEmpty()) {
            Toast.makeText(this, R.string.bio_cannot_be_empty, Toast.LENGTH_LONG).show();
            return;
        }

        if (counter == names.length) {
            Toast.makeText(this, R.string.you_can_only_have_three_logs, Toast.LENGTH_LONG).show();
            return;
        }

        names[counter] = name;
        bios[counter] = bio;

        listViewAdapter.addData(names, bios);

        clearEditText();

        counter++;
    }

    private void clearData() {
        names = new String[3];
        bios = new String[3];
        counter = 0;
    }

    private void clearEditText() {
        nameEditText.setText("");
        bioEditText.setText("");
    }

}
