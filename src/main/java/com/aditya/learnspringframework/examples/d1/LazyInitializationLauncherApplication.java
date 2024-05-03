package com.aditya.learnspringframework.examples.d1;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{
	
}

@Component
@Lazy         //whether a bean is to be lazily initialized.                    
class ClassB{
	private ClassA classA;

	public ClassB(ClassA classA) {
		System.out.println("Some Initialization Logic");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("do something");
	}
	
	
}
@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
	
	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
			
//			String [] ar = context.getBeanDefinitionNames();
//			for (String s : ar) {
//				System.out.println(s);
//			}
			
			
			System.out.println("Initialization of context is completed");

			context.getBean(ClassB.class).doSomething();
			
	
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}
}
