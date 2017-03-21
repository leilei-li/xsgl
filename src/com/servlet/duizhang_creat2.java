package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.dingdanBean;
import com.model.dingdanBeanOP;
import com.model.duizhangBean;
import com.model.duizhangBeanOP;

public class duizhang_creat2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		dingdanBeanOP tbb=new dingdanBeanOP();
		dingdanBean tb=null;
		ArrayList<dingdanBean> al=(ArrayList<dingdanBean>) request.getSession().getAttribute("duizhang_dingdan");
		String username=request.getParameter("username");
		username=new String(username.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String date=request.getParameter("date");
		date=new String(date.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		int date1=Integer.parseInt(date);//string转int
		
		String area_name=request.getParameter("area_name");
		area_name=new String(area_name.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String danwei_name=request.getParameter("danwei_name");
		danwei_name=new String(danwei_name.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String keshi_name=request.getParameter("keshi_name");
		keshi_name=new String(keshi_name.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		duizhangBeanOP duizhangbb=new duizhangBeanOP();
		duizhangBean duizhangb=null;
		int date2=date1%1000000;
		date2=date2*1000;
		int k=0;
		//System.out.println(date2);
		while(k==0)//生成订单号，上限一天1000个
		{
			duizhangb=duizhangbb.duizhang_ID_cunzai(date2);
			if(duizhangb==null){
			System.out.println(date2);
			k=1;
			}
			else{
				date2=date2+1;
			}
		}
		dingdanBeanOP dingdanbb=new dingdanBeanOP();
		for(int i=0;i<al.size();i++)
		{
			dingdanbb.modifydingdan_state(al.get(i).getdingdan_ID(),date2,"已开对账单未开发票");
		}
		//订单上的对账单号进行更新
		boolean cd=false;
		cd=duizhangbb.creat_duizhang(date2,"无",date,username,danwei_name,keshi_name);
			if(cd==true){
				request.setAttribute("danwei_name", danwei_name);
				request.setAttribute("keshi_name", keshi_name);
				request.setAttribute("duizhang_ID", date2);
				request.getRequestDispatcher("duizhang_creat_success.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("OP_fail.jsp").forward(request, response);
			}
			
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
