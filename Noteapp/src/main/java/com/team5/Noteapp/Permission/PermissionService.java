package com.team5.Noteapp.Permission;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {
	@Autowired
	private PermissionRepository permissionRepository;
	
	public Optional<Permission> findPermission(int userId, int noteId, String permission){
		return permissionRepository.findPermission(userId, noteId, permission);
	}
}	
