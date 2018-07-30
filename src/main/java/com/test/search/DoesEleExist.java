package com.test.search;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class DoesEleExist {
	
	//判断元素是否存在
		public static boolean doeswebElementExist(WebDriver driver, By selector){
			
			
			  try 
			        { 
			               driver.findElement(selector); 
			               return true; 
			        } 
			        catch (NoSuchElementException e) 
			        { 
			                 return false; 
			         } 
			
			
		}

}
