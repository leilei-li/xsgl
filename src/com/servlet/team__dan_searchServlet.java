package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.teamBean;
import com.model.teamBeanOP;

public class team__dan_searchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String team_name=request.getParameter("team_name");
		team_name=new String(team_name.getBytes("iso-8859-1"),"utf-8");
		String team_ID=request.getParameter("team_ID");
		team_ID=new String(team_ID.getBytes("iso-8859-1"),"utf-8");
		
		teamBeanOP tbb=new teamBeanOP();
		teamBean tb=null;
		ArrayList<teamBean> al=null;
	    
	    
	    //System.out.print("sb");
			//System.out.print("heheda");
			al=tbb.getTeam(team_name,team_ID);
			if(al.size()>0){
				//System.out.print("nihao");
				request.setAttribute("teamArray", al);
				request.setAttribute("teamInfo", tb);
				request.getRequestDispatcher("team_info_brife.jsp").forward(request, response);
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
