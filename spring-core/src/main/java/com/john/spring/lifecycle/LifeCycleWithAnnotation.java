package com.john.spring.lifecycle;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 通过注解，指定bean的生命周期方法
 */
@Slf4j(topic = "LifeCycleWithAnnotation")
public class LifeCycleWithAnnotation {

    private String sname;

    @PreDestroy
    public void destroy() throws Exception {
        log.debug("lifecycle method: destroy called");
    }

    @PostConstruct
    public void init() throws Exception {
        log.debug("lifecycle method: init called");
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        log.debug("setSname: " + sname);
        this.sname = sname;
    }

}
