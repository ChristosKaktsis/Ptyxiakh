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

        //Execute the class AsyncTask to get the data from website
        Content content = new Content();
        content.execute();


    }

    //Add the fragment in the Frame layout
    public void setCurrentFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flfragment, fragment)
                .commit();

    }

    public class Content extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {

                String url = "https://www.iee.ihu.gr/about/";
                Document doc = Jsoup.connect(url).get();
                Elements data = doc.select("div.entry-content")
                        .select("p");
                int size = data.size();
                for (int i = 0; i<size; i++) {
                    String dataText = data.select("p")
                            .select("p")
                            .eq(i)
                            .text();
                    items_in_sites.add(new Items_In_Site(dataText));
                    Log.d("items","text"+dataText);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

}