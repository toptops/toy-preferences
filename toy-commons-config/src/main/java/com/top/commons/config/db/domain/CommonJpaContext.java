package com.top.commons.config.db.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CommonJpaContext {
    private String[] entityBasePackages;
    private String[] repositoryBasePackages;
}
