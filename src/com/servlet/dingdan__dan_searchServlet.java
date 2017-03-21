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
import com.model.cusBean;
import com.model.cusBeanOP;

public class dingdan__dan_searchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String text=request.getParameter("text");
		text=new String(text.getBytes("iso-8859-1"),"utf-8");
		
		String re_ID=request.getParameter("re_ID");
		re_ID=new String(re_ID.getBytes("iso-8859-1"),"utf-8");
		
		dingdanBeanOP tbb=new dingdanBeanOP();
		dingdanBean tb=null;
		ArrayList<dingdanBean> al=null;
	    
		if(re_ID.equals("admin")){
			re_ID="";
		}
	
			al=tbb.getdingdan_dingdan_ID1(text,re_ID);
			if(al.size()>0){
				request.setAttribute("dingdanArray", al);
				//request.setAttribute("cusInfo", tb);
				request.getRequestDispatcher("dingdan_info_brife.jsp").forward(request, response);
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
