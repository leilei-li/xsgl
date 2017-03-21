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

public class team_info_detail extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		

		teamBeanOP ubb=new teamBeanOP();
		teamBean ub=null;
		ArrayList<teamBean> al=null;
		
	    String team_ID=request.getParameter("team_ID");
			al=ubb.getTeam_team_ID(team_ID);
			if(al.size()>0){
				request.setAttribute("teamArray", al);
				request.setAttribute("teamInfo", ub);
				request.getRequestDispatcher("team_info_detail.jsp").forward(request, response);
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
