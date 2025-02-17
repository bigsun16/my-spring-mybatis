package qihui.sun.spring;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

public class MapperFactoryBean implements FactoryBean<Object> {
    private SqlSession sqlSession;
    private final Class<?> mapperClass;

    public MapperFactoryBean(Class<?> mapperClass) {
        this.mapperClass = mapperClass;
    }

    @Autowired
    public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addMapper(mapperClass);
        this.sqlSession = sqlSessionFactory.openSession();
    }

    @Override
    public Object getObject() {
        return sqlSession.getMapper(mapperClass);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperClass;
    }
}
