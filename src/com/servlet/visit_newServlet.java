package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.visitBean;
import com.model.visitBeanOP;
import com.model.giftBean;
import com.model.giftBeanOP;
import com.model.cusBean;
import com.model.cusBeanOP;

public class visit_newServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String sale_ID=request.getParameter("sale_ID");
		sale_ID=new String(sale_ID.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String customer_ID=request.getParameter("customer_ID");
		customer_ID=new String(customer_ID.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String didian=request.getParameter("didian");
		didian=new String(didian.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		
		String date=request.getParameter("date");
		date=new String(date.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		

		String reason=request.getParameter("reason");
		reason=new String(reason.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String gift=request.getParameter("gift");
		gift=new String(gift.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String gift_num=request.getParameter("gift_num");
		gift_num=new String(gift_num.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		float gift_num1=Float.parseFloat(gift_num);//string转float
		
		String result=request.getParameter("result");
		result=new String(result.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		//System.out.println(ID);
		
		boolean ub=false;
		visitBeanOP ubb=new visitBeanOP();
		ub=ubb.creatVisit(sale_ID,customer_ID,didian,date,reason,gift,gift_num1,result);
		boolean cb=false;
		cusBeanOP cbb=new cusBeanOP();
		boolean gb=false;
		giftBeanOP gbb=new giftBeanOP();
		if(ub==false){
			System.out.println("没存进去");
			request.getRequestDispatcher("OP_fail.jsp").forward(request, response);
		}
		else{
			//request.getSession().setAttribute("userBean", ub);
			cb=cbb.cus_jifenModify_gift(customer_ID,gift,gift_num1);//送出礼物之后扣除相应积分
			gb=gbb.gift_numModify(gift,0-gift_num1);//礼物库存相应减少
			if(cb==true){
				request.getRequestDispatcher("OP_success.jsp").forward(request, response);
			}
			else{
				System.out.println("没存进去");
				request.getRequestDispatcher("OP_fail.jsp").forward(request, response);	
			}
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
