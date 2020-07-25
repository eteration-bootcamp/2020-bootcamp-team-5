package com.team5.Noteapp.Repository;

import org.springframework.data.repository.CrudRepository;

import com.team5.Noteapp.Entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
