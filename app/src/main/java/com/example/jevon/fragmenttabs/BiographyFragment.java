package com.example.jevon.fragmenttabs;

import android.app.Fragment;
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

    public interface onDirectionButtonClickListener {
        public void onDirectionButtonClicked();
    }

    TextView nameTextView;
    TextView bioTextView;
    Button directionButton;

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
        directionButton = getView().findViewById(R.id.direction_button);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
