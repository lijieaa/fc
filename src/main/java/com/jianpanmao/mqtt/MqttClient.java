package com.jianpanmao.mqtt;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MqttClient implements ApplicationContextAware {

    ApplicationContext ctx;

    public MqttGateway getGateway() {
        return ctx.getBean(MqttGateway.class);
    }

    MqttGateway gateway;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx=applicationContext;
    }

}
