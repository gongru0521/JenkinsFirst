package com.test.search;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search {
	
	ReadAndWrCSV rw=new ReadAndWrCSV();
	LaunchFirefoxTest la=new LaunchFirefoxTest();
	WebDriver driver=LaunchFirefoxTest.driver;
	
//	public void getkeys(String url) throws Exception{
//		List<String> wordslist=FileString(url);
//		
//		
//		
//	}
	public List<String> FileString(String url) throws Exception{
		
		//获得csv中的元素信息
		List<String> gotfilelist=rw.ReadAnd(url);
		//�?有的测试结果
		List<String> resultback=new ArrayList();
		//设置分割的字符串数组的长�?
		String strline[]=new String[2];
		String ss=null; 
		String ll;
		
		Iterator  ite=gotfilelist.iterator();
		while(ite.hasNext()){
			ss=(String) ite.next();
			strline=ss.split(";");
			//获得每行的测试结�?
			ll=searchwords(strline);
			System.out.println("result:"+ll);
			
			resultback.add(ll);
			//切换到首页进行搜索
			List<String> hands=SwitchNowWindow.swithnowwin(driver);
			driver.switchTo().window(hands.get(0));
			System.out.println("当前页面："+driver.getTitle());
			
			
		}
		
		
		return resultback;
		
		
		
	}

	
	public String searchwords(String str[]) throws InterruptedException, AWTException, IOException{
		
	
		
		//保存图片
		SavaPagePics savapic=new SavaPagePics();
		
		//la.testlaunch();
		Thread.sleep(3000);
		
		String result=null;
		
	
		
		WebElement word=driver.findElement(By.xpath("//*[@id='key']"));
		String pagetitle=driver.getTitle();
		
		word.clear();
		Thread.sleep(3000);
		String sendstr=str[1].replace(" ", ",");
		
		word.sendKeys(sendstr);
		
		Thread.sleep(3000);
		
       
		//搜索结果页面搜索
		Boolean searchresultpage=DoesEleExist.doeswebElementExist(driver,By.cssSelector("#search-2014 > div > button > i"));
		
		//商品详情页面点击搜索按钮	
		Boolean goodspage=DoesEleExist.doeswebElementExist(driver,By.cssSelector("//*[@id='search-2014']/div/button[1]"));
        
		
		
		//在网站首页搜索
		
		if(pagetitle.contains("京东(JD.COM)-正品低价、品质保障、配送及时、轻松购物！")){
			 WebElement searchbutton=driver.findElement(By.xpath("//*[@id='search']/div/div[2]/button/i"));
			 searchbutton.click();
			
			
		}
		else{
			System.out.println("其他页面搜索");
			
			
			//*[@id="search-2014"]/div/button[1]
		//	
			//在搜索结果页面搜索
			
		   if(searchresultpage.equals(true)){
			   WebElement searchbutton2=driver.findElement(By.cssSelector("#search-2014 > div > button > i"));
			   
			   searchbutton2.click();
		   }	
//		   //商品详情页面搜索
//		   else {
//		    if(goodspage.equals(true)){
//			   System.out.println("订单详情页面搜索");
//			   WebElement searchbutton3=driver.findElement(By.cssSelector("//*[@id='search-2014']/div/button[1]"));
//			   
//			   searchbutton3.click();
//		      }	
//		   }
		   
		   //在商品页搜索
			
		}
		
		Thread.sleep(3000);
		String nomessage="汪~没有找到";
	
		//错误信息
	//	WebElement errormessage=driver.findElement(By.className("check-error"));
		
		//*[@id="J_searchWrap"]/div[2]
		Boolean ele=DoesEleExist.doeswebElementExist(driver,By.className("check-error"));
		
		if(ele.equals(true)){
			result=str[0]+";"+str[1]+";"+"无！";
			Thread.sleep(3000);
			
			
		}
		else{
			
			result=str[0]+";"+str[1]+";"+"有！";
			Thread.sleep(3000);
			//调用保存图片方法
			savapic.savepics(str);
			
			
			
		}
		
		
		
		return result;
		
	}
	

}
