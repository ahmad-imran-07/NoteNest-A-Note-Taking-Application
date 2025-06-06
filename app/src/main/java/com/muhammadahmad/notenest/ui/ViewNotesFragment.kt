package com.muhammadahmad.notenest.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muhammadahmad.notenest.R
import com.muhammadahmad.notenest.data.Note
import com.muhammadahmad.notenest.viewmodel.NoteViewModel

class ViewNotesFragment : Fragment() {
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.activity_view_notes_fragment, container, false)

        val buttonAdd = view.findViewById<View>(R.id.buttonAdd)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewNotes)

        adapter = NoteAdapter(
            onClick = { note ->
                val intent = Intent(requireContext(), NoteDetailActivity::class.java)
                intent.putExtra("title", note.title)
                intent.putExtra("description", note.description)
                startActivity(intent)
            },
            onLongClick = { note ->
                // Show delete confirmation dialog
                showDeleteDialog(note)
            }
        )

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        noteViewModel = ViewModelProvider(requireActivity())[NoteViewModel::class.java]
        noteViewModel.allNotes.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        buttonAdd.setOnClickListener {
            val fragment = AddNoteFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }

    private fun showDeleteDialog(note: Note) {
        val builder = androidx.appcompat.app.AlertDialog.Builder(requireContext())
        builder.setTitle("Delete Note")
        builder.setMessage("Are you sure you want to delete this note?")
        builder.setPositiveButton("Delete") { _, _ ->
            noteViewModel.delete(note)
        }
        builder.setNegativeButton("Cancel", null)
        builder.show()
    }
}
