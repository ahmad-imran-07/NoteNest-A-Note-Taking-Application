# NoteNest 📝

A simple and elegant Android note-taking app built with Kotlin, Fragments, Room Database, and Material Design. Developed as part of an academic assignment, NoteNest allows users to create, view, and manage notes with a user-friendly and responsive interface.

## 📌 Features

- Add a new note with title and description.
- View a list of all saved notes.
- Tap on a note to see its full details.
- Store notes locally using Room database (offline support).
- Clean and intuitive Material UI.

## 🚀 Technologies Used

- **Kotlin** - Modern language for Android development.
- **Fragments** - Used to build dynamic and modular UI.
- **Room Database** - Provides local data persistence.
- **RecyclerView** - Displays saved notes efficiently.
- **ConstraintLayout & Material Components** - For responsive and accessible UI.

## 📱 App Structure

### `MainActivity`
- Hosts `HomeScreenFragment`, the entry screen of the app.
- Enables navigation to:
  - `AddNoteFragment`
  - `ViewNotesFragment`
- Implements back press behavior to show an exit confirmation dialog.

### `AddNoteFragment`
- Contains input fields for:
  - Note Title
  - Note Description
- Save button performs:
  - Input validation
  - Local storage using Room

### `ViewNotesFragment`
- Displays saved notes in a vertical list using RecyclerView.
- Clicking a note opens `NoteDetailActivity`.
- Long press on a note prompts a delete confirmation dialog.

### `NoteDetailActivity`
- Displays the full title and description of the selected note.

## 🧩 Screens Summary

- **Home Screen**: Buttons for "Add Note" and "View Notes"
- **Add Note Screen**: Form with Title, Description, and Save button
- **View Notes Screen**: List of notes with long press delete functionality
- **Note Detail Screen**: Full details of a selected note

## 🌟 Bonus Features

- **Delete Note on Long Press**  
  Long press on any note in the list prompts a confirmation dialog and deletes the note upon confirmation.

- **Exit Confirmation Dialog**  
  Pressing the back button on the main screen shows a dialog to confirm app exit, preventing accidental closure.


## 📄 License

This project was created for educational purposes and is not affiliated with any official entity. Feel free to use or modify it for your own learning.

---

### Developer

**Muhammad Ahmad**  
Email: mahmad153131@gmail.com  
