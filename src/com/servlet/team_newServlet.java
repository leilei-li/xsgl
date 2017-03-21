package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.teamBean;
import com.model.teamBeanOP;

public class team_newServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String team_ID=request.getParameter("team_ID");
		team_ID=new String(team_ID.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String team_name=request.getParameter("team_name");
		team_name=new String(team_name.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String leader=request.getParameter("leader");
		leader=new String(leader.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		
		String teamcol=request.getParameter("teamcol");
		teamcol=new String(teamcol.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		

		String team_goal=request.getParameter("team_goal");
		team_goal=new String(team_goal.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		
		System.out.println(team_ID);
		
		boolean ub=false;
		teamBeanOP ubb=new teamBeanOP();
		ub=ubb.creatTeam(team_ID,team_name,leader,teamcol,team_goal);
		
		if(ub==false){
			System.out.println("没存进去");
			request.getRequestDispatcher("OP_fail.jsp").forward(request, response);
		}
		else{
			//request.getSession().setAttribute("userBean", ub);
			
			
			request.getRequestDispatcher("OP_success.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
