package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.dingdanBean;
import com.model.dingdanBeanOP;

public class dingdan_modifyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String date=request.getParameter("date");
		date=new String(date.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		//System.out.println(name);
		String type=request.getParameter("type");
		type=new String(type.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		String dingdanhao=request.getParameter("dingdanhao");
		dingdanhao=new String(dingdanhao.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		String dingdan_ID=dingdanhao;
		
		String cus_ID=request.getParameter("cus_ID");
		cus_ID=new String(cus_ID.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		
		String sales_ID=request.getParameter("sales_ID");
		sales_ID=new String(sales_ID.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		String state=request.getParameter("state");
		state=new String(state.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		
		String fapiao=request.getParameter("fapiaohao");
		fapiao=new String(fapiao.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		
		String yangpinmiaoshu=request.getParameter("yangpinmiaoshu");
		yangpinmiaoshu=new String(yangpinmiaoshu.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		String sample_num=request.getParameter("sample_num");
		sample_num=new String(sample_num.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		String price=request.getParameter("price");
		price=new String(price.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		float price1=Float.parseFloat(price);//stringתfloat
		
		String sell_off=request.getParameter("sell_off");
		sell_off=new String(sell_off.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		float sell_off1=Float.parseFloat(sell_off);//stringתint
		
		String shoufei_num=request.getParameter("shoufei_num");
		shoufei_num=new String(shoufei_num.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		
		boolean ub=false;
		dingdanBeanOP ubb=new dingdanBeanOP();
		ub=ubb.modifydingdan(dingdan_ID,date,type,dingdanhao,cus_ID,sales_ID,state,fapiao,yangpinmiaoshu,
				sample_num,price1,sell_off1,shoufei_num);
		
		if(ub==false){
			System.out.println("û���ȥ");
			request.getRequestDispatcher("OP_fail.jsp").forward(request, response);
		}
		else{
			
			
			request.getRequestDispatcher("OP_success.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
