package com.top.commons.config.security.oauth2;

import com.top.commons.annotation.EnableOauth2Configuration;
import com.top.commons.config.security.basic.BasicUserDetailsService;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class OAuth2UserProcessorRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> metaData = importingClassMetadata.getAnnotationAttributes(EnableOauth2Configuration.class.getName());
        Class<? extends BasicOAuth2UserProcessor> processor = (Class<? extends BasicOAuth2UserProcessor>) metaData.get("userProcessor");
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(processor);
        registry.registerBeanDefinition("BasicOAuth2UserProcessor", bdb.getBeanDefinition());
    }
}
