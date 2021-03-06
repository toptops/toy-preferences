package com.top.commons.config.db.jpa;

import com.top.commons.annotation.EnableJpaConfiguration;
import com.top.commons.config.db.enums.JpaModule;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class CommonJpaConfigureSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> metaData = importingClassMetadata.getAnnotationAttributes(EnableJpaConfiguration.class.getName());
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(metaData);
        JpaModule module = attributes.getEnum("module");

        String jpaConfigBeanName = module.getClazz().getName();

        return new String[]{jpaConfigBeanName};
    }
}
