package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.duizhangBean;
import com.model.duizhangBeanOP;
import com.model.shoukuanBean;
import com.model.shoukuanBeanOP;
import com.model.cusBean;
import com.model.cusBeanOP;

public class shoukuan_newServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String dingdan_ID=request.getParameter("dingdan_ID");
		dingdan_ID=new String(dingdan_ID.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		String fapiao_ID=request.getParameter("fapiao_ID");
		fapiao_ID=new String(fapiao_ID.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		String date=request.getParameter("date");
		date=new String(date.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		
		String sales_name=request.getParameter("sales_ID");
		sales_name=new String(sales_name.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		

		String kehu_ID=request.getParameter("kehu_ID");
		kehu_ID=new String(kehu_ID.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		
		String jizhang=request.getParameter("jizhang");
		jizhang=new String(jizhang.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		
		String shenhe=request.getParameter("shenhe");
		shenhe=new String(shenhe.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		
		String type=request.getParameter("type");
		type=new String(type.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		
		String shishou=request.getParameter("shishou");
		shishou=new String(shishou.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		float shishou1=Float.parseFloat(shishou);//stringתint
		
		shoukuanBeanOP shoukuanbb=new shoukuanBeanOP();
		shoukuanBean shoukuanb=null;
		cusBeanOP cbb=new cusBeanOP();
		boolean cb=false;
		int date1=Integer.parseInt(date);//stringתint
		int date2=date1%1000000;
		date2=date2*100;
		int k=0;
		while(k==0)//�����տ���ˮ�ţ�����һ��100��
		{
			shoukuanb=shoukuanbb.shoukuan_ID_cunzai(date2);
			if(shoukuanb==null){
			System.out.println(date2);
			k=1;
			}
			else{
				date2=date2+1;
			}
		}
		
		
		boolean ub=false,mb=false;
		shoukuanBean fb=null;
		
		shoukuanBeanOP ubb=new shoukuanBeanOP();
		fb=ubb.fapiao_ID_cunzai(fapiao_ID);
		System.out.println(fapiao_ID);
		if(fb==null){
			System.out.println("��Ʊ�Ų�����");
			request.getRequestDispatcher("OP_fail.jsp").forward(request, response);
		}
		else {
			mb=ubb.modify_shishou_to_fapiao(fapiao_ID,shishou1);//ʵ��д����Ʊ
			if(mb==true){
				ub=ubb.creatshoukuan(dingdan_ID,fapiao_ID,date,sales_name,kehu_ID,
						jizhang,shenhe,type,shishou1,date2);
				if(ub==true){
					cb=cbb.cus_jifenModify_shoukuan(kehu_ID, shishou1*10);//���»��֣�һ��ǮΪʮ��
					request.getRequestDispatcher("OP_success.jsp").forward(request, response);	
				}
				else{
					System.out.println("�����տ��¼����");
					request.getRequestDispatcher("OP_fail.jsp").forward(request, response);
				}
				
			}
			else{
				System.out.println("���·�Ʊ�����");
				request.getRequestDispatcher("OP_success.jsp").forward(request, response);
			}
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
