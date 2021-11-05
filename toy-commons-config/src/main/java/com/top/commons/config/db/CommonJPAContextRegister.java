package com.top.commons.config.db;

import com.top.commons.annotation.EnableToyJPAConfiguration;
import com.top.commons.config.db.domain.CommonJPAContext;
import com.top.commons.config.db.enums.ToyJPAModule;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class CommonJPAContextRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> metaData = importingClassMetadata.getAnnotationAttributes(EnableToyJPAConfiguration.class.getName());
        String[] entityBasePackages = (String[]) metaData.get("entityBasePackages");
        ToyJPAModule module = (ToyJPAModule) metaData.get("module");
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(CommonJPAContext.class);
        bdb.addPropertyValue("entityBasePackages", entityBasePackages);
        registry.registerBeanDefinition(module.name() + "JPAContext", bdb.getBeanDefinition());
    }
}
