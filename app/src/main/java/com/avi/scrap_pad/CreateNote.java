package com.avi.scrap_pad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class CreateNote extends AppCompatActivity {

    TextView txtView;
    Button btnNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

//        getSupportActionBar().setTitle("This is create note page");
        txtView = findViewById(R.id.textView);
        btnNote = findViewById(R.id.btnNotePage);

        btnNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateNote.this, NoteActivity.class));
            }
        });

    }
}