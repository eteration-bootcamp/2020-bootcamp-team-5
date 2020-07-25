package com.team5.Noteapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.team5.Noteapp.Entity.Note;
import com.team5.Noteapp.Filter.AddPermissionFilter;
import com.team5.Noteapp.Service.NoteService;

@RequestMapping("/notes")
@RestController
public class NoteController {

	@Autowired
	private NoteService noteService;

	@GetMapping("/all")
	public List<Note> getAllNotes() {
		return noteService.getAllNotes();
	}

	@AddPermissionFilter(permissions = "read")
	@GetMapping("/{id}")
	public Note getNoteById(@PathVariable int id) {
		return noteService.getNoteById(id);
	}

	@PostMapping("/add")
	public void addNote(@RequestBody Note note) {
		noteService.addNote(note);
	}

	@AddPermissionFilter(permissions = "write")
	@PutMapping("/edit/{id}")
	public void editNote(@RequestBody Note note, @PathVariable int id) {
		noteService.editNote(note, id);
	}

	@AddPermissionFilter(permissions = {"write", "read"})
	@DeleteMapping("/delete/{id}")
	public void deleteNote(@PathVariable Integer id) {
		noteService.deleteNote(id);
	}

	@AddPermissionFilter(permissions =  {"owner"})
	@PostMapping("/share/{noteId}/{userId}/{role}")
	public void shareNote(@PathVariable int noteId, @PathVariable int userId, @PathVariable int role) {
		noteService.shareNote(noteId, userId, role);
	}
}
