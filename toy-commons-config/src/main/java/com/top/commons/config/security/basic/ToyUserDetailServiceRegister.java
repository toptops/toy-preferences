package com.top.commons.config.security.basic;

import com.top.commons.config.security.EnableToySecurityConfiguration;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class ToyUserDetailServiceRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> metaData = importingClassMetadata.getAnnotationAttributes(EnableToySecurityConfiguration.class.getName());
        Class<? extends ToyUserDetailsService> detailsService = (Class<? extends ToyUserDetailsService>) metaData.get("detailsService");
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(detailsService);
        registry.registerBeanDefinition("ToyUserDetailsService", bdb.getBeanDefinition());
    }
}
