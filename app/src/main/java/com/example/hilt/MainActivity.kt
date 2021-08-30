package com.example.hilt

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val noteViewModel : NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.save_btn).setOnClickListener {
            noteViewModel.saveNote(
                title = findViewById<EditText>(R.id.note_title).text.toString(),
                description = findViewById<EditText>(R.id.note_description).text.toString()
            )
        }

        noteViewModel.note.observe(this, {
            findViewById<EditText>(R.id.note_title).setText(it.title)
            findViewById<EditText>(R.id.note_description).setText(it.description)
        })
    }
}