package com.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.cusBean;
import com.model.cusBeanOP;

public class cus_new_cus_cunzai extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String cus_ID=request.getParameter("cus_ID");
		//cus_ID=new String(cus_ID.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		System.out.println("�û���:  "+cus_ID);
		
		cusBean ub;
		cusBeanOP ubb=new cusBeanOP();
		ub=ubb.cus_ID_cunzai(cus_ID);
		if(ub==null)
		{
			out.println("�ͻ��ſ���ʹ��");
		}
		else
		{
			out.println("�ͻ����ѱ�"+ub.getName()+"ʹ�ã��뻻һ��");
		}
		
		//if(ub==false){
			//System.out.println("û���ȥ");
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