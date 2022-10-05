package com.arrazyfathan.simplenotes.android.notelist

import com.arrazyfathan.simplenotes.domain.note.Note

/**
 * Created by Ar Razy Fathan Rabbani on 05/10/22.
 */

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val isSearchActive: Boolean = false
)