package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.salesBean;
import com.model.salesBeanOP;

public class sales_modifyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String sales_ID=request.getParameter("sales_ID");
		sales_ID=new String(sales_ID.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		String name=request.getParameter("name");
		name=new String(name.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		String sex=request.getParameter("sex");
		sex=new String(sex.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		
		String CN_ID=request.getParameter("CN_ID");
		CN_ID=new String(CN_ID.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		

		String mobile1=request.getParameter("mobile1");
		mobile1=new String(mobile1.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		
		String mobile2=request.getParameter("mobile2");
		mobile2=new String(mobile1.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		
		String inDate=request.getParameter("inDate");
		inDate=new String(inDate.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		
		String duty=request.getParameter("duty");
		duty=new String(duty.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		String level=request.getParameter("level");
		level=new String(level.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		String salary=request.getParameter("salary");
		salary=new String(salary.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		float salary1=Float.parseFloat(salary);
		
		String royalty=request.getParameter("royalty");
		royalty=new String(royalty.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		float royalty1=Float.parseFloat(royalty);//stringתint
		
		String Team_ID=request.getParameter("Team_ID");
		Team_ID=new String(Team_ID.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		String email=request.getParameter("email");
		email=new String(email.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		String characte=request.getParameter("characte");
		characte=new String(characte.getBytes("iso-8859-1"),"utf-8");
		
		String favorite=request.getParameter("favorite");
		favorite=new String(favorite.getBytes("iso-8859-1"),"utf-8");
		
		boolean ub=false;
		salesBeanOP ubb=new salesBeanOP();
		ub=ubb.modifySales(sales_ID,name,sex,CN_ID,mobile1,mobile2,inDate,duty,level,
				salary1,royalty1,Team_ID,email,characte,favorite);
		
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
