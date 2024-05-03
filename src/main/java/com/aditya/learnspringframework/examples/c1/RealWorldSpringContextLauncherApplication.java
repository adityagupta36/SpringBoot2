package com.aditya.learnspringframework.examples.c1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

//@Component
@Service
interface DataService{
   int [] retrieveData();

}

//@Component
@Repository
class MongoDbDataService implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[] {1,2,3,4,5};
    }

}

//@Component
@Repository
@Primary
class MysqlDataService implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[]{11,22,33,44,55};
    }

}
//@Component
@Service
class BusinessCalculationService {
	
    DataService dataService;
    
    //constructor injection
    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}

@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(RealWorldSpringContextLauncherApplication.class);

        System.out.println(c.getBean(BusinessCalculationService.class).findMax());

    }

}
