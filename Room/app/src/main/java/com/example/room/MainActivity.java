package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.room.Room.Note;
import com.example.room.Room.RoomDB;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);

        RoomDB notesDB = RoomDB.getInstance(this);

        /* Writing & Reading from Room */

        /*[1] No RXJava with Room */
        notesDB.dao().insertNote(new Note("Cristiano","Don"));
        tv.setText(notesDB.dao().getNote("Cristiano").getNoteContent());

        /*[2] RXJava with Room */
//        notesDB.dao().insertNote(new Note("Messi","GOAT"))
//                .subscribeOn(Schedulers.computation())
//                .subscribe(new CompletableObserver() {
//                    @Override
//                    public void onSubscribe(Disposable d) {}
//
//                    @Override
//                    public void onComplete() {
//                        Log.i("DONE","Addition is succesfull");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//                });
//
//        notesDB.dao().getNote("Messi")
//                .subscribeOn(Schedulers.computation())
//                .subscribe(new SingleObserver<Note>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(Note note) {
//                        tv.setText(note.getNoteContent());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//                });



    }

}