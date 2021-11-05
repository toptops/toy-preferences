package com.top.commons.config.db.enums;

import com.top.commons.config.db.jpa.ToyJpaConfig;
import lombok.Getter;

@Getter
public enum ToyJpaModule {
    ToyBase(ToyJpaConfig.class);

    private Class<?> clazz;

    private ToyJpaModule(Class<?> clazz) {
        this.clazz = clazz;
    }
}
