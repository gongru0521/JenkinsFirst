package com.test.search;


import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class AllAction {
	WebDriver driver=LaunchFirefoxTest.driver;
	//获得元素定位，根据参数type
	GetElementAll getelemess=new GetElementAll();
	
	 //获取系统时间
	
	 public String getTime(){

	        String stime=null;
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	        stime=df.format(new Date()).toString();

	        return stime;
	    }
	//根据断言判断结果
	public String juidestr(String asserstr,String casename){
		String result=null;
		
		if(asserstr.equals("null")){
			
			result=casename+";"+"没有添加断言;"+"PASS;"+getTime();
			
			
		}
		else{
			
		//	WebElement  weasser=driver.findElement(By.name(asserstr));
			//根据页面标题进行断言信息判断
			String pagetitle=driver.getTitle();
			
			if(pagetitle.contains(asserstr)){
				
				result=casename+";"+"添加断言:"+asserstr+";"+"PASS;"+getTime();
				
			}
			else{
				
				result=casename+";"+"添加断言;"+asserstr+";"+"FAIL;"+getTime();
			}
				
			
		}
		
		
		return result;
		
		
		
	}
	//第二个参数是edit时，执行该方法
	public String editcontent(String element,String typeele,String action,String asserstr,String time,String casename,String content) throws InterruptedException{
		String result=null;
		
		
		Thread.sleep(1000);
	
		//获得元素信息定位
		WebElement we=getelemess.getallelement(element, typeele);

			if(we!=null){
			we.sendKeys(content);
			//判断断言信息
			
			result=juidestr(asserstr,casename);
			
			}
			else{
			result=casename+":FAIL;"+"这个元素不存在!"+getTime();	
				
			}
				
			
		
		Thread.sleep(1000);
		
		
		return result;
		
}
	//第二个参数是click时，执行该方法
	/*
	public String clickaction(String element,String typeele,String action,String asserstr,String time,String casename) throws InterruptedException{
		String result=null;
		Thread.sleep(1000);
		WebElement we=getelemess.getallelement(element, typeele);
		
		
			if(we!=null){
			we.click();
			//判断断言信息
			
			result=juidestr(asserstr,casename);
			}
			else{
				result=casename+":FAIL;"+"这个元素不存在!"+getTime();	
				
			}
				
			
		
		Thread.sleep(1000);
		
		
		return result;
		
	}
	*/
	public String clickaction(String arg[]){
		String result=null;
		
		WebElement we=getelemess.getallelement(arg[0], arg[1]);
		if(we!=null){
			we.click();
			//判断断言信息
			
			result=juidestr(arg[3],arg[5]);
			}
			else{
				result=arg[5]+":FAIL;"+"这个元素不存在!"+getTime();	
				
			}
		
		
		return result;
		
		
		
	}
	

}
