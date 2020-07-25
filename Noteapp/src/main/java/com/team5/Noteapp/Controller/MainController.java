package com.team5.Noteapp.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team5.Noteapp.Entity.HashCode;
import com.team5.Noteapp.Entity.Note;
import com.team5.Noteapp.Entity.Permission;
import com.team5.Noteapp.Entity.User;
import com.team5.Noteapp.Repository.HashCodeRepository;
import com.team5.Noteapp.Repository.NoteRepository;
import com.team5.Noteapp.Repository.PermissionRepository;
import com.team5.Noteapp.Repository.UserRepository;

@RestController
public class MainController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	private PermissionRepository permissionRepository;
	@Autowired
	private HashCodeRepository hashCodeRepository;
	
	@PutMapping("/create")
	public void createDB() {
		User user = new User();
		Note note = new Note();
		Note note2 = new Note();
		Permission permission = new Permission();
		Permission permission2 = new Permission();
		Permission permission3 = new Permission();
		HashCode hashCode = new HashCode();
		
		user.setMail("noteration@gmail.com");
		user.setPhoneNumber("00000000000");
		user.setName("Team5");
		user.setSurname("team5");
		user.setUserInfoId(1);
		
		note.setTitle("1");
		note.setContent("1");
		note.setUserId(1);
		
		note2.setTitle("1");
		note2.setContent("1");
		note2.setUserId(1);
		
		permission.setNoteId(1);
		permission.setUserId(1);
		permission.setRole("read");
		
		permission2.setNoteId(2);
		permission2.setUserId(1);
		permission2.setRole("read");
		
		permission3.setNoteId(2);
		permission3.setUserId(1);
		permission3.setRole("write");
		
		hashCode.setCode("123");
		hashCode.setExDate(new Date(System.currentTimeMillis() + 999999999));
		hashCode.setType("Login");
		hashCode.setUserId(1);
		
		userRepository.save(user);
		noteRepository.save(note);
		noteRepository.save(note2);
		permissionRepository.save(permission);
		permissionRepository.save(permission2);
		permissionRepository.save(permission3);
		hashCodeRepository.save(hashCode);
	}
}
