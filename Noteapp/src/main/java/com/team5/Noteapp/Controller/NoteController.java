package com.team5.Noteapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team5.Noteapp.Entity.Note;
import com.team5.Noteapp.Filter.AddPermissionFilter;
import com.team5.Noteapp.Service.NoteService;

@RestController
public class NoteController {
	
	@Autowired									 
	private NoteService noteService;				 
	
	@GetMapping("/notes/all")
	public List<Note> getAllNotes() {
		return noteService.getAllNotes();
	}
	
	@AddPermissionFilter(permissions = "read")
	@GetMapping("/notes/{id}")
	public Note getNoteById(@PathVariable int id) {
		return noteService.getNoteById(id);
	}
	
	@PostMapping("/notes/add")
	public void addNote(@RequestBody Note note) {
		noteService.addNote(note);
	}
	
	@AddPermissionFilter(permissions = "write")
	@PutMapping("/notes/edit/{id}")
	public void editNote(@RequestBody Note note,@PathVariable int id) {
		noteService.editNote(note, id);
	}
	
	@AddPermissionFilter(permissions = {"write","read"})
	@DeleteMapping("/notes/delete/{id}")
	public void deleteNote(@PathVariable Integer id) {
		noteService.deleteNote(id);
	}
	
}
