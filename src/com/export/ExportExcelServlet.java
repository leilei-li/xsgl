package com.export;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ����Servlet����Excel
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
              request.setCharacterEncoding("utf-8");//����request�ı��뷽ʽ����ֹ��������
              String fileName ="test.xls";//���õ������ļ�����
              StringBuffer sb = new StringBuffer(request.getParameter("tableInfo"));//�������Ϣ�����ڴ�
              System.out.println(request.getParameter("tableInfo"));
              String contentType = "application/vnd.ms-excel";//���嵼���ļ��ĸ�ʽ���ַ���
              String recommendedName = new String(fileName.getBytes(),"iso_8859_1");//�����ļ����Ƶı����ʽ
              response.setContentType(contentType);//���õ����ļ���ʽ
              response.setHeader("Content-Disposition", "attachment; filename="+fileName);
              response.resetBuffer();
              //������������������ļ�
              ServletOutputStream sos = response.getOutputStream();
              sos.write(sb.toString().getBytes());
              sos.flush();
              sos.close();
       }
}