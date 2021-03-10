package com.example.ptyxiakh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FrameLayout flfragment ; //Layout that fragments will appear
    Fragment main_fragment = new Main_Fragment();
    Fragment profile_fragment = new Profile_fragment();

    public ArrayList<Items_In_Site> items_in_sites = new ArrayList<>();

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flfragment = findViewById(R.id.flfragment);
        //set the first fragment when the app starts
        setCurrentFragment(main_fragment);

        //create the navigation menu and set onclick events for every button on the menu
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_menu_item:
                        setCurrentFragment(main_fragment);
                        break;
                    case R.id.profile_menu_item:
                        setCurrentFragment(profile_fragment);
                }
                return false;
            }
        });


    }

    //Add the fragment in the Frame layout
    public void setCurrentFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flfragment, fragment)
                .commit();

    }

}