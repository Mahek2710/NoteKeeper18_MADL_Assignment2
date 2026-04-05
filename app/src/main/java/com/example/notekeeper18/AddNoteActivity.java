package com.example.notekeeper18;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {

    EditText titleInput, descInput;
    Button selectImageBtn, saveNoteBtn;
    ImageView imagePreview;

    Uri imageUri;
    private static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        titleInput = findViewById(R.id.etTitle);
        descInput = findViewById(R.id.etDescription);
        selectImageBtn = findViewById(R.id.btnSelectImage);
        saveNoteBtn = findViewById(R.id.btnSaveNote);
        imagePreview = findViewById(R.id.imagePreview);

        // Select Image from Gallery
        selectImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE);
            }
        });

        // Save Note
        saveNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = titleInput.getText().toString();
                String desc = descInput.getText().toString();

                if (title.isEmpty() || desc.isEmpty()) {
                    Toast.makeText(AddNoteActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Dummy save logic (for assignment purpose)
                    Toast.makeText(AddNoteActivity.this, "Note Saved Successfully", Toast.LENGTH_SHORT).show();

                    finish(); // go back
                }
            }
        });
    }

    // Handle Image Result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            imagePreview.setImageURI(imageUri);
        }
    }
}