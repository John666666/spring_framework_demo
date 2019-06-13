package com.john.spring.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 通过实现接口的方法，指定bean的生命周期方法
 */
@Slf4j(topic = "LifeCycleWithInterface")
public class LifeCycleWithInterface implements InitializingBean, DisposableBean {

    private String sname;

    @Override
    public void destroy() throws Exception {
        log.debug("lifecycle method: destroy called");
    }

    /**
     * 设置完bean的所有属性后回调
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("lifecycle method: afterPropertiesSet called");
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        log.debug("setSname: " + sname);
        this.sname = sname;
    }
}
