package com.aditya.learnspringframework.examples.h1;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aditya.learnspringframework.game.GameRunner;



public class XmlConfigurationContextLauncherApplication {
	
	public static void main(String[] args) {
		
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
//			context.getBean(GamingConsole.class).up();
			
			
			String [] ar = context.getBeanDefinitionNames();
			for (String s : ar) {
				System.out.println(s);
			}
			
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			
			context.getBean(GameRunner.class).run();;
	
	
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}
}
