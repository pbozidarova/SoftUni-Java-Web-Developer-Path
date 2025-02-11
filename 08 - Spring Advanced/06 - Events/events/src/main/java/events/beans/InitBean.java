package events.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

//@Component
public class InitBean implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("I am being destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("All my properties are set and I am ready!");
    }
}
