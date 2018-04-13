package com.example.jevon.fragmenttabs;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jevon on 4/11/18.
 */

public class BiographyFragment extends Fragment {

    public interface DirectionButtonClickListener {
        void onNextButtonClicked(int tag);
        void onPrevButtonClicked(int tag);

    }

    TextView nameTextView;
    TextView bioTextView;
    Button nextButton;
    Button prevButton;
    int tag;

    DirectionButtonClickListener directionButtonClickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bio_fragment, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameTextView = getView().findViewById(R.id.bio_frag_name);
        bioTextView = getView().findViewById(R.id.bio_frag_bio);
        nextButton = getView().findViewById(R.id.next_button);
        prevButton = getView().findViewById(R.id.previous_button);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        nameTextView.setText(args.getString(MainActivity.NAMES));
        System.out.println(args.getString(MainActivity.NAMES));
        bioTextView.setText(args.getString(MainActivity.BIOS));
        System.out.println(args.getString(MainActivity.BIOS));
        nextButton.setVisibility(args.getInt(TabActivity.NEXT));
        prevButton.setVisibility(args.getInt(TabActivity.PREV));
        tag = args.getInt(TabActivity.TAG);
        setOnClickListener();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            directionButtonClickListener = (DirectionButtonClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(toString() + "must implement the DirectionButtonClickListener");
        }
    }

    private void setOnClickListener() {
        final View.OnClickListener directionButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.next_button:
                        directionButtonClickListener.onNextButtonClicked(tag);
                        break;

                    case R.id.previous_button:
                        directionButtonClickListener.onPrevButtonClicked(tag);
                        break;
                }
            }
        };

        nextButton.setOnClickListener(directionButtonListener);
        prevButton.setOnClickListener(directionButtonListener);
    }

}
