package com.arrazyfathan.simplenotes.data.local

import android.content.Context
import com.arrazyfathan.simplenotes.database.NoteDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

/**
 * Created by Ar Razy Fathan Rabbani on 05/10/22.
 */
actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(NoteDatabase.Schema, context, "note.db")
    }
}