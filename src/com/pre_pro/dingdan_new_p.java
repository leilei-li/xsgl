package com.pre_pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.danweiBean;
import com.model.danweiBeanOP;
import com.model.salesBean;
import com.model.salesBeanOP;
import com.model.shengshiBean;
import com.model.shengshiBeanOP;

public class dingdan_new_p extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		salesBeanOP salesb=new salesBeanOP();
		ArrayList<salesBean> salesl=null;
		salesl=salesb.getSales_sales_ID("");
		
		danweiBeanOP dbb=new danweiBeanOP();
		danweiBean tb=null;
		ArrayList<danweiBean> al=null;
		shengshiBeanOP sbb=new shengshiBeanOP();
		shengshiBean sb=null;
		ArrayList<shengshiBean> sl=null;
			//System.out.print("heheda");
			al=dbb.getarea_name_p();
			//sl=sbb.getshengshi_p();
			if(al.size()>0){
				//System.out.print("nihao");
				request.setAttribute("areaArray", al);
				request.setAttribute("salesArray", salesl);
				request.getRequestDispatcher("dingdan_new.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("no_info.jsp").forward(request, response);
			}
			
		}
	


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
