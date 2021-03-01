package com.example.ptyxiakh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    FrameLayout flfragment ; //Layout that fragments will appear
    Fragment main_fragment = new Main_Fragment();
    Fragment profile_fragment = new Profile_fragment();

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flfragment = findViewById(R.id.flfragment);
        setCurrentFragment(main_fragment);

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