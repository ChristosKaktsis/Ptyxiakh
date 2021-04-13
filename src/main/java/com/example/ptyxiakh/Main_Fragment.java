package com.example.ptyxiakh;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Main_Fragment extends Fragment implements View.OnClickListener {



    public Main_Fragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        //set the button views
        ImageButton aboutusbtn = view.findViewById(R.id.about_us_button);
        ImageButton lessonbtn = view.findViewById(R.id.lessons_button);
        ImageButton schedulebtn = view.findViewById(R.id.schedule_button);

        /**
         * set on click to every button in the main fragment
         * so it can open the fragment
         */
        aboutusbtn.setOnClickListener(this::onClick);
        lessonbtn.setOnClickListener(this::onClick);
        schedulebtn.setOnClickListener(this::onClick);
        return view;
    }

    /**
     * Οταν γινεται click σε ενα button στο main fragment ελεγχει εαν υπάρχει συνδεση στο internet
     * και μετα καλεί την μεθοδο callAsync η οποια εκτελεί την κλάση που τραβάει τα δεδομένα απο το
     * site
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.about_us_button :
                // call the About_Fragment
                ((MainActivity)getActivity()).callAsyncTask("GET_ABOUT");
                break;
            case R.id.lessons_button :
                // call the DisplayLessons
                ((MainActivity)getActivity()).callAsyncTask("GET_LESSONS");
                break;
            case R.id.schedule_button :
                // call the Schedule_fragment
                ((MainActivity)getActivity()).setCurrentFragment(new ScheduleFragment());
                break;

        }

    }
}
