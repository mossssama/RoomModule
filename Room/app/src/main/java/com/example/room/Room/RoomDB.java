package com.example.room.Room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Note.class},version = 1)
public abstract class RoomDB extends RoomDatabase {

    private static RoomDB instance;
    public abstract Dao dao();
    private static String DATABASE_NAME ="notesDatabase";     /* Found in  com.example.ProjectName/data/data/database/databaseName  */

    /* Singleton Room */

    /*[1]No RXJava with Room */
    public static synchronized RoomDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, RoomDB.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    /*[2] RXJava with Room */
//    public static synchronized RoomDB getInstance(Context context) {
//        if (instance == null) {
//            instance = Room.databaseBuilder(context, RoomDB.class, DATABASE_NAME)
//                    .fallbackToDestructiveMigration()
//                    .build();
//        }
//        return instance;
//    }


    private static Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        PopulateDbAsyncTask(RoomDB instance) { Dao dao = instance.dao(); }

        @Override
        protected Void doInBackground(Void... voids) {  return null; }
    }

}
