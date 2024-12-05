package qihui.sun;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import qihui.sun.spring.MapperBeanDefinitionRegistrar;
import qihui.sun.spring.MapperScan;

import java.io.IOException;
import java.io.InputStream;

@Configuration
@ComponentScan("qihui.sun")
@Import(MapperBeanDefinitionRegistrar.class)
@MapperScan("qihui.sun.mapper")
public class AppConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
}
