package com.export;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 利用Servlet导出Excel
 * @author CHUNBIN
 *
 */
public class ExportExcelServlet extends HttpServlet {
      
       public void doGet(HttpServletRequest request, HttpServletResponse response)
                     throws ServletException, IOException {
              doPost(request, response);
       }
 
       public void doPost(HttpServletRequest request, HttpServletResponse response)
                     throws ServletException, IOException {
    	   	  //response.setContentType("text/html;charset=utf-8");
              request.setCharacterEncoding("utf-8");//设置request的编码方式，防止中文乱码
              String fileName ="test.xls";//设置导出的文件名称
              StringBuffer sb = new StringBuffer(request.getParameter("tableInfo"));//将表格信息放入内存
              System.out.println(request.getParameter("tableInfo"));
              String contentType = "application/vnd.ms-excel";//定义导出文件的格式的字符串
              String recommendedName = new String(fileName.getBytes(),"iso_8859_1");//设置文件名称的编码格式
              response.setContentType(contentType);//设置导出文件格式
              response.setHeader("Content-Disposition", "attachment; filename="+fileName);
              response.resetBuffer();
              //利用输出输入流导出文件
              ServletOutputStream sos = response.getOutputStream();
              sos.write(sb.toString().getBytes());
              sos.flush();
              sos.close();
       }
}