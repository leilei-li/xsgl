package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.giftBean;
import com.model.giftBeanOP;

public class gift_newServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		
		String gift_name=request.getParameter("gift_name");
		gift_name=new String(gift_name.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		String gift_num=request.getParameter("gift_num");
		gift_num=new String(gift_num.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		float gift_num1=Float.parseFloat(gift_num);//stringתfloat
		
		String gift_value=request.getParameter("gift_value");
		gift_value=new String(gift_value.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		float gift_value1=Float.parseFloat(gift_value);//stringתfloat
		
		String jifen=request.getParameter("jifen");
		jifen=new String(jifen.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		float jifen1=Float.parseFloat(jifen);//stringתfloat

		
		boolean ub=false;
		giftBeanOP ubb=new giftBeanOP();
		ub=ubb.creatGift(gift_name,gift_num1,gift_value1,jifen1);
		System.out.println("jibian");
		if(ub==false){
			System.out.println("û���ȥ");
			request.getRequestDispatcher("OP_fail.jsp").forward(request, response);
		}
		else{
			//request.getSession().setAttribute("userBean", ub);
			
			
			request.getRequestDispatcher("OP_success.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
