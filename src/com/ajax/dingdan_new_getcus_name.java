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
import com.model.keshiBean;
import com.model.keshiBeanOP;
import com.model.cusBean;
import com.model.cusBeanOP;


public class dingdan_new_getcus_name extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String keshi_name=request.getParameter("keshi_name");
		keshi_name=new String(keshi_name.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		String danwei_name=request.getParameter("danwei_name");
		danwei_name=new String(danwei_name.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		System.out.println(danwei_name+" "+keshi_name);
		
		ArrayList<cusBean> cb;
		cusBeanOP cbb=new cusBeanOP();
		cb=cbb.getcus_keshi_danwei(danwei_name,keshi_name);
		if(cb.size()>0)
		{
			for(int i=0;i<cb.size();i++){
				out.print(cb.get(i).getcus_ID()+","+cb.get(i).getName()+"/");
			}
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
