package com.jianpanmao.common.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听session生命周期
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    private final Log logger =  LogFactory.getLog(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        logger.info("--------------sessionCreated-----------------");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        logger.info("--------------sessionDestroyed-----------------");
    }
}
