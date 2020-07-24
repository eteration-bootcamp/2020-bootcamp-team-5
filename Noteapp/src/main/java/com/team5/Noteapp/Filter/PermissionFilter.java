package com.team5.Noteapp.Filter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.Noteapp.Permission.Permission;
import com.team5.Noteapp.Permission.PermissionService;

@Service
public class PermissionFilter {
	@Autowired
	private PermissionService permissionService;
	
	public boolean filter(int userId, int noteId, String permission) {
		Optional<Permission> permissionOptional = permissionService.findPermission(userId, noteId, permission);
		if(!permissionOptional.isPresent())
			return false;
		return true;
	}
}
