package qihui.sun.spring;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

public class MapperScanner extends ClassPathBeanDefinitionScanner {
    public MapperScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
        for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
            BeanDefinition beanDefinition = beanDefinitionHolder.getBeanDefinition();
            // 设置 MapperFactoryBean 的泛型参数类型，即 Mapper 接口类型。
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
            // 设置FactoryBean 的类型为 MapperFactoryBean。因为 MapperFactoryBean 实现了 FactoryBean，所以 Spring 会通过调用其 getObject 方法来创建对象。
            beanDefinition.setBeanClassName(MapperFactoryBean.class.getName());
        }
        return beanDefinitionHolders;
    }
}
