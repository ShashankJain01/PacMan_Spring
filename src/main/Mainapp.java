package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext  ;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

public class Mainapp {
	

	public static void main(String[] args){
		
		  AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");     
	      GridDetails gd=(GridDetails) context.getBean("gridDetails");	  
	      
	      //Click one time for PacMan movement, for multiple times can be embedded in for loop
	      gd.PacPosition();
	}	
}
