package com.top.commons.config.db.jpa;

import com.top.commons.annotation.EnableToyJpaConfiguration;
import com.top.commons.config.db.enums.ToyJpaModule;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class CommonJpaConfigureSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> metaData = importingClassMetadata.getAnnotationAttributes(EnableToyJpaConfiguration.class.getName());
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(metaData);
        ToyJpaModule module = attributes.getEnum("module");

        String jpaConfigBeanName = module.getClazz().getName();

        return new String[]{jpaConfigBeanName};
    }
}
