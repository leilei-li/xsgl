package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.priceBean;
import com.model.priceBeanOP;

public class price_newServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		
		String name=request.getParameter("name");
		name=new String(name.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String class_name=request.getParameter("class_name");
		class_name=new String(class_name.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String type=request.getParameter("type");
		type=new String(type.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String qizhi=request.getParameter("qizhi");
		qizhi=new String(qizhi.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String price=request.getParameter("price");
		price=new String(price.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		float price1=Float.parseFloat(price);//string转float
		
		String qi,zhi;
		String[] S=qizhi.split("-");
		qi=S[0];
		zhi=S[1];
//		System.out.println(qi);//分出起止
//		System.out.println(zhi);
		

		
		boolean ub=false;
		priceBean kb;
		priceBeanOP ubb=new priceBeanOP();
			ub=ubb.creatprice(name,class_name,type,qi,zhi,price1);
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
