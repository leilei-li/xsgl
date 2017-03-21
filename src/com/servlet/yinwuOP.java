package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.jar.Attributes.Name;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.*;

import jxl.write.DateFormat;

@WebServlet("/yinwuOP")

public class yinwuOP extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");
		// System.out.println(action);
		action = new String(action.getBytes("iso-8859-1"), "utf-8");// 这句话很重要，是用来转码的

		if (action.equals("init")) {
			request.getRequestDispatcher("yinwu_select_cus_init.jsp").forward(request, response);
		}
		if (action.equals("getCus")) {

			String cus_ID = request.getParameter("cus_ID");
			cus_ID = new String(cus_ID.getBytes("iso-8859-1"), "utf-8");
			String cus_name = request.getParameter("cus_name");
			cus_name = new String(cus_name.getBytes("iso-8859-1"), "utf-8");
			String keshi_name = request.getParameter("keshi_name");
			keshi_name = new String(keshi_name.getBytes("iso-8859-1"), "utf-8");
			String danwei_name = request.getParameter("danwei_name");
			danwei_name = new String(danwei_name.getBytes("iso-8859-1"), "utf-8");

			cusBeanOP tbb = new cusBeanOP();
			cusBean tb = null;
			ArrayList<cusBean> al = null;
			al = tbb.getcus_duo(cus_ID, cus_name, keshi_name, danwei_name);
			if (al.size() > 0) {
				// System.out.print("nihao");
				request.setAttribute("cusArray", al);
				request.getRequestDispatcher("yinwu_select_cus.jsp").forward(request, response);
			} else {

				request.getRequestDispatcher("no_info.jsp").forward(request, response);
			}
		}
		if (action.equals("newPage")) {
			String info = request.getParameter("info");
			info = new String(info.getBytes("iso-8859-1"), "utf-8");
			String cus_ID = request.getParameter("cus_ID");
			cus_ID = new String(cus_ID.getBytes("iso-8859-1"), "utf-8");
			request.setAttribute("cus_ID", cus_ID);
			request.setAttribute("info", info);
			request.getRequestDispatcher("yinwu_new.jsp").forward(request, response);

		}
		if (action.equals("newYinwu")) {
			String cus_ID = request.getParameter("cus_ID");
			cus_ID = new String(cus_ID.getBytes("iso-8859-1"), "utf-8");
			String yinwu_name = request.getParameter("yinwu_name");
			yinwu_name = new String(yinwu_name.getBytes("iso-8859-1"), "utf-8");
			String isMu = request.getParameter("isMu");
			isMu = new String(isMu.getBytes("iso-8859-1"), "utf-8");
			String nongdu = request.getParameter("style");// 浓度
			nongdu = new String(nongdu.getBytes("iso-8859-1"), "utf-8");
			String type = request.getParameter("type");
			type = new String(type.getBytes("iso-8859-1"), "utf-8");
			String yinwu_num = request.getParameter("yinwu_num");
			yinwu_num = new String(yinwu_num.getBytes("iso-8859-1"), "utf-8");
			String yinwu_laiyuan = request.getParameter("yinwu_laiyuan");
			yinwu_laiyuan = new String(yinwu_laiyuan.getBytes("iso-8859-1"), "utf-8");
			String beizhu;
			String name_num[] = yinwu_name.split(",");
			for (int i = 0; i < name_num.length; i++) {
				yinwu_name = name_num[i];
				int new_num, old_num;
				Date date1 = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yMMdd");
				String time = format.format(date1);
				String date = time;
				time = time.substring(time.length() - 5, time.length());
				new_num = Integer.parseInt(time);
				old_num = Integer.parseInt(time);
				int location = Integer.parseInt(time);
				if (isMu.equals("是")) {
					new_num = new_num * 10 + 1;
					beizhu="母液";
				} else {
					new_num = new_num * 10 + 0;
					beizhu="非母液";
				}
				// System.out.println(new_num);
				location = location * 1000 + 1;
				String test;
				yinwuBean isUsed = null;
				yinwuBeanOP y = new yinwuBeanOP();
				test = String.valueOf(location);
				isUsed = y.getYinwu_location(test);
				while (isUsed != null) {
					location = location + 1;
					test = String.valueOf(location);
					// System.out.println(test);
					isUsed = y.getYinwu_location(test);
				}
				int location_bian1 = location % 1000;
				String location_bian = new DecimalFormat("000").format(location_bian1);
				String location1 = String.valueOf(location);
				String str_new = "Y" + String.valueOf(new_num) + location_bian;
				String str_old = "Y" + String.valueOf(old_num) + location_bian;
				// boolean createSuccess = false;
				y.creatYinwu(yinwu_name, str_new, str_old, location1, cus_ID, type, nongdu, yinwu_num, date,yinwu_laiyuan, beizhu);
			}

			// if (createSuccess == true) {
			request.getRequestDispatcher("OP_success.jsp").forward(request, response);
			// } else {
			// request.getRequestDispatcher("OP_fail.jsp").forward(request,
			// response);
			// }
		}
		if (action.equals("searchYinwu")) {
			String new_num = request.getParameter("new_num");
			new_num = new String(new_num.getBytes("iso-8859-1"), "utf-8");
			String old_num = request.getParameter("old_num");
			old_num = new String(old_num.getBytes("iso-8859-1"), "utf-8");
			String start_time = request.getParameter("start_date");
			start_time = new String(start_time.getBytes("iso-8859-1"), "utf-8");
			String end_time = request.getParameter("end_date");
			end_time = new String(end_time.getBytes("iso-8859-1"), "utf-8");
			String keshi = request.getParameter("keshi");
			keshi = new String(keshi.getBytes("iso-8859-1"), "utf-8");
			String danwei = request.getParameter("danwei");
			danwei = new String(danwei.getBytes("iso-8859-1"), "utf-8");
			String cus_name = request.getParameter("cus_name");
			cus_name = new String(cus_name.getBytes("iso-8859-1"), "utf-8");
			String name = request.getParameter("name");
			name = new String(name.getBytes("iso-8859-1"), "utf-8");

			if (start_time.equals("--请选择--")) {
				start_time = "20160901";
			}
			// System.out.println(start_time+end_time);
			yinwuBeanOP y = new yinwuBeanOP();
			ArrayList<yinwuBean> yinwuList = null;
			yinwuList = y.getYinwu(new_num, old_num, start_time, end_time, keshi, danwei, cus_name, name);
			if (yinwuList.size() > 0) {
				request.setAttribute("yinwuList", yinwuList);
				request.getRequestDispatcher("yinwu_info_brife.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("no_info.jsp").forward(request, response);
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
