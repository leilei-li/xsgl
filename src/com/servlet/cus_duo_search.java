package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.model.cusBean;
import com.model.cusBeanOP;

@WebServlet("/cus_duo_search")
public class cus_duo_search extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String cus_ID=request.getParameter("cus_ID");
		cus_ID=new String(cus_ID.getBytes("iso-8859-1"),"utf-8");
		String cus_name=request.getParameter("cus_name");
		cus_name=new String(cus_name.getBytes("iso-8859-1"),"utf-8");
		String keshi_name=request.getParameter("keshi_name");
		keshi_name=new String(keshi_name.getBytes("iso-8859-1"),"utf-8");
		String danwei_name=request.getParameter("danwei_name");
		danwei_name=new String(danwei_name.getBytes("iso-8859-1"),"utf-8");
		
		cusBeanOP tbb=new cusBeanOP();
		cusBean tb=null;
		ArrayList<cusBean> al=null;
//	    String type=request.getParameter("select") ;
//	    type=new String(type.getBytes("iso-8859-1"),"utf-8");
	    //System.out.print("sb");
		
			//System.out.print("heheda");
			//System.out.print(text1);
			al=tbb.getcus_duo(cus_ID,cus_name,keshi_name,danwei_name);
			if(al.size()>0){
				//System.out.print("nihao");
				request.setAttribute("cusArray", al);
				request.setAttribute("cusInfo", tb);
				request.getRequestDispatcher("cus_info_brife.jsp").forward(request, response);
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
