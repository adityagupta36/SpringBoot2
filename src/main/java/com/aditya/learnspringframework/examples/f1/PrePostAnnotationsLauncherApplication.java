package com.aditya.learnspringframework.examples.f1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass{
	
	private SomeDependency someDependency;

	public SomeClass(SomeDependency someDependency) {
		System.out.println("All dependencies are ready!");
		this.someDependency = someDependency;
	}
	
	//used on a method that needs to be executed after dependency injection is done to perform any initialization
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	//example==>closing db connections
	@PreDestroy                               //instance is in the process of being removed by the container.
	public void cleanup() {
		System.out.println("Clean Up");
	}
}

@Component
class SomeDependency{

	public void getReady() {
		System.out.println("Some logic using SomeDependency");
		
	}  
	
}

@Configuration
@ComponentScan
public class PrePostAnnotationsLauncherApplication {
	
	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostAnnotationsLauncherApplication.class)) {
//			

			
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}
}
