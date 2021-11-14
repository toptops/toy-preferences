package com.top.commons.config.db.enums;

import com.top.commons.config.db.jpa.JpaBasicConfig;
import lombok.Getter;

@Getter
public enum JpaModule {
    ToyBase(JpaBasicConfig.class);

    private Class<?> clazz;

    private JpaModule(Class<?> clazz) {
        this.clazz = clazz;
    }
}
