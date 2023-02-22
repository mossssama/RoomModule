# RoomModule
Android Room database Module in Java language + Single Screen App to test

# **Usage** 
***
[1] **Add the following dependencies to build.gradle(ProjectModule)** 

	/* Room dependencies */
    def roomVersion="2.2.5"
    implementation "androidx.room:room-runtime:$roomVersion"
    annotationProcessor "androidx.room:room-compiler:$roomVersion"

	/* INCASE OF USING RXJAVA */
	/* RXJava dependencies */
    def rxJavaVersion="2.1.1"
    implementation "io.reactivex.rxjava2:rxandroid:$rxJavaVersion"
    implementation "io.reactivex.rxjava2:rxjava:$rxJavaVersion"
    /* RXJava + Room depdencies */
    implementation "androidx.room:room-rxjava2:$roomVersion"
***
[2] **Put [RoomDB class](https://github.com/mossssama/RoomModule/blob/main/Room/app/src/main/java/com/example/room/Room/RoomDB.java) in your app folder (update DATABASE_NAME)**
***
[3] **Create POJO class [like this](https://github.com/mossssama/RoomModule/blob/main/Room/app/src/main/java/com/example/room/Room/Note.java) representing a row/item in a table in your database**
***
[4] **Put [Dao interface](https://github.com/mossssama/RoomModule/blob/main/Room/app/src/main/java/com/example/room/Room/Dao.java) in your app folder (update the SQL queries & the method's names/return types by your POJO)**
***
[5] **Copy the following code where you want to make use RoomDB**

      RoomDB notesDB = RoomDB.getInstance(this);

        /* Writing & Reading from Room */

        /*[1] No RXJava with Room */
        notesDB.dao().insertNote(new Note("Cristiano","Don"));
        tv.setText(notesDB.dao().getNote("Cristiano").getNoteContent());

        /*[2] RXJava with Room */
    //  notesDB.dao().insertNote(new Note("Messi","GOAT"))
    //            .subscribeOn(Schedulers.computation())
    //            .subscribe(new CompletableObserver() {
    //                @Override
    //                public void onSubscribe(Disposable d) {}
    //
    //                @Override
    //                 public void onComplete() {
    //                     Log.i("DONE","Addition is succesfull");
    //                }
    //
    //                @Override
    //                public void onError(Throwable e) {
    //
    //                }
    //            });
    //
    //   notesDB.dao().getNote("Messi")
    //            .subscribeOn(Schedulers.computation())
    //            .subscribe(new SingleObserver<Note>() {
    //                @Override
    //                public void onSubscribe(Disposable d) {
    //
    //                }
    //
    //                @Override
    //                public void onSuccess(Note note) {
    //                    tv.setText(note.getNoteContent());
    //                }
    //
    //                @Override
    //                public void onError(Throwable e) {
    //
    //                }
    //            });
