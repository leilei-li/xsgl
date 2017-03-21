package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.fapiaoBean;
import com.model.fapiaoBeanOP;

public class fapiao_newServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String fapiao_ID=request.getParameter("fapiao_ID");
		fapiao_ID=new String(fapiao_ID.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		String fapiao_num=fapiao_ID;
		
		String create_date=request.getParameter("create_date");
		create_date=new String(create_date.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String dingdan_ID=request.getParameter("dingdan_ID");
		dingdan_ID=new String(dingdan_ID.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		
		String money=request.getParameter("money");
		money=new String(money.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		float money1=Float.parseFloat(money);//string转float

		String cus_ID=request.getParameter("cus_ID");
		cus_ID=new String(cus_ID.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		
		String sales_ID=request.getParameter("sales_ID");
		sales_ID=new String(sales_ID.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String shishou=request.getParameter("shishou");
		shishou=new String(shishou.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		float shishou1=Float.parseFloat(shishou);//string转float
		
		String state=request.getParameter("state");
		state=new String(state.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String fapiaotaitou=request.getParameter("fapiaotaitou");
		fapiaotaitou=new String(fapiaotaitou.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		
		String user_ID=request.getParameter("user_ID");
		user_ID=new String(user_ID.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		
		
		boolean ub=false;
		fapiaoBeanOP ubb=new fapiaoBeanOP();
		ub=ubb.creatFapiao(fapiao_ID,fapiao_num,create_date,dingdan_ID,money1,cus_ID,sales_ID,shishou1,state,fapiaotaitou,
				user_ID);
		
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
