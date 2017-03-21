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
import com.model.dingdanBean;
import com.model.dingdanBeanOP;

public class cus_info_detail extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		

		cusBeanOP ubb=new cusBeanOP();
		dingdanBeanOP dbb=new dingdanBeanOP();
		cusBean ub=null;
		ArrayList<cusBean> al=null;
		ArrayList<dingdanBean> al1=null;
		
	    String cus_ID=request.getParameter("cus_ID");
			al=ubb.getCus_cus_ID(cus_ID);
			al1=dbb.getdingdan_cus_ID_j(cus_ID);
			if(al.size()>0){
				request.setAttribute("cusArray", al);
				request.setAttribute("dingdanArray", al1);
				request.getRequestDispatcher("cus_info_detail.jsp").forward(request, response);
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
