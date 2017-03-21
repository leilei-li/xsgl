package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.cusBean;
import com.model.danweiBean;
import com.model.danweiBeanOP;

public class danwei_newServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		
		String danwei_name=request.getParameter("danwei_name");
		danwei_name=new String(danwei_name.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		System.out.println(danwei_name);
		
		String area_name=request.getParameter("area_name");
		area_name=new String(area_name.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String chair=request.getParameter("chair");
		chair=new String(chair.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String info=request.getParameter("info");
		info=new String(info.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String address=request.getParameter("address");
		address=new String(address.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的

		
		boolean ub=false;
		danweiBean kb;
		danweiBeanOP ubb=new danweiBeanOP();
			ub=ubb.creatdanwei(danwei_name,address,info,chair,area_name);
			if(ub==false){
				System.out.println("没存进去");
				request.getRequestDispatcher("OP_fail.jsp").forward(request, response);
			}
			else {
				//request.getSession().setAttribute("userBean", ub);
				request.getRequestDispatcher("OP_success.jsp").forward(request, response);
			}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
