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

public class Main_Fragment extends Fragment {



    public Main_Fragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        //open about fragment click on about button
        ImageButton aboutusbtn = view.findViewById(R.id.about_us_button);

        aboutusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                About_fragment about = new About_fragment();
                Bundle bundle = new Bundle();
                bundle.putString("title","all Ok till now");
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flfragment,about,null)
                        .addToBackStack(null);
                about.setArguments(bundle);
                fragmentTransaction.commit();

            }
        });

        return view;
    }

}
