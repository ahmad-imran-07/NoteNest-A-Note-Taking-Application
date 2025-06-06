package com.muhammadahmad.notenest.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.muhammadahmad.notenest.data.Note
import com.muhammadahmad.notenest.R

class NoteAdapter(
    private val onClick: (Note) -> Unit,
    private val onLongClick: (Note) -> Unit  // new long press callback
) : ListAdapter<Note, NoteAdapter.NoteViewHolder>(DiffCallback()) {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.textViewNoteTitle)
        val description = itemView.findViewById<TextView>(R.id.textViewNoteDescription)
    }

    class DiffCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(old: Note, new: Note) = old.id == new.id
        override fun areContentsTheSame(old: Note, new: Note) = old == new
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = getItem(position)
        holder.title.text = note.title
        holder.description.text = note.description

        holder.itemView.setOnClickListener { onClick(note) }

        holder.itemView.setOnLongClickListener {
            onLongClick(note)
            true
        }
    }
}
