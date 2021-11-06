package com.top.commons.config.db.jpa;

import com.top.commons.config.db.domain.CommonJpaContext;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

public class ToyJpaBasicConfig {

    @Bean(name = "toyBasicDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.toy")
    public DataSource toyDatasource() {
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean("toyJPABasicTransactionManager")
    public PlatformTransactionManager toyJPATransactionManager(EntityManagerFactory toyJPABasicEntityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(toyJPABasicEntityManagerFactory);

        return transactionManager;
    }

    @Bean("toyJPABasicEntityManagerFactory")
    public EntityManagerFactory toyJPAEntityManagerFactory(LocalContainerEntityManagerFactoryBean toyJPABasicEntityManagerFactoryBean) {
        return toyJPABasicEntityManagerFactoryBean.getObject();
    }

    @Bean("toyJPABasicEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean toyJPAEntityManagerFactoryBean(@Qualifier("toyBasicDatasource") DataSource datasource,
                                                                                 HibernateJpaVendorAdapter mysqlVendor,
                                                                                 CommonJpaContext toyBaseJPAContext) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJpaVendorAdapter(mysqlVendor);
        entityManagerFactoryBean.setDataSource(datasource);
        entityManagerFactoryBean.setPackagesToScan(toyBaseJPAContext.getBasePackages());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPersistenceUnitName("toyMysqlJPA");

        return entityManagerFactoryBean;
    }

    @Bean
    public HibernateJpaVendorAdapter mysqlVendor() {
        HibernateJpaVendorAdapter vendorApdater = new HibernateJpaVendorAdapter();
        vendorApdater.setShowSql(false);
        vendorApdater.setDatabase(Database.MYSQL);
        vendorApdater.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");
        return vendorApdater;
    }

}

