package com.hoahoahoa.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hoahoahoa.myapplication.MainActivity;
import com.hoahoahoa.myapplication.R;
import com.hoahoahoa.myapplication.database.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    public static class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        NoteViewHolder(View v){
            super(v);
            textView = v.findViewById(R.id.text);
        }
    }


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row, parent, false);
        return new NoteViewHolder(v);
    }

    private List<Note> notes = new ArrayList<>();
    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.textView.setText(note.contents);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void reload(){
       notes = MainActivity.database.noteDao().getNotes();
       notifyDataSetChanged();
    }
}
