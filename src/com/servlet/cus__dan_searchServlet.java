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

public class cus__dan_searchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String text1=request.getParameter("text");
		text1=new String(text1.getBytes("iso-8859-1"),"utf-8");
		
		cusBeanOP tbb=new cusBeanOP();
		cusBean tb=null;
		ArrayList<cusBean> al=null;
	    String type=request.getParameter("select") ;
	    type=new String(type.getBytes("iso-8859-1"),"utf-8");
	    //System.out.print("sb");
		if(type.equals("客户号")){
			//System.out.print("heheda");
			//System.out.print(text1);
			al=tbb.getCus_cus_ID(text1);
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
		
		else if(type.equals("客户姓名")){
			
			
			al=tbb.getCus_name(text1);
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
		
		else if(type.equals("电话号码")){
			
			System.out.print("电话号码");
			al=tbb.getCus_mobile1(text1);
			if(al.size()>0){
				System.out.print("nihao");
				request.setAttribute("cusArray", al);
				//request.setAttribute("cusInfo", tb);
				request.getRequestDispatcher("cus_info_brife.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("no_info.jsp").forward(request, response);
			}
			
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
