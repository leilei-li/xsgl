package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.userBean;
import com.model.userBeanOP;
import com.model.cusBean;
import com.model.cusBeanOP;

public class user_password_modify extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String userName=request.getParameter("username");
		userName=new String(userName.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		String password=request.getParameter("password1");
		password=new String(password.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		//System.out.println(password);
		boolean ub=false;
		userBeanOP ubb=new userBeanOP();
		ub=ubb.usermodify(userName,password);
		String quanxian;
		int type;
		if(ub==false){
			//System.out.println("2222");
			request.getRequestDispatcher("login_fail.jsp").forward(request, response);
		}
		else{
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
