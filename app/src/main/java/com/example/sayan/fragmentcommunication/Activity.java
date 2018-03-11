package com.example.sayan.fragmentcommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

/*

FROM FRAGMENT TO ACTIVITY
        =========================

        Step 1 :
        define an Interface within AFragment (From).

        Step 2 :
        define a method within the Interface with the desired data as a parameter.

        Step 3 :
        implement the Interface by the Activity which holds the fragment.

        Step 4 :
        Auto override the Interface-method within the activity.

        Step 5 :
        override the onAttach() method within the AFragment (FROM)

        Step 6 :
        get the Activity object from the context param of the onAttach() method (check not NULL)

        Step 7 :
        define an interface object within the AFragment (FROM) and initialize it in the onAttach() method with the activity object.

        Step 8 :
        use the interface object (initialized by the activity object) to call the overriden method in the activity whenever required.

        FROM ACTIVITY TO FRAGMENT
        =========================

        Step 9 :
        Define a public method within the BFragment (TO) with a param as the data input

        Step 10 :
        get the BFragment (TO) object from the fragment manager by using findFragmentById(container id) method.

        Step 11 :
        call the public method defined within BFragment (TO) by using the fragment object with the data as a param

        Step 12 :
        get the data (param) in the public method within BFragment (TO) and use it whenever required.

*/

//Step 3
public class Activity extends AppCompatActivity implements AFragment.OnClickEnterButtonListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        addFragmentA();
        addFragmentB();
    }

    private void addFragmentA() {
        AFragment aFragment = new AFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fraga, aFragment)
                .commit();
    }

    private void addFragmentB() {
        BFragment bFragment = new BFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragb, bFragment)
                .commit();
    }

    //Step 4
    @Override
    public void onClick(String text) {
        //Step 10
        BFragment bFragment = (BFragment) getSupportFragmentManager().findFragmentById(R.id.fragb);
        //Step 11
        bFragment.getDataFromActivity(text);
    }
}
