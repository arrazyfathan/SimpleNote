package com.arrazyfathan.simplenotes.data.local

import com.squareup.sqldelight.db.SqlDriver

/**
 * Created by Ar Razy Fathan Rabbani on 05/10/22.
 */
expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}