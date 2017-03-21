
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.salesBean;
import com.model.salesBeanOP;

@WebServlet("/sales_duo_search")

public class sales_duo_search extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String sales_ID=request.getParameter("sales_ID");
		sales_ID=new String(sales_ID.getBytes("iso-8859-1"),"utf-8");
		String sales_name=request.getParameter("sales_name");
		sales_name=new String(sales_name.getBytes("iso-8859-1"),"utf-8");
		String mobile1=request.getParameter("mobile");
		mobile1=new String(mobile1.getBytes("iso-8859-1"),"utf-8");
		
		salesBeanOP tbb=new salesBeanOP();
		salesBean tb=null;
		ArrayList<salesBean> al=null;
	    //System.out.print("sb");
			//System.out.print("heheda");
			al=tbb.getsales_duo(sales_ID,sales_name,mobile1);
			if(al.size()>0){
				//System.out.print("nihao");
				request.setAttribute("salesArray", al);
				request.setAttribute("salesInfo", tb);
				request.getRequestDispatcher("sales_info_brife.jsp").forward(request, response);
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
