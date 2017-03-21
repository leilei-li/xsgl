package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.priceBean;
import com.model.priceBeanOP;

public class price_modify extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String index=request.getParameter("index");
		index=new String(index.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String name=request.getParameter("name"+index);
		name=new String(name.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String ID=request.getParameter("ID");
		ID=new String(ID.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		long ID1=Long.parseLong(ID);//string转float
		
		String class_name=request.getParameter("class_name"+index);
		class_name=new String(class_name.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String type=request.getParameter("type"+index);
		type=new String(type.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String price=request.getParameter("price"+index);
		price=new String(price.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		float pricef=Float.parseFloat(price);//string转float
		
//        System.out.println(name);
//        System.out.println(class_name);
//        System.out.println(type);
        System.out.println(pricef);
		
		boolean ub=false;
		priceBean kb;
		priceBeanOP ubb=new priceBeanOP();
			ub=ubb.modifyprice(name,class_name,type,pricef,ID1);
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
