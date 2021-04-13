package com.example.ptyxiakh;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link About_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class About_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "htmlText";
    private static final String ARG_PARAM2 = "imgUrl";

    // TODO: Rename and change types of parameters
    private ArrayList<String> htmlText;
    private ArrayList<String> imgUrl;

    public About_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment About_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static About_fragment newInstance(ArrayList<String> param1, ArrayList<String> param2) {
        final About_fragment fragment = new About_fragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_PARAM1, param1);
        args.putStringArrayList(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            htmlText = getArguments().getStringArrayList(ARG_PARAM1);
            imgUrl = getArguments().getStringArrayList(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_fragment, container, false);

        ImageView imageView = view.findViewById(R.id.imageView_aboutus);
        TextView textView = view.findViewById(R.id.textView_aboutus);

        ImageView imageView2 = view.findViewById(R.id.imageView_aboutus2);
        TextView textView2 = view.findViewById(R.id.textView_aboutus2);

        TextView textView3 = view.findViewById(R.id.textView_aboutus3);

        TextView textView4 = view.findViewById(R.id.textView_aboutus4);

        Glide.with(view).load(imgUrl.get(0)).into(imageView);
        textView.setText(htmlText.get(0));

        Glide.with(view).load(imgUrl.get(1)).into(imageView2);
        textView2.setText(htmlText.get(1));

        textView3.setText(htmlText.get(2));

        textView4.setText(htmlText.get(3));

        return view;
    }
}