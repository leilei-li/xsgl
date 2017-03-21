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

public class keshi_dan_search extends HttpServlet {

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
		ArrayList<keshiBean> al=null;
	    //System.out.print("sb");
			al=tbb.getkeshi_name(keshi_name,danwei_name);
			if(al.size()>0){
				
				request.setAttribute("keshiArray", al);
				//request.setAttribute("cusInfo", tb);
				request.getRequestDispatcher("keshi_info_brife.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("no_info.jsp").forward(request, response);
			}
			
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
