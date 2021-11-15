package com.top.commons.config.security.oauth2;

import com.top.commons.annotation.EnableOauth2Configuration;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class OAuth2AuthenticationHandlerServiceRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> metaData = importingClassMetadata.getAnnotationAttributes(EnableOauth2Configuration.class.getName());
        Class<? extends BasicOAuth2AuthenticationHandlerService> processor = (Class<? extends BasicOAuth2AuthenticationHandlerService>) metaData.get("authHandlerService");
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(processor);
        registry.registerBeanDefinition("BasicOAuth2AuthenticationHandlerService", bdb.getBeanDefinition());
    }
}
