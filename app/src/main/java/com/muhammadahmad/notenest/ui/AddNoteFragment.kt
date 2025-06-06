package com.muhammadahmad.notenest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.muhammadahmad.notenest.R
import com.muhammadahmad.notenest.data.Note
import com.muhammadahmad.notenest.viewmodel.NoteViewModel

class AddNoteFragment : Fragment() {
    private lateinit var noteViewModel: NoteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.activity_add_note_fragment, container, false)
        val buttonClose = view.findViewById<ImageButton>(R.id.buttonClose)
        val buttonOptions = view.findViewById<ImageButton>(R.id.buttonOptions)
        val buttonAvatar = view.findViewById<ImageButton>(R.id.buttonAvator)
        val notesTextView = view.findViewById<TextView>(R.id.textViewTitle)
        buttonClose?.visibility = View.VISIBLE
        buttonOptions?.visibility = View.GONE
        buttonAvatar?.visibility = View.GONE
        notesTextView.text = "New Note"

        buttonClose?.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        noteViewModel = ViewModelProvider(requireActivity())[NoteViewModel::class.java]
        val titleInput = view.findViewById<EditText>(R.id.editTextTitle)
        val descInput = view.findViewById<EditText>(R.id.editTextDescription)
        val saveButton = view.findViewById<Button>(R.id.buttonSave)

        saveButton.setOnClickListener {
            val title = titleInput.text.toString().trim()
            val desc = descInput.text.toString().trim()

            if (title.isNotEmpty() && desc.isNotEmpty()) {
                val note = Note(title = title, description = desc)
                noteViewModel.insert(note)
                Toast.makeText(requireContext(), "Note saved!", Toast.LENGTH_SHORT).show()
                titleInput.text.clear()
                descInput.text.clear()
            } else {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}
