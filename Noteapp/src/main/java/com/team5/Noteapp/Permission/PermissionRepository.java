package com.team5.Noteapp.Permission;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PermissionRepository extends CrudRepository<Permission, Integer> {
	@Query("SELECT Permission FROM Permission AS Permission WHERE userId = ?1 AND noteId = ?2 AND role = ?3")
	Optional<Permission> findPermission(int userId, int noteId, String permission);
}
