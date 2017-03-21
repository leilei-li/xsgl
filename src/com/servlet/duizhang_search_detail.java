package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.dingdanBean;
import com.model.dingdanBeanOP;
import com.model.duizhangBean;
import com.model.duizhangBeanOP;

public class duizhang_search_detail extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		dingdanBeanOP tbb=new dingdanBeanOP();
		dingdanBean tb=null;
		//ArrayList<dingdanBean> al=(ArrayList<dingdanBean>) request.getSession().getAttribute("duizhang_dingdan");
		String duizhang_ID=request.getParameter("duizhang_ID");
		duizhang_ID=new String(duizhang_ID.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		String duizhang_ID1=String.valueOf(duizhang_ID);
//		System.out.println(duizhang_ID);
//		System.out.println(duizhang_ID1);
		ArrayList<dingdanBean> al=null;
		al=tbb.getdingdan_duizhang_ID(duizhang_ID1);
//		for(int i=0;i<al.size();i++)
//		{
//			System.out.println(al.get(i).getdingdan_ID());
//		}
			if(al.size()>0){
				request.setAttribute("duizhang_ID", duizhang_ID1);
				request.setAttribute("dingdanArray11", al);
				request.getRequestDispatcher("duizhang_info_detail.jsp").forward(request, response);
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
