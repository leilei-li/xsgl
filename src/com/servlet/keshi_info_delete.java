package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.keshiBean;
import com.model.keshiBeanOP;

public class keshi_info_delete extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String keshi_name=request.getParameter("keshi_name");
		keshi_name=new String(keshi_name.getBytes("iso-8859-1"),"utf-8");
		String danwei_name=request.getParameter("danwei_name") ;
	    danwei_name=new String(danwei_name.getBytes("iso-8859-1"),"utf-8");
		keshiBeanOP tbb=new keshiBeanOP();
		keshiBean tb=null;
		boolean ub=false;
		ArrayList<keshiBean> al=null;
	    //System.out.print("sb");
			ub=tbb.keshi_delete(keshi_name,danwei_name);
			if(ub==false){
				System.out.println("Ã»´æ½øÈ¥");
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
