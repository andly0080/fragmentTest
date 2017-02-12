package com.example.davidyu.fragmenttest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentManager = getFragmentManager();

        Button mapBtn  = (Button) findViewById(R.id.map);

        Button foodMenuBtn = (Button) findViewById(R.id.food_menu);

        Button giftBtn = (Button) findViewById(R.id.gift);


        mapBtn.setOnClickListener(this);
        foodMenuBtn.setOnClickListener(this);
        giftBtn.setOnClickListener(this);



        loadDefaultFragment();

    }

    private void loadDefaultFragment() {


        Fragment1 me = Fragment1.newInstance("me");

        getFragmentManager().beginTransaction().add(R.id.fragment_container,me).commit();



    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.map:


                Fragment1 fragment1 = Fragment1.newInstance("me");

                fragmentManager.beginTransaction().replace(R.id.fragment_container,fragment1)
                        .commit();




                break;

            case R.id.food_menu:


                Fragment2 fragment2 = Fragment2.newInstance("kkan","me");



                fragmentManager.beginTransaction().replace(R.id.fragment_container,fragment2)
                        .commit();

                break;


            case R.id.gift:
                Fragment3 fragment3 = Fragment3.newInstance("kkan","me");

                fragmentManager.beginTransaction().replace(R.id.fragment_container,fragment3)
                        .commit();
                break;




        }
    }




    private void replaceFragment (Fragment fragment){
        String backStateName = fragment.getClass().getName();


        boolean fragmentPopped = fragmentManager.popBackStackImmediate (backStateName, 0);

        if (!fragmentPopped){ //fragment not in back stack, create it.
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }
}
