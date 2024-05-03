package com.aditya.learnspringframework.examples.a0;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {
	
	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {
//			context.getBean(GamingConsole.class).up();
			
			
			String [] ar = context.getBeanDefinitionNames();
			for (String s : ar) {
				System.out.println(s);
			}
	
	
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}
}
