package com.team5.Noteapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.team5.Noteapp.Entity.Note;
import com.team5.Noteapp.Entity.User;
import com.team5.Noteapp.Filter.AddPermissionFilter;
import com.team5.Noteapp.Service.NoteService;

import javax.servlet.http.HttpServletResponse;

@RequestMapping("/notes")
@RestController
@CrossOrigin
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/all")
    public List<Note> getAllNotes(@RequestAttribute User user) {
        return noteService.getAllNotes(user.getId());
    }

    @AddPermissionFilter(permissions = "read")
    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable int id) {
        return noteService.getNoteById(id);
    }

    @PostMapping("/add")
    public void addNote(@RequestBody Note note, @RequestAttribute User user) {
        noteService.addNote(note, user.getId());
    }

    @AddPermissionFilter(permissions = "write")
    @PutMapping("/edit/{id}")
    public void editNote(@RequestBody Note note, @PathVariable int id) {
        noteService.editNote(note, id);
    }

    @AddPermissionFilter(permissions = {"owner"})
    @DeleteMapping("/delete/{id}")
    public void deleteNote(@PathVariable Integer id) {
        noteService.deleteNote(id);
    }

    @AddPermissionFilter(permissions = {"owner"})
    @PostMapping("/share/{id}/{userName}/{role}")
    public void shareNote(@PathVariable int id, @PathVariable String userName, @PathVariable int role, HttpServletResponse httpServletResponse) {
        try{
            noteService.shareNote(id, userName, role);
        }catch (Exception e){
            httpServletResponse.setStatus(400);
        }
    }
}