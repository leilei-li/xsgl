package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.salesBean;
import com.model.salesBeanOP;

public class sales_show_to_modify extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		

		salesBeanOP ubb=new salesBeanOP();
		salesBean ub=null;
		ArrayList<salesBean> al=null;
		
	    String sales_ID=request.getParameter("sales_ID");
	    System.out.println(sales_ID);
			al=ubb.getSales_sales_ID(sales_ID);
			if(al.size()>0){
				request.setAttribute("salesArray", al);
				request.setAttribute("salesInfo", ub);
				request.getRequestDispatcher("sales_modify.jsp").forward(request, response);
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
