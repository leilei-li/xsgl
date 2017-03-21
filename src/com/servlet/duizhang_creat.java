package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.danweiBean;
import com.model.danweiBeanOP;
import com.model.dingdanBean;
import com.model.dingdanBeanOP;
import com.model.duizhangBean;
import com.model.duizhangBeanOP;

public class duizhang_creat extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		danweiBeanOP dbb=new danweiBeanOP();
		ArrayList<danweiBean> dl=null;
		
		dl=dbb.getarea_name_p();
		
		dingdanBeanOP tbb=new dingdanBeanOP();
		dingdanBean tb=null;
		ArrayList<dingdanBean> al=(ArrayList<dingdanBean>) request.getSession().getAttribute("dingdanArray1");
		ArrayList<dingdanBean> bl= new ArrayList<dingdanBean>();
		String[] check=request.getParameterValues("checkbox");
		for(int j=0;j<check.length;j++)
		{
			for(int i=0;i<al.size();i++)
			{
				if(check[j].equals(al.get(i).getdingdan_ID()))
				{
					bl.add(al.get(i));
					continue;
				}
					
			}
		}
		
			if(al.size()>0){
				request.setAttribute("dingdanArray", bl);
				request.setAttribute("danweiArray", dl);
				request.getRequestDispatcher("duizhang_queren.jsp").forward(request, response);
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
