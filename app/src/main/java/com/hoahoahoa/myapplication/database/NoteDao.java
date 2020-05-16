package com.hoahoahoa.myapplication.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {
    @Query("insert into notes(contents) values ('ghi chú')")
    void create();

    @Query("select * from notes")
    List<Note> getNotes();
}
