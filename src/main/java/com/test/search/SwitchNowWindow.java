package com.test.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SwitchNowWindow {
	public static List<String> swithnowwin( WebDriver driver){
		
		  Set sets=driver.getWindowHandles();
		  
		  List<String> hands = new ArrayList(sets);
		
		  return hands;
		
	}

}
