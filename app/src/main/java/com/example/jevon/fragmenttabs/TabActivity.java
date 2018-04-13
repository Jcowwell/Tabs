package com.example.jevon.fragmenttabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Jevon on 4/11/18.
 */



public class TabActivity extends AppCompatActivity implements BiographyFragment.DirectionButtonClickListener {


    Bundle bundle;

    Button nameButtonStart;
    Button nameButtonCenter;
    Button nameButtonEnd;

    String[] names;
    String[] bios;
    int amount;

    public static final String NEXT = "next";
    public static final String PREV = "prev";
    public static final String TAG = "tag";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity);
        bundle = new Bundle();
        nameButtonStart = findViewById(R.id.nameStart);
        nameButtonCenter = findViewById(R.id.nameCenter);
        nameButtonEnd = findViewById(R.id.nameEnd);
        tabHide();
        getData();
        setButtonNames();
        onTabClick(nameButtonStart);
    }


    public void onTabClick(View view) {
        //Upon selection run Fragment Transaction
        switch(view.getId()) {
            case R.id.nameStart:
                bundle.putString(MainActivity.NAMES, names[0]);
                bundle.putString(MainActivity.BIOS, bios[0]);
                dirButtonHide(view);
                bundle.putInt(TAG, 0);
                swapFragments(bundle);
                break;

            case R.id.nameCenter:
                bundle.putString(MainActivity.NAMES, names[1]);
                bundle.putString(MainActivity.BIOS, bios[1]);
                dirButtonHide(view);
                bundle.putInt(TAG, 1);
                swapFragments(bundle);
                break;
            case R.id.nameEnd:
                bundle.putString(MainActivity.NAMES, names[2]);
                bundle.putString(MainActivity.BIOS, bios[2]);
                dirButtonHide(view);
                bundle.putInt(TAG, 2);
                swapFragments(bundle);
                break;

        }
    }

    private void swapFragments(Bundle bundle) {
        BiographyFragment bioFragment = new BiographyFragment();
        bioFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, bioFragment).commit();
    }

    private void getData() {

        names = getIntent().getStringArrayExtra(MainActivity.NAMES);
        bios = getIntent().getStringArrayExtra(MainActivity.BIOS);

    }

    private void setButtonNames() {
        nameButtonStart.setText(names[0]);
        if (nameButtonCenter.getVisibility() != View.GONE) {
            nameButtonCenter.setText(names[1]);
        }
        if (nameButtonEnd.getVisibility() != View.GONE) {
            nameButtonEnd.setText(names[2]);
        }
    }

    private void tabHide() {
        amount = getIntent().getIntExtra(MainActivity.AMOUNT, 1);
        switch (amount) {
            case 1:
                nameButtonCenter.setVisibility(View.GONE);
                nameButtonEnd.setVisibility(View.GONE);
                bundle.putInt(NEXT, View.GONE);
                bundle.putInt(PREV, View.GONE);
                break;
            case 2:
                nameButtonEnd.setVisibility(View.GONE);
                break;
        }
    }

    private void dirButtonHide(View view) {

        switch(view.getId()) {

            case R.id.nameStart:
                bundle.putInt(NEXT, View.VISIBLE);
                bundle.putInt(PREV, View.GONE);
                switch (amount) {
                    case 1:
                        bundle.putInt(NEXT, View.GONE);
                        break;
                }
                break;

            case R.id.nameCenter:
                bundle.putInt(NEXT, View.VISIBLE);
                bundle.putInt(PREV, View.VISIBLE);
                switch(amount) {
                    case 2:
                        bundle.putInt(NEXT, View.GONE);
                        break;
                }
                break;

            case R.id.nameEnd:
                bundle.putInt(NEXT, View.GONE);
                bundle.putInt(PREV, View.VISIBLE);
                break;

        }
    }

    @Override
    public void onNextButtonClicked(int tag) {

        switch(tag) {
            case 0:
                onTabClick(nameButtonCenter);
                break;
            case 1:
                onTabClick(nameButtonEnd);
                break;
        }
    }

    @Override
    public void onPrevButtonClicked(int tag) {

        switch(tag) {
            case 1:
                onTabClick(nameButtonStart);
                break;
            case 2:
                onTabClick(nameButtonCenter);
                break;
        }
    }
}
