package com.example.notekeeper18;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button addNoteBtn, viewNotesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNoteBtn = findViewById(R.id.btnAddNote);
        viewNotesBtn = findViewById(R.id.btnViewNotes);

        addNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Add Note Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        viewNotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "View Notes Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}