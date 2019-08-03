package com.comtroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.LoginBO;
import com.model.User;

import dao.LoginDAO;
import exception.BusinessException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("login page");
		//System.out.println(request.getParameter("userid"));
		//System.out.println(request.getParameter("password"));
		//System.out.println(request.getParameter("role"));
		User user=new User();
		user.setUser_id(Integer.parseInt(request.getParameter("userid")));
		//System.out.println("111");
		user.setPassword(request.getParameter("password"));
		user.setRole(request.getParameter("role"));
		//LoginBO bo=new LoginBO();
		LoginDAO bo=new LoginDAO();
		RequestDispatcher rd=null;
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		try{
		if(bo.isValidUser(user))
		{
			rd=request.getRequestDispatcher("success");
			rd.forward(request, response);
		}
	}catch(Exception e)
		{
		rd=request.getRequestDispatcher("login.html");
		rd.include(request, response);
		out.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
		}
	}

}
