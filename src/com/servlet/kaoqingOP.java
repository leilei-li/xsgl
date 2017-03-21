package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.*;

import jxl.write.DateFormat;

@WebServlet("/kaoqingOP")

public class kaoqingOP extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");
		// System.out.println(action);
		action = new String(action.getBytes("iso-8859-1"), "utf-8");// 这句话很重要，是用来转码的

		if (action.equals("search")) {

			String date = request.getParameter("date");
			date = new String(date.getBytes("iso-8859-1"), "utf-8");

			kaoqingBeanOP tbb = new kaoqingBeanOP();
			ArrayList<kaoqingBean> al = null;
			al = tbb.getKaoqing(date);
			if (al.size() > 0) {
				// System.out.print("nihao");
				ArrayList nameList = new ArrayList();
        		int alSize=al.size();
        		for(int i =0;i<alSize;i++){//得到不重复的名单
        			if(nameList.contains(al.get(i).getSales_name())){
        				continue;
        			}
        			else{
        				nameList.add(al.get(i).getSales_name());
        			}
        		}
        		request.setAttribute("nameList",nameList);
        		request.setAttribute("kaoqing",al);
        		request.setAttribute("date", date);
                request.getRequestDispatcher("kaoqing_info_brife.jsp").forward(request, response); 
			} else {

				request.getRequestDispatcher("no_info.jsp").forward(request, response);
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
