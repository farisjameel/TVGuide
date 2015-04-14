package com.orient.app.tvguide.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.orient.app.tvguide.R;
import com.orient.app.tvguide.activity.ScheduleDetailActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SchedulesDetailFragment extends Fragment {


    private TextView textView;
    public static SchedulesDetailFragment getInstance(int position){
        SchedulesDetailFragment myFragment = new SchedulesDetailFragment();
        Bundle args = new Bundle();
        args.putInt("position",position);
        myFragment.setArguments(args);
        return myFragment;
    }
    public SchedulesDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_schedules_detail,container,false);
        textView = (TextView) layout.findViewById(R.id.textView);
        Bundle bundle = getArguments();
        if(bundle != null){
            textView.setText("Selected page "+(bundle.getInt("position")+1));
        }

        return layout;
    }


}
