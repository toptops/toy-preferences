package com.top.toypreference.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

//@Import({ToyDatasourceConfig.class})
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "toyJPAEntityManagerFactory",
        transactionManagerRef = "toyJPATransactionManager")
public class ToyJPAConfig {

    @Bean("toyJPATransactionManager")
    public PlatformTransactionManager toyJPATransactionManager(EntityManagerFactory toyJPAEntityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(toyJPAEntityManagerFactory);

        return transactionManager;
    }

    @Bean("toyJPAEntityManagerFactory")
    public EntityManagerFactory toyJPAEntityManagerFactory(LocalContainerEntityManagerFactoryBean toyJPAEntityManagerFactoryBean) {
        return toyJPAEntityManagerFactoryBean.getObject();
    }

    @Bean("toyJPAEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean toyJPAEntityManagerFactoryBean(@Qualifier("toyDatasource") DataSource datasource,
                                                                                 HibernateJpaVendorAdapter mysqlVendor,
                                                                                 ToyJPARegister toyJPARegister) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJpaVendorAdapter(mysqlVendor);
        entityManagerFactoryBean.setDataSource(datasource);
        entityManagerFactoryBean.setPackagesToScan(toyJPARegister.getEntityBasePackages());
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

