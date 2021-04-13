package com.example.ptyxiakh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DisplayLessons#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayLessons extends Fragment  implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "examino";


    // TODO: Rename and change types of parameters
    private ArrayList<String> examino;


    private RecyclerView recyclerView;
    private LessonAdapter lessonAdapter;
    private ArrayList<LessonItem> lessonItems = new ArrayList<>();

    private TextView examinoTextView;



    public DisplayLessons() {
        // Required empty public constructor
    }
    public DisplayLessons(ArrayList<LessonItem> lessonItems) {
        this.lessonItems = lessonItems;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param1 Parameter 2.
     * @return A new instance of fragment Display.
     */
    // TODO: Rename and change types and number of parameters
    public static DisplayLessons newInstance(ArrayList<String> param1, ArrayList<LessonItem> lessonItems) {
        DisplayLessons fragment = new DisplayLessons(lessonItems);
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            examino = getArguments().getStringArrayList(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display_lessons, container, false);

        //
        //create the recyclerView
        //
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        examinoTextView = view.findViewById(R.id.examinoTextView);

        //
        //set the examino and the Adapter table
        //
        setTheAdapter(examino.get(0));
        examinoTextView.setText(examino.get(0));


        //
        //set the buttons
        //
        Button examino_1_button = view.findViewById(R.id.examino_1_Button);
        Button examino_2_button = view.findViewById(R.id.examino_2_Button);
        Button examino_3_button = view.findViewById(R.id.examino_3_Button);
        Button examino_4_button = view.findViewById(R.id.examino_4_Button);
        Button examino_5_button = view.findViewById(R.id.examino_5_Button);
        Button examino_6_button = view.findViewById(R.id.examino_6_Button);
        Button examino_7_button = view.findViewById(R.id.examino_7_Button);
        Button examino_8_button = view.findViewById(R.id.examino_8_Button);
        Button examino_9_button = view.findViewById(R.id.examino_9_Button);
        Button examino_10_button = view.findViewById(R.id.examino_10_Button);

        examino_1_button.setOnClickListener(this::onClick);
        examino_2_button.setOnClickListener(this::onClick);
        examino_3_button.setOnClickListener(this::onClick);
        examino_4_button.setOnClickListener(this::onClick);
        examino_5_button.setOnClickListener(this::onClick);
        examino_6_button.setOnClickListener(this::onClick);
        examino_7_button.setOnClickListener(this::onClick);
        examino_8_button.setOnClickListener(this::onClick);
        examino_9_button.setOnClickListener(this::onClick);
        examino_10_button.setOnClickListener(this::onClick);



        return view;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.examino_1_Button :
                setTheAdapter(examino.get(0));
                examinoTextView.setText(examino.get(0));
                break;
            case R.id.examino_2_Button :
                setTheAdapter(examino.get(1));
                examinoTextView.setText(examino.get(1));
                break;
            case R.id.examino_3_Button :
                setTheAdapter(examino.get(2));
                examinoTextView.setText(examino.get(2));
                break;
            case R.id.examino_4_Button :
                setTheAdapter(examino.get(3));
                examinoTextView.setText(examino.get(3));
                break;
            case R.id.examino_5_Button :
                setTheAdapter(examino.get(4));
                examinoTextView.setText(examino.get(4));
                break;
            case R.id.examino_6_Button :
                setTheAdapter(examino.get(5));
                examinoTextView.setText(examino.get(5));
                break;
            case R.id.examino_7_Button :
                setTheAdapter(examino.get(6));
                examinoTextView.setText(examino.get(6));
                break;
            case R.id.examino_8_Button :
                setTheAdapter(examino.get(7));
                examinoTextView.setText(examino.get(7));
                break;
            case R.id.examino_9_Button :
                setTheAdapter(examino.get(8));
                examinoTextView.setText(examino.get(8));
                break;
            case R.id.examino_10_Button :
                setTheAdapter(examino.get(9));
                examinoTextView.setText(examino.get(9));
                break;

        }

    }


    /**
     * Δημιουργια lesson adapter αναλογα με το click που γινεται στο button Εξάμηνο
     * @param currentExamino
     */
    public void setTheAdapter(String currentExamino) {
        ArrayList<LessonItem> currentItems = new ArrayList<>();

        for (LessonItem lessonItem : lessonItems) {
            if (lessonItem.getExamino().equals(currentExamino)) {

                currentItems.add(lessonItem);

            }
        }

        //
        //put the ArrayList to the adapter
        //
        lessonAdapter = new LessonAdapter(currentItems, this.getContext());

        recyclerView.setAdapter(lessonAdapter);
        
    }
}