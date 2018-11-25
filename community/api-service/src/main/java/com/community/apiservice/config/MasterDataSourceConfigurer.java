package com.community.apiservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

/**
 * @Auther: yanhan
 * @Date: 2018/10/24 16:24
 * @Description:
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryMaster",//实体管理引用
        transactionManagerRef="transactionManagerMaster",//失误管理引用
        basePackages = { "com.community.apiservice.jpa.master"} //设置用户数据源所应用到的包
)
public class MasterDataSourceConfigurer {

    //注入用户数据源
    @Autowired
    @Qualifier("masterDataSource")
    private DataSource masterDataSource;



    //配置EntityManager实体
    @Bean(name = "entityManagerMaster")
    @Primary
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryMaster(builder).getObject().createEntityManager();
    }

    //配置EntityManager工厂实体
    @Bean(name = "entityManagerFactoryMaster")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryMaster (EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory =  builder.dataSource(masterDataSource)
                .packages("com.common.entity.master").persistenceUnit("userPersistenceUnit").build();
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
    @Bean(name = "transactionManagerMaster")
    @Primary
    public PlatformTransactionManager transactionManagerMaster(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryMaster(builder).getObject());
    }


}
