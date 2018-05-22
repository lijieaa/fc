package com.jianpanmao.mqtt;

import com.jianpanmao.Application;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MqttClient implements ApplicationContextAware {

    ApplicationContext ctx;

    public Application.MyGateway getGateway() {
        return ctx.getBean(Application.MyGateway.class);
    }

    Application.MyGateway gateway;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx=applicationContext;
    }


}
