package com.top.commons.config.db;

import com.top.commons.annotation.EnableToyJPAConfiguration;
import com.top.commons.config.db.enums.ToyJPAModule;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class CommonJPAConfigureSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> metaData = importingClassMetadata.getAnnotationAttributes(EnableToyJPAConfiguration.class.getName());
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(metaData);
        ToyJPAModule module = attributes.getEnum("module");

        String jpaConfigBeanName = module.getClazz().getName();

        return new String[]{jpaConfigBeanName};
    }
}
