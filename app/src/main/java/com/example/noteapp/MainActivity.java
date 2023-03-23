package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.noteapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RecyclerView recyclerView;
    private Button addbutton;

    private NoteAdapter noteAdapter =new NoteAdapter();
    private List<Note> notesLsit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        setLisener();


    }

    public void init(){
        recyclerView = binding.recyclerview;
        addbutton = binding.addnewnotebtn;
        recyclerView.setAdapter(noteAdapter);

    }

    private  void setLisener(){
        addbutton.setOnClickListener(view -> {
           AddNoteDialog dialog = new AddNoteDialog(this);
           dialog.show();
           dialog.setOnClickLisener(note -> {

               addNote(note);

           });


        });
    }



    public   void addNote (Note note){
       notesLsit.add(note);
       noteAdapter.updateList(notesLsit);
    }

}