package com.example.sayan.fragmentcommunication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AFragment extends Fragment {

    //Step 7A
    private OnClickEnterButtonListener mOnClickEnterButtonListenerObject;

    //Step 5
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //Step 6
        Activity activity = (Activity) context;
        if (activity != null){
            //Step 7B
            mOnClickEnterButtonListenerObject = activity;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_a, container, false);
        Button enterButton = (Button) view.findViewById(R.id.enter);
        final EditText text = (EditText) view.findViewById(R.id.aFragEText);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempString = text.getText().toString();
                //Step 8
                mOnClickEnterButtonListenerObject.onClick(tempString);
            }
        });
        return view;
    }

    //Step 1
    public interface OnClickEnterButtonListener{
        //Step 2
        void onClick(String text);
    }
}
