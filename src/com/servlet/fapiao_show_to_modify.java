package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.fapiaoBean;
import com.model.fapiaoBeanOP;

public class fapiao_show_to_modify extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		

		fapiaoBeanOP ubb=new fapiaoBeanOP();
		fapiaoBean ub=null;
		ArrayList<fapiaoBean> al=null;
		
	    String fapiao_ID=request.getParameter("fapiao_ID");
			al=ubb.getfapiao_fapiao_ID(fapiao_ID);
			if(al.size()>0){
				request.setAttribute("fapiaoArray", al);
				request.setAttribute("cusInfo", ub);
				request.getRequestDispatcher("fapiao_modify.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("OP_fail.jsp").forward(request, response);
			}
			
		
		

		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
