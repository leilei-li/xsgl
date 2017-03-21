package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.cusBean;
import com.model.cusBeanOP;

public class cus_info_delete extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String cus_ID=request.getParameter("cus_ID");
		cus_ID=new String(cus_ID.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		cusBeanOP ubb=new cusBeanOP();
		cusBean ub=null;
		
			if(ubb.cus_delete(cus_ID)){
				
				request.getRequestDispatcher("OP_success.jsp").forward(request, response);
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
