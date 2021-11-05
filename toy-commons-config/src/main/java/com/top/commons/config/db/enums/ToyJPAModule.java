package com.top.commons.config.db.enums;

import com.top.commons.config.db.jpa.ToyJPAConfig;
import lombok.Getter;

@Getter
public enum ToyJPAModule {
    ToyBase(ToyJPAConfig.class);

    private Class<?> clazz;

    private ToyJPAModule(Class<?> clazz) {
        this.clazz = clazz;
    }
}
