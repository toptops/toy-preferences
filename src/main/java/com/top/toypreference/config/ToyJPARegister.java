package com.top.toypreference.config;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class ToyJPARegister implements ImportBeanDefinitionRegistrar {

    private String[] basePackages;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> metaData = importingClassMetadata.getAnnotationAttributes(EnableToyJPARegister.class.getName());
        String[] packages = (String[]) metaData.get("basePackage");
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(ToyJPARegister.class);
        bdb.addPropertyValue("basePackages", packages);
        registry.registerBeanDefinition("toyJPARegister", bdb.getBeanDefinition());
    }

    public String[] getBasePackages(){
        return basePackages;
    }

    public void setBasePackages(String[] basePackages) {
        this.basePackages = basePackages;
    }
}
