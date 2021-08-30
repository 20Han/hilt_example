package com.example.hilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository
): ViewModel() {
    private val _note = MutableLiveData<Note>()
    val note : LiveData<Note>
        get() = _note


    init {
        viewModelScope.launch {
            _note.value = repository.getNote()
        }
    }

    fun saveNote(title : String, description : String){
        _note.value?.title = title
        _note.value?.description = description
        viewModelScope.launch {
            _note.value?.let { repository.saveNote(it) }
        }
    }
}