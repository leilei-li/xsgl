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

public class duizhang_new_search1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		dingdanBeanOP tbb=new dingdanBeanOP();
		dingdanBean tb=null;
		ArrayList<dingdanBean> al=null;
	    
		
			
			al=tbb.getdingdan_state("未开对账单未开发票");
			//System.out.println(al.get(0).getdingdan_ID());
			if(al.size()>0){
				request.setAttribute("dingdanArray", al);
				request.getRequestDispatcher("duizhang_weikaifapiao_brife.jsp").forward(request, response);
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
