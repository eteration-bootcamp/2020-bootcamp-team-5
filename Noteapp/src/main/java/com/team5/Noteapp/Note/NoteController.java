package com.team5.Noteapp.Note;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {
	
	@Autowired									 
	private NoteService noteService;				 
	
	@GetMapping("/notes/all")
	public List<Note> getAllNotes() {
		return noteService.getAllNotes();
	}
	
	@GetMapping("/notes/{id}")
	public Note getNoteById(@PathVariable int id) {
		return noteService.getNoteById(id);
	}
	
	@PostMapping("/notes/add")
	public void addNote(@RequestBody Note note) {
		noteService.addNote(note);
	}
	
	@PutMapping("/notes/edit/{id}")
	public void editNote(@RequestBody Note note,@PathVariable int id) {
		noteService.editNote(note, id);
	}
	
	@DeleteMapping("/notes/delete/{id}")
	public void deleteNote(@PathVariable Integer id) {
		noteService.deleteNote(id);
	}
	
}
