package com.export;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Sheet;
import jxl.Workbook;

import com.model.ConnDB;
import com.model.dingdanBean;
import com.model.giftBean;
import com.model.giftBeanOP;
import com.model.priceBean;
import com.model.priceBeanOP;
import com.model.ConnInport;

public class Inport_xls extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String file=request.getParameter("file");
		file=new String(file.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		String select=request.getParameter("daoruleixing");
		//System.out.println(select);
		select=new String(select.getBytes("iso-8859-1"),"utf-8");//��仰����Ҫ��������ת���
		
		String ip=request.getParameter("ip");
		
		
		
		System.out.println(ip);
		System.out.println(file);
		

		ConnInport gbb=new ConnInport();
		
		if(select.equals("��������")){
			gbb.getgift_xls(file);
		}
		if(select.equals("����ͻ�")){
			//gbb.getcus_xls(file);
		}
//		if(select.equals("����Ա��")){
//			gbb.getsales_xls(file);
//		}
//		if(select.equals("���붩��")){
//			gbb.getdingdan_xls(file);
//		}
//		if(select.equals("������˵�")){
//			gbb.getduizhang_xls(file);
//		}
//		if(select.equals("���뵥λ")){
//			gbb.getdanwei_xls(file);
//		}
//		if(select.equals("�������")){
//			gbb.getkeshi_xls(file);
//		}
//		if(select.equals("���뷢Ʊ")){
//			gbb.getfapiao_xls(file);
//		}
		if(select.equals("�����Ŷ�")){
//			gbb.getteam_xls(file);
		}
		
//			if(ub==false){
//				System.out.println("û���ȥ");
//				request.getRequestDispatcher("OP_fail.jsp").forward(request, response);
//			}
//			else {
//				//request.getSession().setAttribute("userBean", ub);
//				request.getRequestDispatcher("OP_success.jsp").forward(request, response);
//			}	
}
		

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
