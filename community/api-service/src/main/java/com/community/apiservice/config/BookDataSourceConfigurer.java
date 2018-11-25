package com.community.apiservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Auther: yanhan
 * @Date: 2018/10/24 16:24
 * @Description:
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryBook",//实体管理引用
        transactionManagerRef="transactionManagerBook",//失误管理引用
        basePackages = { "com.community.apiservice.jpa.book"} //设置用户数据源所应用到的包
)
public class BookDataSourceConfigurer {

    //注入用户数据源
    @Autowired
    @Qualifier("bookDataSource")
    private DataSource bookDataSource;



    //配置EntityManager实体
    @Bean(name = "entityManagerBook")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryBook(builder).getObject().createEntityManager();
    }

    //配置EntityManager工厂实体
    @Bean(name = "entityManagerFactoryBook")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBook (EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory =  builder.dataSource(bookDataSource)
                .packages("com.common.entity.book").persistenceUnit("userPersistenceUnit").build();
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        jpaProperties.put("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
        jpaProperties.put("hibernate.connection.charSet", "utf-8");
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.hbm2ddl.auto","update");
        entityManagerFactory.setJpaProperties(jpaProperties);
        return entityManagerFactory;
    }

    //配置事务
    @Bean(name = "transactionManagerBook")
    public PlatformTransactionManager transactionManagerBook(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryBook(builder).getObject());
    }

}
