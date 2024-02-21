package com.example.keepyournotes.data

import androidx.compose.runtime.MutableState
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao{

    @Query("Select * from NoteTable")
     fun getNotes(): Flow<List<note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertNote(note: note)

    @Delete
   suspend fun deleteNote(note: note)

//    @Query("Select * from note where id=:uid")
//   suspend fun getNoteById(uid: Int)

    @Query("Delete from NoteTable")
   suspend fun deleteAll()


}
