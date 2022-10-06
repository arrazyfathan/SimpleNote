package com.arrazyfathan.simplenotes.data.di

import com.arrazyfathan.simplenotes.data.local.DatabaseDriverFactory
import com.arrazyfathan.simplenotes.data.note.SqlDelightNoteDataSource
import com.arrazyfathan.simplenotes.database.NoteDatabase
import com.arrazyfathan.simplenotes.domain.note.NoteDataSource

/**
 * Created by Ar Razy Fathan Rabbani on 06/10/22.
 */
class DatabaseModule {

    private val factory by lazy { DatabaseDriverFactory() }
    val noteDataSource: NoteDataSource by lazy {
        SqlDelightNoteDataSource(
            NoteDatabase(
                factory.createDriver()
            )
        )
    }
}
