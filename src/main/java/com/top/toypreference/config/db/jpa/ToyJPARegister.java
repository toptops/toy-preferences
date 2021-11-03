package com.top.toypreference.config.db.jpa;

import com.top.toypreference.config.db.annotation.EnableToyJPARegister;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class ToyJPARegister implements ImportBeanDefinitionRegistrar {

    private String[] entityBasePackages;
    private String[] repositoryBasePackages;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> metaData = importingClassMetadata.getAnnotationAttributes(EnableToyJPARegister.class.getName());
        String[] entityBasePackages = (String[]) metaData.get("entityBasePackages");
        String[] repositoryBasePackages = (String[]) metaData.get("repositoryBasePackages");
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(ToyJPARegister.class);
        bdb.addPropertyValue("entityBasePackages", entityBasePackages);
        bdb.addPropertyValue("repositoryBasePackages", repositoryBasePackages);
        registry.registerBeanDefinition("toyJPARegister", bdb.getBeanDefinition());
    }

    public String[] getEntityBasePackages() {
        return entityBasePackages;
    }

    public void setEntityBasePackages(String[] entityBasePackages) {
        this.entityBasePackages = entityBasePackages;
    }

    public String[] getRepositoryBasePackages() {
        return repositoryBasePackages;
    }

    public void setRepositoryBasePackages(String[] repositoryBasePackages) {
        this.repositoryBasePackages = repositoryBasePackages;
    }
}
