package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.cusBean;
import com.model.keshiBean;
import com.model.keshiBeanOP;

public class keshi_newServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		
		String keshi_name=request.getParameter("keshi_name");
		keshi_name=new String(keshi_name.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String boss=request.getParameter("boss");
		boss=new String(boss.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		
		String danwei_name=request.getParameter("danwei_name");
		danwei_name=new String(danwei_name.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		

		
		boolean ub=false;
		keshiBean kb;
		keshiBeanOP ubb=new keshiBeanOP();
		keshiBeanOP kbb=new keshiBeanOP();
		kb=kbb.keshi_cunzai(keshi_name,danwei_name);
		if(kb==null){
			ub=ubb.creatkeshi(keshi_name,boss,danwei_name);
			if(ub==false){
				System.out.println("没存进去");
				request.getRequestDispatcher("OP_fail.jsp").forward(request, response);
			}
			else {
				//request.getSession().setAttribute("userBean", ub);
				request.getRequestDispatcher("OP_success.jsp").forward(request, response);
			}	
		}
		else{
			System.out.println("科室已经存在");
			request.getRequestDispatcher("OP_fail.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
