package com.arrazyfathan.simplenotes.domain.note

import com.arrazyfathan.simplenotes.domain.time.DateTimeUtil

/**
 * Created by Ar Razy Fathan Rabbani on 05/10/22.
 */
class SearchNotes {

    fun execute(notes: List<Note>, queries: String): List<Note> {
        if (queries.isBlank()) {
            return notes
        }

        return notes.filter {
            it.title.trim().lowercase().contains(queries.lowercase()) ||
                it.content.trim().lowercase().contains(queries.lowercase())
        }.sortedBy {
            DateTimeUtil.toEpocMillis(it.createdAt)
        }
    }
}
