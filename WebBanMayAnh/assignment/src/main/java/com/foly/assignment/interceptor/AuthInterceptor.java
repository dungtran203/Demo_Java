package com.foly.assignment.interceptor;
import com.foly.assignment.entity.Account;
import com.foly.assignment.service.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

@Service
public class AuthInterceptor implements HandlerInterceptor{
	@Autowired
	SessionService session;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		Account user = session.get("user");
		
		String error = "";
		if(user == null) {
			error = "Please login!";
		} else if(!user.isAdmin() && uri.startsWith("/admin/")) {
			error = "Access denied!";
		}
		if(error.length() > 0) {
			session.set("security-uri", uri);
			response.sendRedirect("/login?error=" + error);
			return false;
		}
		return true;
	}
}