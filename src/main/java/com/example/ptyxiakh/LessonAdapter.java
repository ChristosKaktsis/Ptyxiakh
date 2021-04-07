package com.example.ptyxiakh;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LessonAdapter extends  RecyclerView.Adapter<LessonAdapter.ViewHolder> implements View.OnClickListener {

    private ArrayList<LessonItem> lessonItems;
    private Context context;


    public LessonAdapter( ArrayList<LessonItem> lessonItems, Context context) {

        this.lessonItems = lessonItems;
        this.context = context;
    }

    @Override
    public void onClick(View v) {


        //
        //Call async from here
        //
        MainActivity.lessonID = ((TextView)v).getText().toString();
        ((MainActivity) context).callAsyncTask("GET_LESSON_INFO");

    }

    @NonNull
    @Override
    public LessonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonAdapter.ViewHolder holder, int position) {

        LessonItem lessonItem = lessonItems.get(position);

        holder.kodikos.setText(lessonItem.getKodikos());
        holder.titlos.setText(lessonItem.getTitlos());
        holder.eidos.setText(lessonItem.getEidos());
        holder.ergastirio.setText(lessonItem.getErgastirio());
        holder.theoria.setText(lessonItem.getTheoria());
        holder.ects.setText(lessonItem.getEcts());

        //
        //Βάλε σε κάθε TextView στο πίνακα ένα onClick event ώστε να καλείτε η μέθοδος που ανοίγει το frame για το info του κάθε μαθήματος
        //
        holder.kodikos.setOnClickListener(this::onClick);

    }

    @Override
    public int getItemCount() {
        return lessonItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView kodikos;
        TextView titlos;
        TextView eidos;
        TextView theoria;
        TextView ergastirio;
        TextView ects;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            kodikos = itemView.findViewById(R.id.kodikosTextView);
            titlos = itemView.findViewById(R.id.titlosTextView);
            eidos = itemView.findViewById(R.id.eidosTextView);
            theoria = itemView.findViewById(R.id.theoriaTextView);
            ergastirio = itemView.findViewById(R.id.ergastirioTextView);
            ects = itemView.findViewById(R.id.ectsTextView);


        }
    }

}
