package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.visitBean;
import com.model.visitBeanOP;

public class visit_info_detail extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		

		visitBeanOP ubb=new visitBeanOP();
		visitBean ub=null;
		ArrayList<visitBean> al=null;
		
	    String ID=request.getParameter("ID");
	    int ID1=Integer.parseInt(ID);//stringתint
	    //System.out.println(ID1);
			al=ubb.getvisit_ID(ID1);
			if(al.size()>0){
				request.setAttribute("visitArray", al);
				//request.setAttribute("teamInfo", ub);
				request.getRequestDispatcher("visit_info_detail.jsp").forward(request, response);
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
