package com.top.commons.config.security.basic;

import com.top.commons.annotation.EnableBasicSecurityConfiguration;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class UserDetailServiceRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> metaData = importingClassMetadata.getAnnotationAttributes(EnableBasicSecurityConfiguration.class.getName());
        Class<? extends BasicUserDetailsService> detailsService = (Class<? extends BasicUserDetailsService>) metaData.get("detailsService");
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(detailsService);
        registry.registerBeanDefinition("BasicUserDetailsService", bdb.getBeanDefinition());
    }
}
