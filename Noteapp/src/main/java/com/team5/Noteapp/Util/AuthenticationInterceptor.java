package com.team5.Noteapp.Util;

import java.lang.reflect.Method;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.team5.Noteapp.Filter.AddPermissionFilter;
import com.team5.Noteapp.Filter.PermissionFilter;
import com.team5.Noteapp.HashCode.HashCode;
import com.team5.Noteapp.HashCode.HashCodeService;
import com.team5.Noteapp.Note.Note;
import com.team5.Noteapp.User.User;
import com.team5.Noteapp.User.UserService;


public class AuthenticationInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	private PermissionFilter permissionFilter;
	
	@Autowired
	private HashCodeService hashCodeService;
	
	@Autowired
	private UserService userService;
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		String auth = request.getHeader("auth");
		Optional<HashCode> hashCodeOptional = hashCodeService.getLoginHash(auth);
		User user = null;
		Note note;
		
		if(!hashCodeOptional.isPresent()) {
			response.setStatus(401);
			return false;
		}

		long nowMillis = System.currentTimeMillis();
    	long expirationMillis = hashCodeOptional.get().getExDate().getTime();
    	if(nowMillis > expirationMillis){
			response.setStatus(401);
			return false;
		}
    	user = 	userService.getUserById(hashCodeOptional.get().getUserId());
    	request.setAttribute("user", user);
    		
    		
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		AddPermissionFilter annotation = method.getAnnotation(AddPermissionFilter.class);
		if(annotation != null) {
			note = (Note) request.getAttribute("note");
			for(String permission : annotation.permissions())
				if(!permissionFilter.filter(user.getId(), note.getId(), permission)) {
					response.setStatus(401);
					return false;
				}
		}
		return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception
    {
    }
}
