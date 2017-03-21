package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.priceBean;
import com.model.priceBeanOP;

public class price__dan_search extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String name=request.getParameter("name");
		name=new String(name.getBytes("iso-8859-1"),"utf-8");
		String class_name=request.getParameter("class_name") ;
	    class_name=new String(class_name.getBytes("iso-8859-1"),"utf-8");
	    String action=request.getParameter("action");
		action=new String(action.getBytes("iso-8859-1"),"utf-8");
	    
		priceBeanOP tbb=new priceBeanOP();
		priceBean tb=null;
		ArrayList<priceBean> al=null;
	    
			al=tbb.getprice(name,class_name);
			if(al.size()>0){
				if(action.equals("daochu")){
					request.setAttribute("priceArray", al);
					//request.setAttribute("cusInfo", tb);
					request.getRequestDispatcher("price_info_daochu.jsp").forward(request, response);
				}
				else{
					//System.out.print("sb");
					request.setAttribute("priceArray", al);
					//request.setAttribute("cusInfo", tb);
					request.getRequestDispatcher("price_info_brife.jsp").forward(request, response);
				}
				
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
