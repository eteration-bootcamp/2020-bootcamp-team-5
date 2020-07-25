package com.team5.Noteapp.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import com.team5.Noteapp.Entity.Permission;
import com.team5.Noteapp.Entity.UserInfo;
import com.team5.Noteapp.Repository.PermissionRepository;
import com.team5.Noteapp.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.Noteapp.Entity.Note;
import com.team5.Noteapp.Repository.NoteRepository;

@Service
public class NoteService {
	
	@Autowired
	private NoteRepository noteRepository;

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public List<Note> getAllNotes(Integer userId) {
		List <Note> notes = new ArrayList<Note>();
		
		permissionRepository.findAll().forEach(permission -> {
			
			System.out.println(permission.getRole() + " - " + permission.getUserId() + " - " + userId.toString());
			
			if(permission.getRole().equals("read") && permission.getUserId() == userId) {
				Optional <Note> note = noteRepository.findById(permission.getNoteId());
				
				if (note.isPresent()) 
					notes.add(note.get());	
			}
		});
		
		return notes;
	}
	
	public Note getNoteById(Integer id) {
		return noteRepository.findById(id).get();
	}

	public void addNote(Note note, int userId) {
		noteRepository.save(note);
		
		Permission permission = new Permission();
		permission.setNoteId(note.getId());
		permission.setUserId(userId);
		permission.setRole("read");
		permissionRepository.save(permission);
		
		Permission permission2 = new Permission();
		permission2.setNoteId(note.getId());
		permission2.setUserId(userId);
		permission2.setRole("write");
		permissionRepository.save(permission2);
		
		Permission permission3 = new Permission();
		permission3.setNoteId(note.getId());
		permission3.setUserId(userId);
		permission3.setRole("owner");
		permissionRepository.save(permission3);
	}

	public void editNote(Note note,int id) {
		if(note.getId() == id)				
			noteRepository.save(note);
	}

	public void deleteNote(Integer id) {
		noteRepository.deleteById(id);
	}

	public void shareNote(int noteId, String userId, int role){
		Optional<UserInfo> userInfoOptional = userInfoRepository.findByUsername(userId);
		if (userInfoOptional.isPresent()){
			Permission permission = new Permission();
			permission.setNoteId(noteId);
			permission.setUserId(userInfoOptional.get().getId());
			if (role == 0){
				permission.setRole("read");
				permissionRepository.save(permission);
			}
			else if (role == 1){
				permission.setRole("write");
				permissionRepository.save(permission);
			}
			else if (role == 2){
				Permission permission2 = new Permission();
				permission2.setNoteId(noteId);
				permission2.setUserId(userInfoOptional.get().getId());
				permission2.setRole("read");
				permissionRepository.save(permission2);
				permission.setRole("write");
				permissionRepository.save(permission);
			}
			else throw new IllegalArgumentException();
		}
	}
}
