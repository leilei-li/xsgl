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

public class dingdan_info_detail extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		

		dingdanBeanOP ubb=new dingdanBeanOP();
		dingdanBean ub=null;
		ArrayList<dingdanBean> al=null;
		
	    String dingdan_ID=request.getParameter("dingdan_ID");
			al=ubb.getdingdan_dingdan_ID(dingdan_ID);
			if(al.size()>0){
				request.setAttribute("dingdanArray", al);
				//request.setAttribute("cusInfo", ub);
				request.getRequestDispatcher("dingdan_info_detail.jsp").forward(request, response);
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
