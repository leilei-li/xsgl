package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.model.userBean;
import com.model.userBeanOP;
import com.model.cusBean;
import com.model.cusBeanOP;

public class loginClServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		System.out.println(time);
		
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(userName);
		userName=new String(userName.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		userBean ub=null;
		userBeanOP ubb=new userBeanOP();
		ub=ubb.getUserInfo(userName, password);
		String quanxian;
		String type;
		if(ub==null){
			//System.out.println("2222");
			request.getRequestDispatcher("login_fail.jsp").forward(request, response);
		}
		else{
			ubb.creatlogin_log(userName, time);
			type=ub.getType();
			System.out.println(type);
			request.getSession().setAttribute("userBean", ub);
			request.getSession().setAttribute("userName",userName);
			request.getSession().setAttribute("type",type);
			if(type.equals("admin")) {
				quanxian="管理员";
				request.getSession().setAttribute("quanxian",quanxian); 
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
			else if(type.equals("caiwu"))
			{
				quanxian="财务";
				request.getSession().setAttribute("quanxian",quanxian); 
				request.getRequestDispatcher("main_caiwu.jsp").forward(request, response);
			}
			else if(type.equals("chuna"))
			{
				quanxian="出纳";
				request.getSession().setAttribute("quanxian",quanxian); 
				request.getRequestDispatcher("main_chuna.jsp").forward(request, response);
			}
			else if(type.equals("houqing"))
			{
				quanxian="后勤";
				request.getSession().setAttribute("quanxian",quanxian); 
				request.getRequestDispatcher("main_houqing.jsp").forward(request, response);
			}
			else if(type.equals("yewu"))
			{
				quanxian="业务";
				request.getSession().setAttribute("quanxian",quanxian); 
				request.getRequestDispatcher("main_yewu.jsp").forward(request, response);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
