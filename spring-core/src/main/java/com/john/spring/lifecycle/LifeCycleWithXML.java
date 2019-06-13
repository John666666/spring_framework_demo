package com.john.spring.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 通过在xml中配置bean的init-method、destroy-method，指定bean的生命周期方法
 */
@Slf4j(topic = "LifeCycleWithXML")
public class LifeCycleWithXML {

    private String sname;

    public void destroy() throws Exception {
        log.debug("lifecycle method: destroy called");
    }

    /**
     * 设置完bean的所有属性后回调
     * @throws Exception
     */
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
