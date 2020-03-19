package com.yyjj.api.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class loginFilter implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//User user = (User) request.getSession().getAttribute("user");
//		if(Objects.isNull(request.getSession().getAttribute("user"))) {
//			response.sendRedirect("/repast/login.html");
//			return false;
//		}
		//System.out.println(user.getAccount());
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
