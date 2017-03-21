package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.cusBean;
import com.model.cusBeanOP;
import com.model.duizhangBean;
import com.model.duizhangBeanOP;

public class duizhang_search extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String radiobutton=request.getParameter("radiobutton");
		radiobutton=new String(radiobutton.getBytes("iso-8859-1"),"utf-8");
		System.out.println(radiobutton);
		if(radiobutton.equals("cus_name")){//��ѡ���ǿͻ�����
			String cus_ID=request.getParameter("cus_name");
			cus_ID=new String(cus_ID.getBytes("iso-8859-1"),"utf-8");
			System.out.println(cus_ID);
//			String cus_name1;
//			String[] S=cus_name.split(",");
//			cus_name1=S[1];//��ö��ź���Ŀͻ���
//			System.out.println(cus_name1);
			duizhangBeanOP duizhangb=new duizhangBeanOP();
			ArrayList<duizhangBean> duizhangl=null;
			duizhangl=duizhangb.getduizhang_cus_ID(cus_ID);
			if(duizhangl.size()>0){
				request.setAttribute("duizhangArray", duizhangl);
				request.getRequestDispatcher("duizhang_search_result.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("no_info.jsp").forward(request, response);
			}
		}
		
		
		if(radiobutton.equals("sales_name")){//��ѡ���ǿͻ�����
			String sales_ID=request.getParameter("sales_name");
			sales_ID=new String(sales_ID.getBytes("iso-8859-1"),"utf-8");
			System.out.println(sales_ID);
//			String cus_name1;
//			String[] S=cus_name.split(",");
//			cus_name1=S[1];//��ö��ź���Ŀͻ���
//			System.out.println(cus_name1);
			duizhangBeanOP duizhangb=new duizhangBeanOP();
			ArrayList<duizhangBean> duizhangl=null;
			duizhangl=duizhangb.getduizhang_sales_ID(sales_ID);
			if(duizhangl.size()>0){
				request.setAttribute("duizhangArray", duizhangl);
				request.getRequestDispatcher("duizhang_search_result.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("no_info.jsp").forward(request, response);
			}
		}
		
		
		if(radiobutton.equals("danwei_name")){//��ѡ���ǵ�λ����
			String danwei_name=request.getParameter("danwei_name");
			danwei_name=new String(danwei_name.getBytes("iso-8859-1"),"utf-8");
			System.out.println(danwei_name);
//			String cus_name1;
//			String[] S=cus_name.split(",");
//			cus_name1=S[1];//��ö��ź���Ŀͻ���
//			System.out.println(cus_name1);
			duizhangBeanOP duizhangb=new duizhangBeanOP();
			ArrayList<duizhangBean> duizhangl=null;
			duizhangl=duizhangb.getduizhang_danwei_name(danwei_name);
			if(duizhangl.size()>0){
				request.setAttribute("duizhangArray", duizhangl);
				request.getRequestDispatcher("duizhang_search_result.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("no_info.jsp").forward(request, response);
			}
		}
		
		
		if(radiobutton.equals("keshi_name")){//��ѡ���ǿ�������
			String str=request.getParameter("keshi_name");
			str=new String(str.getBytes("iso-8859-1"),"utf-8");
			System.out.println(str);
			String keshi_name,danwei_name;
			String[] S=str.split(",");
			keshi_name=S[1];//��ö��ź���Ŀ�����
			danwei_name=S[0];//��ö���ǰ��ĵ�λ��
			System.out.println(danwei_name+"  "+keshi_name);
			duizhangBeanOP duizhangb=new duizhangBeanOP();
			ArrayList<duizhangBean> duizhangl=null;
			duizhangl=duizhangb.getduizhang_keshi_name(danwei_name,keshi_name);
			if(duizhangl.size()>0){
				request.setAttribute("duizhangArray", duizhangl);
				request.getRequestDispatcher("duizhang_search_result.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("no_info.jsp").forward(request, response);
			}
		}
		
		
		if(radiobutton.equals("dingdanhao")){//��ѡ���Ƕ�����
			String dingdan_ID=request.getParameter("duizhanghao");
			dingdan_ID=new String(dingdan_ID.getBytes("iso-8859-1"),"utf-8");
			System.out.println(dingdan_ID);
//			String keshi_name,danwei_name;
//			String[] S=str.split(",");
//			keshi_name=S[1];//��ö��ź���Ŀ�����
//			danwei_name=S[0];//��ö���ǰ��ĵ�λ��
//			System.out.println(danwei_name+"  "+keshi_name);
			duizhangBeanOP duizhangb=new duizhangBeanOP();
			ArrayList<duizhangBean> duizhangl=null;
			duizhangl=duizhangb.getduizhang_dingdan_ID(dingdan_ID);
			if(duizhangl.size()>0){
				request.setAttribute("duizhangArray", duizhangl);
				request.getRequestDispatcher("duizhang_search_result.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("no_info.jsp").forward(request, response);
			}
		}
		
		if(radiobutton.equals("dingdanriqi")){//��ѡ���Ƕ�������
			String start=request.getParameter("start");
			start=new String(start.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
			
			String end=request.getParameter("end");
			end=new String(end.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
			

			duizhangBeanOP duizhangb=new duizhangBeanOP();
			ArrayList<duizhangBean> duizhangl=null;
			duizhangl=duizhangb.getduizhang_date(start,end);
			if(duizhangl.size()>0){
				request.setAttribute("duizhangArray", duizhangl);
				request.getRequestDispatcher("duizhang_search_result.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("no_info.jsp").forward(request, response);
			}
		}
		
		
		
//		cusBeanOP tbb=new cusBeanOP();
//		ArrayList<cusBean> al=null;
//				request.getRequestDispatcher("cus_info_brife.jsp").forward(request, response);
//			}
//			else{
//				request.getRequestDispatcher("no_info.jsp").forward(request, response);
//			}
			
//		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
