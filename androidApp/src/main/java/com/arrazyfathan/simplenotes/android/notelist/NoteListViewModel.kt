package com.arrazyfathan.simplenotes.android.notelist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arrazyfathan.simplenotes.domain.note.Note
import com.arrazyfathan.simplenotes.domain.note.NoteDataSource
import com.arrazyfathan.simplenotes.domain.note.SearchNotes
import com.arrazyfathan.simplenotes.domain.time.DateTimeUtil
import com.arrazyfathan.simplenotes.presentation.RedOrangeHex
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Ar Razy Fathan Rabbani on 05/10/22.
 */

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val noteDataSource: NoteDataSource,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val searchNote = SearchNotes()

    private val note = savedStateHandle.getStateFlow("notes", emptyList<Note>())
    private val searchText = savedStateHandle.getStateFlow("searchText", "")
    private val isSearchActive = savedStateHandle.getStateFlow("isSearchActive", false)

    val state = combine(note, searchText, isSearchActive) { notes, searchText, isSearchActive ->
        NoteListState(
            notes = searchNote.execute(notes, searchText),
            searchText = searchText,
            isSearchActive = isSearchActive
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NoteListState())

    init {
        viewModelScope.launch {
            (1..10).forEach { index ->
                noteDataSource.insertNote(
                    Note(
                        null,
                        "Note test $index",
                        "Content note $index",
                        RedOrangeHex,
                        DateTimeUtil.now()
                    )
                )
            }
        }
    }

    fun loadAllNotes() {
        viewModelScope.launch {
            savedStateHandle["notes"] = noteDataSource.getAllNotes()
        }
    }

    fun onSearchTextChange(text: String) {
        savedStateHandle["searchText"] = text
    }

    fun onToggleSearch() {
        savedStateHandle["isSearchActive"] = !isSearchActive.value
        if (!isSearchActive.value) {
            savedStateHandle["searchText"] = ""
        }
    }

    fun deleteNoteById(id: Long) {
        viewModelScope.launch {
            noteDataSource.deleteNoteById(id)
            loadAllNotes()
        }
    }
}
