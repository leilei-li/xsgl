package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.dingdanBean;
import com.model.dingdanBeanOP;
import com.model.salesBean;
import com.model.salesBeanOP;

public class sales_info_detail extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		dingdanBeanOP dbb=new dingdanBeanOP();
		salesBeanOP ubb=new salesBeanOP();
		salesBean ub=null;
		ArrayList<salesBean> al=null;
		ArrayList<dingdanBean> al1=null;
	    String sales_ID=request.getParameter("sales_ID");
	  
			al=ubb.getSales_sales_ID(sales_ID);
			al1=dbb.getdingdan_sales_ID_j(sales_ID);
			if(al.size()>0){
				request.setAttribute("salesArray", al);
				request.setAttribute("dingdanArray", al1);
				request.getRequestDispatcher("sales_info_detail.jsp").forward(request, response);
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
