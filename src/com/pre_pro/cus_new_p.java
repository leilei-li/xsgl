package com.pre_pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.cusBeanOP;
import com.model.danweiBean;
import com.model.danweiBeanOP;
import com.model.shengshiBean;
import com.model.shengshiBeanOP;

public class cus_new_p extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		danweiBeanOP dbb=new danweiBeanOP();
		danweiBean tb=null;
		ArrayList<danweiBean> al=null;
		shengshiBeanOP sbb=new shengshiBeanOP();
		shengshiBean sb=null;
		ArrayList<shengshiBean> sl=null;
			//System.out.print("heheda");
			al=dbb.getarea_name_p();
			sl=sbb.getshengshi_p();
			if(al.size()>0){
				cusBeanOP tbb=new cusBeanOP();
				String last_cus_ID =null;
				last_cus_ID=tbb.getLast_cus_ID();
				int l=Integer.parseInt(last_cus_ID);
				l=l+1;
				last_cus_ID=String.valueOf(l);
				//System.out.print("nihao");
				request.setAttribute("areaArray", al);
				request.setAttribute("shengshiArray", sl);
				request.setAttribute("last_cus_ID", last_cus_ID);
				request.getRequestDispatcher("cus_new.jsp").forward(request, response);
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
