package com.test.search;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;












import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.openqa.selenium.JavascriptExecutor;

import com.gargoylesoftware.htmlunit.javascript.host.Window;

public class SavaPagePics {
	String urlpic="F:\\workspace\\PicSearchOnline\\pics";
	WebDriver driver=LaunchFirefoxTest.driver;
	
	
	public void savepics(String str[]) throws InterruptedException, AWTException, IOException{
		
	//	String picname=filename(str);
	//	String allname=urlpic+picname+".jpg";
		//URL picfile=new URL(urlpic);
		//File picdown=new File(urlpic+picname);
		
		
		
		//判断元素是否存在
		Boolean esele=DoesEleExist.doeswebElementExist(driver, By.xpath("//*[@id='J_goodsList']/ul[1]/li"));
		if(esele.equals(true)){
			
			System.out.println("商品存在！");
			
			Thread.sleep(3000);
			WebElement goods=driver.findElement(By.xpath("//*[@id='J_goodsList']/ul[1]/li"));
			
			
			goods.click();
			Thread.sleep(3000);
			testdownload(str,urlpic);

			
		}
		
		
	}
	
	public  void testdownload(String str[],String savapath) throws InterruptedException, AWTException, IOException{
	//	WebDriver driver=LaunchFirefoxTest.driver;
		Thread.sleep(3000);
		
		
		//	action.contextClick(first).perform();
		//	Pattern saveAs=new Pattern(allname);
			Actions action=new Actions(driver);
			

			
			//滑动关东条
			 JavascriptExecutor js = (JavascriptExecutor)driver;
		     
			
			 Robot robot = new Robot();
//			for(int i=0;i<45;i++){
//			robot.keyPress(KeyEvent.VK_DOWN);
//			Thread.sleep(1000);
//			//
//			}
			//
		//	driver.switchTo().defaultContent();
			 
			 
//			  Set sets=driver.getWindowHandles();
//			  
//			  List<String> hands = new ArrayList(sets);
			    //获得windows list
			 List<String> hands= SwitchNowWindow.swithnowwin(driver);

			    driver.switchTo().window(hands.get(hands.size()-1));
			    Thread.sleep(3000);
				//获取当前句柄
				  String handle = driver.getWindowHandle(); 
				  System.out.println("当前句柄："+handle);
				  
			    System.out.println("当前页面url："+driver.getCurrentUrl());
			    System.out.println("当前页面标题："+driver.getTitle());

			//    js.executeScript("window.scrollBy(0, 1500)");
			    //
			    List<String> urllist=new ArrayList<String>();
			    
			    
			
				js.executeScript("window.scrollBy(0, 800)");
				
				
				 
				Thread.sleep(5000);
			//	driver.switchTo().defaultContent();
				 
		     	Thread.sleep(2000);
		     	String ele1="//*[@id='1']";
//		     	String ele2="//img[start_with(@id,''J-detail-content'/div/img[')]";
//		     	String ele3="//img[contains(@src,'img')]";
//		     	String ele4="//*[@id='J-detail-content']/div/img[2]";
//		     	String ele5="//*[@id='J-detail-content']/div/img[4]";
		     	TestDownload.issave(js, driver, ele1, str, savapath);
		    	Thread.sleep(2000);
		     	String elen[];
		   // 	TestDownload.issave(js, driver, ele2, str, savapath);
		    	for(int i=2;i<6;i++){
		    		System.out.println("img i:"+i);
		    		String elens="//*[@id='J-detail-content']/div/img["+i+")]";
		    		
		    		TestDownload.issave(js, driver, elens, str, savapath);
		    		
		    		Thread.sleep(2000);
		    		
		    	}
//				Boolean esele1=DoesEleExist.doeswebElementExist(driver, By.xpath("//*[@id='1']"));	
//				//其他物品页面图片
//				Boolean ele1=DoesEleExist.doeswebElementExist(driver, By.xpath("//img[contains(@id,'J-detail-content')]"));
//				Thread.sleep(1000);
//					if(esele1.equals(true)){
//						Thread.sleep(1000);
//				  	
//	
//						List<WebElement> piclist=driver.findElements( By.xpath("//*[@id='1']"));
//						System.out.println("piclist.size:"+piclist.size());
//				      for(int m=1;m<piclist.size()+1;m++){
//				  		js.executeScript("window.scrollBy(0, 800)");
//				
//						String picname=TestDownload.filename(str,m);
//						Thread.sleep(3000);
//			
//			   
//			  //获取第一个图片  
//						String imgurl=piclist.get(m-1).getAttribute("src");
//						TestDownload.downloadpic(imgurl,picname,savapath);
//				
//						System.out.println("imgsrc_"+m+":"+imgurl);
//						Thread.sleep(3000);
//				
//				      }
//			
//					}
//					if(ele1.equals(true)){
//						
//						Thread.sleep(1000);
//					  	
//						
//					//	List<WebElement> piclist2=driver.findElements( By.xpath("//*[@id='J-detail-content']/div/img[2]"));
//						List<WebElement> piclist2=driver.findElements( By.xpath("//img[contains(@id,'J-detail-content')]"));
//						WebElement button = driver.findElement(By.xpath("//img[@alt='div1-img1']"));
//						System.out.println("piclist.size:"+piclist2.size());
//				      for(int m=1;m<piclist2.size()+1;m++){
//				  		js.executeScript("window.scrollBy(0, 800)");
//				
//						String picname=TestDownload.filename(str,m);
//						Thread.sleep(3000);
//			
//			   
//			  //获取第一个图片  
//						String imgurl=piclist2.get(m-1).getAttribute("src");
//						TestDownload.downloadpic(imgurl,picname,savapath);
//				
//						System.out.println("imgsrc_"+m+":"+imgurl);
//						Thread.sleep(3000);
//				
//				      }
////						
//					}
//					
//					else{
//						
//						System.out.println("没有查到页面图片元素信息！");
//					}
				//滚动到顶部	
					Thread.sleep(3000);
					js.executeScript("document.documentElement.scrollTop=0");
					Thread.sleep(3000);
					//关闭当前窗口，其实就是关闭详情页面
					driver.close();
//					  driver.switchTo().window(hands.get(0));
//					  Thread.sleep(3000);
				//	  System.out.println("当前页面标题："+driver.getTitle());
			
			
			
		
		
			
			
			
		
	}
	


//}
}
