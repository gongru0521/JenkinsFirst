package com.test.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class GetElementAll {
	WebDriver driver=LaunchFirefoxTest.driver;
	//根据不同元素类型，获得不同的元素对象
	public  WebElement getallelement(String element,String typeelement){
		String type=typeelement;
		System.out.println("element:"+element);
		System.out.println("typeelement:"+typeelement);
		WebElement we=null;
		//定位元素的方式:id,name,xpath,link,css,class,TagName
		switch(type){
		case "xpath":
			we=driver.findElement(By.xpath(element));
			break;
			// driver.findElement(By.xpath(element));
		
		case "id":
			we=driver.findElement(By.id(element));
			break;
		case "name":
			we=driver.findElement(By.name(element));
			break;
		case "link":
			we=driver.findElement(By.partialLinkText(element));
			break;
		case "css":
			we=driver.findElement(By.cssSelector(element));
			
			break;
		case "class":
			we=driver.findElement(By.className(element));
			break;
		case "TagName":
			we=driver.findElement(By.tagName(element));
			break;
			
		}
		System.out.println("we:"+we);
		return we;
		
		
		
	}

}
