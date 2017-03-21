package com.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.danweiBean;
import com.model.danweiBeanOP;

public class cus_new_getarea_name extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String city=request.getParameter("city");
		city=new String(city.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		System.out.println("省市:  "+city);
		
		ArrayList<danweiBean> db;
		danweiBeanOP dbb=new danweiBeanOP();
		db=dbb.getarea_name_city(city);
		if(db.size()>0)
		{
			for(int i=0;i<db.size();i++){
				out.print(db.get(i).getarea_name()+"/");
			}
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
