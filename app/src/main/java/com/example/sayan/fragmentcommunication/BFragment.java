package com.example.sayan.fragmentcommunication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BFragment extends Fragment {

    private TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        text = (TextView)view.findViewById(R.id.bFragText);
        return view;
    }

    //Step 9
    public void getDataFromActivity(String text){
        //Step 12
        this.text.setText(text);
    }
}
