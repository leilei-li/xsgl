package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.fapiaoBean;
import com.model.fapiaoBeanOP;

public class fapiao_info_delete extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String fapiao_ID=request.getParameter("fapiao_ID");
		fapiao_ID=new String(fapiao_ID.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		
		
		boolean ub=false;
		fapiaoBeanOP ubb=new fapiaoBeanOP();
		ub=ubb.fapiao_delete(fapiao_ID);
		
		if(ub==false){
			System.out.println("没存进去");
			request.getRequestDispatcher("OP_fail.jsp").forward(request, response);
		}
		else{
			//request.getSession().setAttribute("userBean", ub);
			
			
			request.getRequestDispatcher("OP_success.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
