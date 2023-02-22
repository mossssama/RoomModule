package com.example.room.Room;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@androidx.room.Dao
public interface Dao {


/* Queries & Methods to read/write from Room */


/*[1] No RXJava with Room */
@Insert
void insertNote(Note note);
@Delete
void deleteNote(Note note);
@Query("DELETE FROM writtenNotes")
void deleteNodes();
@Query("SELECT * FROM writtenNotes")
List<Note> getNotes();
@Query("SELECT * FROM writtenNotes WHERE noteTitle=:title")
Note getNote(String title);


/*[2] RXJava with Room */
//@Insert
//Completable insertNote(Note note);
//@Delete
//Completable deleteNote(Note note);
//@Query("DELETE FROM writtenNotes")
//Completable deleteNodes();
//@Query("SELECT * FROM writtenNotes")
//Flowable<List<Note>> getNotes();
//@Query("SELECT * FROM writtenNotes WHERE noteTitle=:title")
//Single<Note> getNote(String title);

}
