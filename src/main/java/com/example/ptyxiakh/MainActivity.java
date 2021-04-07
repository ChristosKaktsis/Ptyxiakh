package com.example.ptyxiakh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

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

    //
    //use this to get the data ans send it to fragment
    public ArrayList<String> textData = new ArrayList<>();
    public ArrayList<String> imageURLData = new ArrayList<>();

    BottomNavigationView bottomNavigationView;

    //
    //var for the lesson items
    //
    public static String lessonID = ""; //lesson id for the async class
    public ArrayList<LessonItem> lessonItems = new ArrayList<>();//list with the lessons
    public ArrayList<String> examino = new ArrayList<>();


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
                .addToBackStack("")
                .commit();
    }

    //
    //Check for connection in the internet
    //
    public boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo_wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo networkInfo_mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((networkInfo_wifi !=null && networkInfo_wifi.isConnected()) || networkInfo_mobile != null && networkInfo_mobile.isConnected()) {
            return true;
        }
        else {
            showDialog();
            return false;
        }
    }

    //
    //Show toast if not connect
    //
    private void showDialog() {
        Context context = this;
        CharSequence text = "NO INTERNET CONNECTION";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER,0 ,0);
        toast.show();
    }


    public void callAsyncTask(String whatToGet) {

        if (isConnected()) {
            new Content(whatToGet).execute();
        }

    }
    //
    //Get data from web with Async
    //
    public class Content extends AsyncTask<Void, Void, Void> {

        private String whatToGet;//Ποια μεθοδος θα κληθει
        private String lessonTitle = "";

        public Content(String whatToGet) {
            this.whatToGet = whatToGet;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            switch (whatToGet) {

                case "GET_ABOUT" :
                    getAbout();
                    break;
                case  "GET_LESSONS" :
                    getLessons();
                    break;
                case  "GET_LESSON_INFO" :
                    getLessonInfo(lessonID);
                    break;

            }

            return null;
        }

        /**
         * Τραβάει την πληροφορια απο την σελιδα Σχετικα Με εμας
         */
        public void getAbout() {
            try {

                String url = "https://www.iee.ihu.gr/about/";
                Document doc = Jsoup.connect(url).get();
                Elements data = doc.select("div.entry-content")
                        .select("p");
                int size = data.size();
                for (int i = 0; i<size; i++) {
                    String text1 = data.select("p")
                            .select("p")
                            .eq(i)
                            .text();
                    textData.add(text1);
                    String img =data.select("p")
                            .select("img")
                            .eq(i)
                            .attr("src");
                    imageURLData.add(img);
                    Log.d("items","text"+textData);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * Μεσα απο το url που έχει τον πινακα μαθηματων, παιρνει ολα τα πεδια String και τα βαζει στο ArrayList lessonItems kai examino
        **/
        public void getLessons() {

            try {

                String url = "https://www.iee.ihu.gr/udg_courses/";
                Document doc = Jsoup.connect(url).get();
                //
                //get all the examino Headers
                //
                Elements examinodata = doc.select("main.site-main")
                        .select("div")
                        .select("h2");
                //
                //get all the tables with the lessons
                //
                Elements data = doc.select("main.site-main")
                        .select("table")
                        .select("tbody");

                //
                //add the examino headers to the array
                //
                for (Element h2 : examinodata) {
                    String headexamino = h2.text();
                    examino.add(headexamino);

                }

                int examinocount = 0;
                //
                //add every table row to the strings
                //
                for (Element tbody : data) {

                    Elements trdata = tbody.select("tr");
                    for (Element tr : trdata) {

                        String kod = tr.select("td[title]")
                                .eq(0)
                                .text();
                        String titl = tr.select("td[title]")
                                .eq(1)
                                .text();
                        String eid = tr.select("td[title]")
                                .eq(2)
                                .text();
                        String the = tr.select("td[title]")
                                .eq(3)
                                .text();
                        String erg = tr.select("td[title]")
                                .eq(4)
                                .text();
                        String ect = tr.select("td[title]")
                                .eq(5)
                                .text();

                        lessonItems.add(new LessonItem(examino.get(examinocount), kod, titl, eid, the, erg, ect));

                    }
                    examinocount++;

                }
                // Log.d("items", "text: " + examino);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        /**
         * Για κάθε ενα μάθημα που γινεται click στον πινακα μαθημάτων, παιρνει το lessonID και τραβάει την πληροφορια απο τη σελιδα του μαθήματος
         * Π.Χ. ( https://www.iee.ihu.gr/course/1707 )
         * @param lessonID
         */
        public void getLessonInfo(String lessonID) {

            try {

                String url = "https://www.iee.ihu.gr/course/"+lessonID;
                Document doc = Jsoup.connect(url).get();
                Elements data = doc.select("main.site-main")
                        .select("h1");
                int size = data.size();
                for (int i = 0; i<size; i++) {
                    lessonTitle = data.eq(i)
                            .text();
                    Log.d("items","text"+lessonTitle);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            //
            //Αναλογα με το what to get κάλεσε το κατάλληλο Fragment
            //
            switch (whatToGet) {

                case "GET_ABOUT" :
                    setCurrentFragment(About_fragment.newInstance(textData, imageURLData));
                    break;
                case  "GET_LESSONS" :
                    setCurrentFragment(DisplayLessons.newInstance(examino, lessonItems));
                    break;
                case  "GET_LESSON_INFO" :
                    setCurrentFragment(Lesson_Info.newInstance(lessonTitle,"Hello"));
                    break;

            }

        }
    }

}