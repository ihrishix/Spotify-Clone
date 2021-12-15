package com.hrishi.spotifyclone.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.hrishi.spotifyclone.data.entities.Song
import com.hrishi.spotifyclone.other.constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs() : List<Song>{
        return try{
            songCollection.get().await().toObjects(Song::class.java)
        }catch (e : Exception){
            emptyList<Song>()
        }
    }
}