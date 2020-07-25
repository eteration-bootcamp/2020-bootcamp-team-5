package com.team5.Noteapp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.team5.Noteapp.Entity.HashCode;

@Repository
public interface HashCodeRepository extends CrudRepository<HashCode, Integer>{
	@Query("SELECT HashCode FROM HashCode AS HashCode WHERE code = ?1")
	Optional<HashCode> findByHashCode(String code);
	
	@Query("DELETE FROM HashCode AS HasHCode WHERE userId = ?1")
	void deleteHashCode(int userId);
}