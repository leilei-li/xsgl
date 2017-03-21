package com.pre_pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.cusBean;
import com.model.cusBeanOP;
import com.model.salesBean;
import com.model.salesBeanOP;
import com.model.danweiBean;
import com.model.danweiBeanOP;
import com.model.duizhangBean;
import com.model.duizhangBeanOP;
import com.model.keshiBean;
import com.model.keshiBeanOP;
import com.model.shengshiBean;
import com.model.shengshiBeanOP;

public class duizhang_search_p extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd"); 
		java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
		String end = formatter.format(currentTime); //将日期时间格式化 
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		String start = formatter.format(c.getTime());
		
		cusBeanOP cusb=new cusBeanOP();
		ArrayList<cusBean> cusl=null;
		cusl=cusb.getCus_cus_ID("");
		//获得客户的信息
		salesBeanOP salesb=new salesBeanOP();
		ArrayList<salesBean> salesl=null;
		salesl=salesb.getSales_sales_ID("");
		//获得销售员的信息
		danweiBeanOP danweib=new danweiBeanOP();
		ArrayList<danweiBean> danweil=null;
		danweil=danweib.getdanwei_name("");
		//获得单位的信息
		keshiBeanOP keshib=new keshiBeanOP();
		ArrayList<keshiBean> keshil=null;
		keshil=keshib.getkeshi_name("","");
		//获得科室的信息
		duizhangBeanOP tbb=new duizhangBeanOP();
		duizhangBean tb=null;
		ArrayList<duizhangBean> duizhangl=null;
	    duizhangl=tbb.getduizhang_date(start,end);
	    //获取近一个月对账单信息
		
		        request.setAttribute("start", start);
		        request.setAttribute("end", end);
				request.setAttribute("salesArray", salesl);
				request.setAttribute("danweiArray", danweil);
				request.setAttribute("keshiArray", keshil);
				request.setAttribute("cusArray", cusl);
				request.setAttribute("duizhangArray", duizhangl);
				request.getRequestDispatcher("duizhang_search.jsp").forward(request, response);
		}
	


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
