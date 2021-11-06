package com.top.commons.config.db.enums;

import com.top.commons.config.db.jpa.ToyJpaBasicConfig;
import lombok.Getter;

@Getter
public enum ToyJpaModule {
    ToyBase(ToyJpaBasicConfig.class);

    private Class<?> clazz;

    private ToyJpaModule(Class<?> clazz) {
        this.clazz = clazz;
    }
}
