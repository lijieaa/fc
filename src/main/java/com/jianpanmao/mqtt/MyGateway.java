package com.jianpanmao.mqtt;

import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MyGateway {
    void sendToMqtt(String data);
}
