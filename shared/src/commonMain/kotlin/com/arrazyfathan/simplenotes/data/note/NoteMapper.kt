package com.arrazyfathan.simplenotes.data.note

import com.arrazyfathan.simplenotes.domain.note.Note
import database.NoteEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

/**
 * Created by Ar Razy Fathan Rabbani on 05/10/22.
 */

fun NoteEntity.toNote(): Note {
    return Note(
        id = id,
        title = title,
        content = content,
        colorHex = colorHex,
        createdAt = Instant.fromEpochSeconds(created)
            .toLocalDateTime(TimeZone.currentSystemDefault())
    )
}
