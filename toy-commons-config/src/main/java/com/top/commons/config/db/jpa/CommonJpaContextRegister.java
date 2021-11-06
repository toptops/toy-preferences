package com.top.commons.config.db.jpa;

import com.top.commons.annotation.EnableToyJpaConfiguration;
import com.top.commons.config.db.domain.CommonJpaContext;
import com.top.commons.config.db.enums.ToyJpaModule;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class CommonJpaContextRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> metaData = importingClassMetadata.getAnnotationAttributes(EnableToyJpaConfiguration.class.getName());
        String[] entityBasePackages = (String[]) metaData.get("entityBasePackages");
        String[] repositoryBasePackages = (String[]) metaData.get("repositoryBasePackages");
        ToyJpaModule module = (ToyJpaModule) metaData.get("module");
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(CommonJpaContext.class);
        bdb.addPropertyValue("entityBasePackages", entityBasePackages);
        bdb.addPropertyValue("repositoryBasePackages", repositoryBasePackages);
        registry.registerBeanDefinition(module.name() + "JPAContext", bdb.getBeanDefinition());
    }
}
