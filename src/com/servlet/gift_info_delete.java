package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.giftBean;
import com.model.giftBeanOP;

public class gift_info_delete extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		
		String gift_name=request.getParameter("gift_name");
		gift_name=new String(gift_name.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		

		
		boolean ub=false;
		giftBeanOP ubb=new giftBeanOP();
		
		if(ubb.gift_delete(gift_name)){
			
			request.getRequestDispatcher("OP_success.jsp").forward(request, response);
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
