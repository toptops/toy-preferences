package com.top.commons.config.db.jpa;

import com.top.commons.annotation.EnableJpaConfiguration;
import com.top.commons.config.db.domain.CommonJpaContext;
import com.top.commons.config.db.enums.JpaModule;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class CommonJpaContextRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> metaData = importingClassMetadata.getAnnotationAttributes(EnableJpaConfiguration.class.getName());
        String[] basePackages = (String[]) metaData.get("basePackages");
        JpaModule module = (JpaModule) metaData.get("module");
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(CommonJpaContext.class);
        bdb.addPropertyValue("basePackages", basePackages);
        registry.registerBeanDefinition(module.name() + "JPAContext", bdb.getBeanDefinition());
    }
}
