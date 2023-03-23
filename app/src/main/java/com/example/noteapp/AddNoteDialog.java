package com.example.noteapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class AddNoteDialog extends Dialog {


    private saveOnClickLisener lisener =null;

    public AddNoteDialog(@NonNull Context context) {
        super(context);
    }

    private EditText titleEditText;
    private EditText badyEditText;
    private Button saveButton;
    private Button cancleButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note);

        init();
        Lisenery();


    }

    public void  init(){
        titleEditText = findViewById(R.id.titleinput);
        badyEditText= findViewById(R.id.descriptioninput);
        saveButton= findViewById(R.id.savebtn);
        cancleButton= findViewById(R.id.canclebtn);

    }


    public void  Lisenery(){


        saveButton.setOnClickListener(view -> {
            String title = titleEditText.getText().toString();
            String body = badyEditText.getText().toString();
            if (lisener != null){
                lisener.onclick(new Note(title,body));
            }

        });

        cancleButton.setOnClickListener(view1 -> {
            dismiss();
        });
    }


   public interface saveOnClickLisener{
        void onclick(Note note);
    }

    public  void setOnClickLisener(saveOnClickLisener lisener){
        this.lisener =lisener;

    }

}
