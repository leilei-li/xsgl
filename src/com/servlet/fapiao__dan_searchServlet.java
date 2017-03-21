package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.fapiaoBean;
import com.model.fapiaoBeanOP;

public class fapiao__dan_searchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String fapiao_ID=request.getParameter("fapiao_ID");
		fapiao_ID=new String(fapiao_ID.getBytes("iso-8859-1"),"utf-8");
		
		String sales_name=request.getParameter("sales_name");
		sales_name=new String(sales_name.getBytes("iso-8859-1"),"utf-8");

		String cus_name=request.getParameter("cus_name");
		cus_name=new String(cus_name.getBytes("iso-8859-1"),"utf-8");
		
		String fapiaotaitou=request.getParameter("fapiaotaitou");
		fapiaotaitou=new String(fapiaotaitou.getBytes("iso-8859-1"),"utf-8");
		
		fapiaoBeanOP tbb=new fapiaoBeanOP();
		fapiaoBean tb=null;
		ArrayList<fapiaoBean> al=null;
	    String re_ID=request.getParameter("re_ID") ;
	    re_ID=new String(re_ID.getBytes("iso-8859-1"),"utf-8");
	    //System.out.print("sb");
	   if(re_ID.equals("admin")){
		   re_ID="";
	   }
		
			
			al=tbb.getfapiao_duo(fapiao_ID,sales_name,cus_name,fapiaotaitou,re_ID);
			if(al.size()>0){
				
				request.setAttribute("fapiaoArray", al);
				//request.setAttribute("cusInfo", tb);
				request.getRequestDispatcher("fapiao_info_brife.jsp").forward(request, response);
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
