package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.giftBean;
import com.model.giftBeanOP;

public class gift__dan_searchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String text1=request.getParameter("gift_name");
		text1=new String(text1.getBytes("iso-8859-1"),"utf-8");
		String type=request.getParameter("type");

		giftBeanOP tbb=new giftBeanOP();
		giftBean tb=null;
		ArrayList<giftBean> al=null;
		System.out.print(type);
				if(type.equals("1"))
				{
					al=tbb.getGift_gift_name(text1);
					if(al.size()>0){
						//System.out.print("nihao");
						request.setAttribute("giftArray", al);
						request.setAttribute("giftInfo", tb);
						request.getRequestDispatcher("gift_info_brife.jsp").forward(request, response);
						}
						else{
							request.getRequestDispatcher("no_info.jsp").forward(request, response);
							}
				}
				else if(type.equals("2"))
				{
					al=tbb.getGift_gift_name(text1);
					if(al.size()>0){
						//System.out.print("nihao");
						request.setAttribute("giftArray", al);
						request.setAttribute("giftInfo", tb);
						request.getRequestDispatcher("fenye.jsp").forward(request, response);
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
