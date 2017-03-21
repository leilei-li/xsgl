package com.export;
import java.io.BufferedInputStream;  
import java.io.BufferedOutputStream;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import org.apache.commons.fileupload.DefaultFileItemFactory;  
import org.apache.commons.fileupload.FileItemFactory;  
import org.apache.commons.fileupload.FileItemIterator;  
import org.apache.commons.fileupload.FileItemStream;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload;  
import org.apache.commons.fileupload.util.Streams;

import com.model.ConnInport;
import com.model.giftBean;  


@WebServlet("/Inport_gift")
public class Inport_gift extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {  
  
    private static final long serialVersionUID = 1L;  
    File tmpDir = null;//��ʼ���ϴ��ļ�����ʱ���Ŀ¼  
    File saveDir = null;//��ʼ���ϴ��ļ���ı���Ŀ¼  
  public Inport_gift() {  
    super();  
  }       
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    doPost(request,response);  
  }       
    
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    try{  
        if(ServletFileUpload.isMultipartContent(request)){  
          DiskFileItemFactory dff = new DiskFileItemFactory();//�����ö���  
          dff.setRepository(tmpDir);//ָ���ϴ��ļ�����ʱĿ¼  
          dff.setSizeThreshold(1024000);//ָ�����ڴ��л������ݴ�С,��λΪbyte  
          ServletFileUpload sfu = new ServletFileUpload(dff);//�����ö���  
          sfu.setSizeMax(5000000);//ָ�������ϴ��ļ������ߴ�  
          sfu.setSizeMax(10000000);//ָ��һ���ϴ�����ļ����ܳߴ�  
          FileItemIterator fii = sfu.getItemIterator(request);//����request ����,������FileItemIterator����  
          ArrayList<giftBean> al=new ArrayList<giftBean>();
          while(fii.hasNext()){  
            FileItemStream fis = fii.next();//�Ӽ����л��һ���ļ���  
            if(!fis.isFormField() && fis.getName().length()>0){//���˵����з��ļ���  
            	String fileName = fis.getName();//����ϴ��ļ����ļ���
            	System.out.println(fileName);
                BufferedInputStream in = new BufferedInputStream(fis.openStream());//����ļ�������  
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(saveDir+fileName)));//����ļ������  
                Streams.copy(in, out, true);//��ʼ���ļ�д����ָ�����ϴ��ļ��� 
                //���ϴ��ļ�д�����ݿ�
                {
        		    ConnInport gbb=new ConnInport();
        		    
        			al=gbb.getgift_xls("up_"+fileName);
        		}
        		
        		
        		
            }  
          }
          request.setAttribute("upr_gift",al);
          request.getRequestDispatcher("upr_gift.jsp").forward(request, response);  
        }  
    }catch(Exception e){  
        e.printStackTrace();  
    }  
  }             
  
  public void init() throws ServletException {  
    /* ���ϴ��ļ��к���ʱ�ļ��н��г�ʼ�� 
    * 
    */  
    super.init();  
    String tmpPath = "/Users/lileilei/Desktop/model/upload/up_/";  
    String savePath ="/Users/lileilei/Desktop/model/upload/up_/";  
    tmpDir =new File(tmpPath);  
    saveDir = new File(savePath);  
    if(!tmpDir.isDirectory())  
        tmpDir.mkdir();  
    if(!saveDir.isDirectory())  
        saveDir.mkdir();     
  }     
}  