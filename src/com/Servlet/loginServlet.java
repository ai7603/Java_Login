package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usr.User;
import com.usrdo.UserDo;

public class loginServlet extends HttpServlet{
	private static final long serialVersionUID = -3009431503363456775L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDo userDo = new UserDo();
		
		User user = userDo.login(username, password);
		
		if(user != null){
			request.getSession().setAttribute("user", user);
			
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}else{
			request.setAttribute("info", "ERROR:USERNAME OR PASSWORD WRONG");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}
}