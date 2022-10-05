package com.arrazyfathan.simplenotes.android.di

import android.app.Application
import com.arrazyfathan.simplenotes.data.local.DatabaseDriverFactory
import com.arrazyfathan.simplenotes.data.note.SqlDelightNoteDataSource
import com.arrazyfathan.simplenotes.database.NoteDatabase
import com.arrazyfathan.simplenotes.domain.note.NoteDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Ar Razy Fathan Rabbani on 05/10/22.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideNoteDataSource(driver: SqlDriver): NoteDataSource {
        return SqlDelightNoteDataSource(NoteDatabase(driver))
    }
}