package com.jianpanmao.mqtt;

import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(name = "mqttGateway",defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateway {
    void sendToMqtt(String data);
}
