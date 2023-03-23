package com.example.noteapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note> noteLsit =new ArrayList<>();

   public void updateList(List<Note> newList){
        noteLsit = newList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View noteView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note,parent,false);
        return new NoteViewHolder(noteView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

        Note note = noteLsit.get(position);
        holder.titleTextView.setText(note.title);
        holder.bodyTextView.setText(note.body);

    }

    @Override
    public int getItemCount() {

       return noteLsit.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;
        TextView bodyTextView;

        public NoteViewHolder(View noteview){
            super(noteview);

            titleTextView = noteview.findViewById(R.id.titleoutput);
            bodyTextView = noteview.findViewById(R.id.descriptionoutput);

        }

    }

}

