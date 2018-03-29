package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usr.User;
import com.usrdo.UserDo;

public class RegServlet extends HttpServlet{
	private static final long serialVersionUID = 5280356329609002908L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			UserDo userDo = new UserDo();
						
			if(username != null && !username.isEmpty()){
				if(userDo.userIsExist(username)){
					User user = new User();
					
					user.setUsername(username);
					user.setPassword(password);
					
					userDo.saveUser(user);
					request.setAttribute("info", "Congratulation, register successfully");
					
				}else{
					request.setAttribute("info", "ERROR: this username exists");
				}
				
			}
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
}