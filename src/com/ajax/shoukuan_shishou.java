package com.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.fapiaoBean;
import com.model.fapiaoBeanOP;

public class shoukuan_shishou extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String fapiao_ID=request.getParameter("fapiao_ID");
		//cus_ID=new String(cus_ID.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		//System.out.println("用户名:  "+cus_ID);
		
		fapiaoBean ub;
		fapiaoBeanOP ubb=new fapiaoBeanOP();
		ub=ubb.getfapiao_ID(fapiao_ID);
		if(ub==null)
		{
			out.println("发票号不可用！！");
		}
		else
		{
			out.println("实收不大于"+(ub.getmoney()-ub.getshishou())+"");
		}
		
		//if(ub==false){
			//System.out.println("没存进去");
			//request.getRequestDispatcher("OP_fail.jsp").forward(request, response);
		//}
		//else{
			//request.getSession().setAttribute("userBean", ub);
			
			
			//request.getRequestDispatcher("OP_success.jsp").forward(request, response);
		//}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
