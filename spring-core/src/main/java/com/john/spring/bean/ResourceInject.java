package com.john.spring.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.Resource;

/**
 * 测试资源注入
 */
@Getter
@Setter
public class ResourceInject {
    private Resource resource;
}
