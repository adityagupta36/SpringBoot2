package com.aditya.learnspringframework.examples.a1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass{
	
//	@Autowired                       //field injection
	Dependency1 dependency1;
	
//	@Autowired                        //field injection
	Dependency2 dependency2;
	
	@Override
	public String toString() {
		return "YourBusinessClass [dependency1=" + dependency1 + ", dependency2=" + dependency2 + "]";
	}

	
//	@Autowired   // ==> if we use Const Injection , then @Autowired Annotation on GamingConsole is not required
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor Injection - set dependency");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	

//	@Autowired  
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("setter injection set dependency 1");
//		this.dependency1 = dependency1;
//	}
//
//	@Autowired  
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("setter injection set dependency 2");
//		this.dependency2 = dependency2;
//	}
	
	
	
	
	
	
	
}

@Component
class Dependency1{
	
}

@Component
class Dependency2{
	
}

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
			
			System.out.println(context.getBean(YourBusinessClass.class));
	
	
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}
}
