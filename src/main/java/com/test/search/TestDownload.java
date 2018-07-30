package com.test.search;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestDownload {

public static String filename(String str[],int i){
		
		String filename=null;
		
		
		
		filename=str[0]+"_"+i+".jpg";
		return filename;
		
	}

	
	public static void downloadpic(String imgurl,String filename,String savepath) throws IOException{
		
		URL url=new URL(imgurl);
		
		URLConnection con = url.openConnection();  
        //设置请求超时为5s  
        con.setConnectTimeout(5*1000);  
        // 输入流  
        InputStream is = con.getInputStream();  
      
        // 1K的数据缓冲  
        byte[] bs = new byte[1024];  
        // 读取到的数据长度  
        int len;  
        // 输出的文件流  
       File sf=new File(savepath);  
       if(!sf.exists()){  
           sf.mkdirs();  
       }  
       OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename);  
        // 开始读取  
        while ((len = is.read(bs)) != -1) {  
          os.write(bs, 0, len);  
        }  
        // 完毕，关闭所有链接  
        os.close();  
        is.close();  
    }
	
	//如果图片元素存在保存图片
	
	
public static void 	issave(JavascriptExecutor js,WebDriver driver,String ele,String str[],String savapath) throws IOException, InterruptedException{
	

	Boolean esele1=DoesEleExist.doeswebElementExist(driver, By.xpath(ele));

	Thread.sleep(1000);
	 System.out.println("下载图片页面标题："+driver.getTitle());
	if(esele1.equals(true)){
	      Thread.sleep(1000);
	  	

		  List<WebElement> piclist=driver.findElements( By.xpath(ele));
			System.out.println("piclist.size:"+piclist.size());
	      for(int m=1;m<piclist.size()+1;m++){
	  		js.executeScript("window.scrollBy(0, 800)");
	
			String picname=TestDownload.filename(str,m);
			Thread.sleep(3000);

   
  //获取第一个图片  
			String imgurl=piclist.get(m-1).getAttribute("src");
			downloadpic(imgurl,picname,savapath);
	
			System.out.println("imgsrc_"+m+":"+imgurl);
			Thread.sleep(3000);
	
	      }

		}
	else{
		
		System.out.println("没有获取图片元素！");
	}
	
	
	
}

	
	
}
