package com.team5.Noteapp.Util;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.team5.Noteapp.Entity.HashCode;
import com.team5.Noteapp.Entity.User;
import com.team5.Noteapp.Filter.AddPermissionFilter;
import com.team5.Noteapp.Filter.PermissionFilter;
import com.team5.Noteapp.Service.HashCodeService;
import com.team5.Noteapp.Service.UserService;


public class AuthInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	private PermissionFilter permissionFilter;
	
	@Autowired
	private HashCodeService hashCodeService;
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		String auth = request.getHeader("auth");
		Optional<HashCode> hashCodeOptional = hashCodeService.getLoginHash(auth);
		if(!hashCodeOptional.isPresent()) {
			response.setStatus(401);
			return false;
		}

		
    	if(System.currentTimeMillis() > hashCodeOptional.get().getExDate().getTime()){
			response.setStatus(401);
			return false;
		}
    	
    	
    	User user = userService.getUserById(hashCodeOptional.get().getUserId());
    	request.setAttribute("user", user);
    
    	
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		AddPermissionFilter annotation = method.getAnnotation(AddPermissionFilter.class);
		if(annotation != null) {
			Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
			for(String permission : annotation.permissions())
				if(!permissionFilter.filter(user.getId(), Integer.valueOf(pathVariables.get("id")), permission)) {
					response.setStatus(403);
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
