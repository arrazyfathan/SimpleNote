package com.arrazyfathan.simplenotes.domain.note

/**
 * Created by Ar Razy Fathan Rabbani on 05/10/22.
 */
interface NoteDataSource {
    suspend fun insertNote(note: Note)
    suspend fun getNoteById(id: Long): Note?
    suspend fun getAllNotes(): List<Note>
    suspend fun deleteNoteById(id: Long)
}