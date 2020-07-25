package com.team5.Noteapp.Service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.Noteapp.Entity.Note;
import com.team5.Noteapp.Repository.NoteRepository;

@Service
public class NoteService {
	
	@Autowired
	private NoteRepository noteRepository;
	
	public List<Note> getAllNotes() {
		List <Note> notes = new ArrayList<Note>();
		noteRepository.findAll().forEach(comingWithForEach -> notes.add(comingWithForEach));
		return notes;
	}
	
	public Note getNoteById(Integer id) {
		return noteRepository.findById(id).get();
	}

	public void addNote(Note note) {
		noteRepository.save(note);
	}

	public void editNote(Note note,int id) {
		if(note.getId() == id)				
			noteRepository.save(note);
	}

	public void deleteNote(Integer id) {
		noteRepository.deleteById(id);
	}
	
}
