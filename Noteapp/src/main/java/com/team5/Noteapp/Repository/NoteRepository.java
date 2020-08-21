package com.team5.Noteapp.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.team5.Noteapp.Entity.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note,Integer> {

}
