package qihui.sun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import qihui.sun.service.CatService;
import qihui.sun.service.OrderService;
import qihui.sun.service.UserService;

public class Main {
    public static void main(String[] args) {
        /*AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AppConfig.class);

        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(MapperFactoryBean.class);
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
        applicationContext.registerBeanDefinition("userMapper", beanDefinition);

        applicationContext.refresh();*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.select();
        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        orderService.select();
        CatService catService = (CatService) applicationContext.getBean("catService");
        catService.select();


    }
}