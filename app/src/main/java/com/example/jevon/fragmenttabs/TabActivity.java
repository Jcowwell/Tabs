package com.example.jevon.fragmenttabs;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Jevon on 4/11/18.
 */

public class TabActivity extends AppCompatActivity implements BiographyFragment.onDirectionButtonClickListener {

    Button nameButtonStart;
    Button nameButtonCenter;
    Button nameButtonEnd;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        nameButtonStart = findViewById(R.id.nameStart);
        nameButtonCenter = findViewById(R.id.nameCenter);
        nameButtonEnd = findViewById(R.id.nameEnd);
    }

    @Override
    public void onDirectionButtonClicked() {

    }


    public void onTabClick(View view) {
        //Upon selection run Fragment Transaction
        switch(view.getId()) {
            case R.id.nameStart:

            case R.id.nameCenter:

            case R.id.nameEnd:
        }
    }

    private void swapFragments(int tag) {

    }
}
