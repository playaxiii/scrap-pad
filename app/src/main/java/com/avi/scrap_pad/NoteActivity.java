package com.avi.scrap_pad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class NoteActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    FloatingActionButton createnotesfab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        firebaseAuth = FirebaseAuth.getInstance();
        createnotesfab = findViewById(R.id.btnFloat);

        createnotesfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.logout) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(NoteActivity.this, CreateNote.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}