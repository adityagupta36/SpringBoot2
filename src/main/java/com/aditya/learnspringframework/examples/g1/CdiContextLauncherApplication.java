package com.aditya.learnspringframework.examples.g1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
class BusinessService{
	
	private DataService dataservice;
	
//	@Autowired
	@Inject
	public void setDataService(DataService dataservice) {
		
		System.out.println("Setter Injection");
		this.dataservice=dataservice;
		
	}
	
	public DataService getDataService() {
		return dataservice;
	}
	
}


//@Component
@Named
class DataService{
	
	
}


@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
	
	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)) {
			
			
			String [] ar = context.getBeanDefinitionNames();
			for(String s: ar) {
				System.out.println(s);
			}

			System.out.println(context.getBean(BusinessService.class).getDataService());
			
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}
}
