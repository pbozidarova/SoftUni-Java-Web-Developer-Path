package beanpuzzle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BeanpuzzleApplication {

    @Autowired
    MyConfiguration myconfig;

    @Autowired
    MyBean anAutowiredBean;

    public static void main(String[] args) {
        SpringApplication.run(BeanpuzzleApplication.class, args);
    }

    @PostConstruct
    private void postConstructor(){
        anAutowiredBean.sayHello();
        MyBean myOtherBean = myconfig.getAnotherBean();
        myOtherBean.sayHello();

        System.out.println(anAutowiredBean.hashCode());
        System.out.println(myOtherBean.hashCode());

        System.out.println(myOtherBean == anAutowiredBean);
    }
}

@Configuration
class MyConfiguration{
    @Bean
    public MyBean getMyBean(){
        return new MyBean();
    }

    public MyBean getAnotherBean(){
        return getMyBean();
    }

}

class MyBean{

    public MyBean() {
        System.out.println("I am the constructor of my bean! " + this.hashCode());
    }

    public void sayHello(){
        System.out.println("Hello, from me! My hash code is: " + this.hashCode());
    }
}
