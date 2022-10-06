package com.arrazyfathan.simplenotes.android.notedetail

import androidx.compose.ui.graphics.Color

/**
 * Created by Ar Razy Fathan Rabbani on 05/10/22.
 */
data class NoteDetailState(
    val noteTitle: String = "",
    val isNoteTitleHintVisible: Boolean = false,
    val noteContent: String = "",
    val isNoteContentHintVisible: Boolean = false,
    val noteColor: Long = 0xFFFFFF
)