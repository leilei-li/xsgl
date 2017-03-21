package com.export;
import java.awt.List;
import java.io.BufferedInputStream;  
import java.io.BufferedOutputStream;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import com.model.kaoqingBean;  


@WebServlet("/Inport_kaoqing")
public class Inport_kaoqing extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {  
  
    private static final long serialVersionUID = 1L;  
    File tmpDir = null;//初始化上传文件的临时存放目录  
    File saveDir = null;//初始化上传文件后的保存目录  
  public Inport_kaoqing() {  
    super();  
  }       
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    doPost(request,response);  
  }       
    
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    try{  
        if(ServletFileUpload.isMultipartContent(request)){  
          DiskFileItemFactory dff = new DiskFileItemFactory();//创建该对象  
          dff.setRepository(tmpDir);//指定上传文件的临时目录  
          dff.setSizeThreshold(1024000);//指定在内存中缓存数据大小,单位为byte  
          ServletFileUpload sfu = new ServletFileUpload(dff);//创建该对象  
          sfu.setSizeMax(5000000);//指定单个上传文件的最大尺寸  
          sfu.setSizeMax(10000000);//指定一次上传多个文件的总尺寸  
          FileItemIterator fii = sfu.getItemIterator(request);//解析request 请求,并返回FileItemIterator集合  
          ArrayList<kaoqingBean> al=new ArrayList<kaoqingBean>();
          while(fii.hasNext()){  
            FileItemStream fis = fii.next();//从集合中获得一个文件流  
            if(!fis.isFormField() && fis.getName().length()>0){//过滤掉表单中非文件域  
            	String fileName = fis.getName();//获得上传文件的文件名
            	System.out.println(fileName);
                BufferedInputStream in = new BufferedInputStream(fis.openStream());//获得文件输入流  
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(saveDir+fileName)));//获得文件输出流  
                Streams.copy(in, out, true);//开始把文件写到你指定的上传文件夹 
                //将上传文件写入数据库
                Date date1 = new Date();
    			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    			String time = format.format(date1);
    			String date = time;
                {
        		    ConnInport gbb=new ConnInport();
        		    
        			al=gbb.getkaoqing("/Users/lileilei/Desktop/model/upload/up_"+fileName,date);
        		}
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
                request.getRequestDispatcher("upr_kaoqing.jsp").forward(request, response); 
        		
        		
            }  
          }
//          request.setAttribute("upr_gift",al);
//          request.getRequestDispatcher("upr_gift.jsp").forward(request, response);  
        }  
    }catch(Exception e){  
        e.printStackTrace();  
    }  
  }             
  
  public void init() throws ServletException {  
    /* 对上传文件夹和临时文件夹进行初始化 
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