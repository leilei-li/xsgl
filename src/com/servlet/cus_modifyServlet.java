package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.cusBean;
import com.model.cusBeanOP;

public class cus_modifyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String cus_ID=request.getParameter("cus_ID");
		cus_ID=new String(cus_ID.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String name=request.getParameter("name");
		name=new String(name.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String sex=request.getParameter("sex");
		sex=new String(sex.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		
		String type=request.getParameter("type");
		type=new String(type.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		

		String mobile1=request.getParameter("mobile1");
		mobile1=new String(mobile1.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		
		String mobile2=request.getParameter("mobile2");
		mobile2=new String(mobile1.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		
		String phone=request.getParameter("phone");
		phone=new String(phone.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		
		String keshi_ID=request.getParameter("keshi_ID");
		keshi_ID=new String(keshi_ID.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String role=request.getParameter("role");
		role=new String(role.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String task=request.getParameter("task");
		task=new String(task.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String advance_money=request.getParameter("advance_money");
		advance_money=new String(advance_money.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		float advance_money1=Float.parseFloat(advance_money);//string转int
		
		String hobby=request.getParameter("hobby");
		hobby=new String(hobby.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String jifen=request.getParameter("jifen");
		jifen=new String(jifen.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		int jifen1=Integer.parseInt(jifen);//string转int
		
		String keyan_money=request.getParameter("keyan_money");
		keyan_money=new String(keyan_money.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		float keyan_money1=Float.parseFloat(keyan_money);//string转int
		
		String chengguo=request.getParameter("chengguo");
		chengguo=new String(chengguo.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String position=request.getParameter("position");
		position=new String(position.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String protity=request.getParameter("protity");
		protity=new String(protity.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		int protity1=Integer.parseInt(protity);//string转int
		
		String state=request.getParameter("state");
		state=new String(state.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String email=request.getParameter("email");
		email=new String(email.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		
		boolean ub=false;
		cusBeanOP ubb=new cusBeanOP();
		ub=ubb.modifyCus(cus_ID,name,sex,type,mobile1,mobile2,phone,keshi_ID,role,
				task,advance_money1,hobby,jifen1,keyan_money1,chengguo,position,protity1,state,email);
		
		if(ub==false){
			System.out.println("没存进去");
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
