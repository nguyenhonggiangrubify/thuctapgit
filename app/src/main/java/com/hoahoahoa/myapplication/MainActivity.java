package com.hoahoahoa.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;

import com.hoahoahoa.myapplication.adapter.NoteAdapter;
import com.hoahoahoa.myapplication.database.NoteDatabase;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    NoteAdapter noteAdapter;

    public static NoteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //giai quyet conflict
        //tinh nang 1

        database = Room
                .databaseBuilder(getApplicationContext(), NoteDatabase.class, "notes")
                .allowMainThreadQueries().build();

        recyclerView = findViewById(R.id.recyclerview);
        linearLayoutManager = new LinearLayoutManager(this);

        noteAdapter = new NoteAdapter();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(noteAdapter);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.noteDao().create();
                noteAdapter.reload();
            }
        });
        noteAdapter.reload();
    }

    @Override
    protected void onResume() {
        super.onResume();
        database.noteDao().create();

    }
}
