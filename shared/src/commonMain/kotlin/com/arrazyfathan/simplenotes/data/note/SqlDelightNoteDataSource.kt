package com.arrazyfathan.simplenotes.data.note

import com.arrazyfathan.simplenotes.database.NoteDatabase
import com.arrazyfathan.simplenotes.domain.note.Note
import com.arrazyfathan.simplenotes.domain.note.NoteDataSource
import com.arrazyfathan.simplenotes.domain.time.DateTimeUtil

/**
 * Created by Ar Razy Fathan Rabbani on 05/10/22.
 */
class SqlDelightNoteDataSource(db: NoteDatabase) : NoteDataSource {

    private val queries = db.noteQueries

    override suspend fun insertNote(note: Note) {
        queries.insertNote(
            id = note.id,
            title = note.title,
            content = note.content,
            colorHex = note.colorHex,
            created = DateTimeUtil.toEpocMillis(note.createdAt)
        )
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries
            .getById(id)
            .executeAsOneOrNull()
            ?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries.getAllNote().executeAsList().map { it.toNote() }
    }

    override suspend fun deleteNoteById(id: Long) {
        queries.deleteById(id)
    }
}
