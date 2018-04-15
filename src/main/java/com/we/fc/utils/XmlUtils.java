package com.we.fc.utils;

import com.we.fc.wechat.entity.WxMessage;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.util.Iterator;

/**
 * @author zdc
 * @since 2018-04-15 16:40
 */

public class XmlUtils {

    public static WxMessage fromXmlString(String xml) throws Exception {

        WxMessage wxMessage = new WxMessage();
        SAXReader reader = new SAXReader();
        Document document = reader.read(new ByteArrayInputStream(xml.getBytes("UTF-8")));
        Element root = document.getRootElement();
        Iterator<Element> elementIterator = root.elementIterator();
        while(elementIterator.hasNext()){
            Element element = elementIterator.next();
            String name = element.getName();
            String data = element.getData().toString().trim();
            if(name.equalsIgnoreCase("ToUserName")){
                wxMessage.setToUserName(data);
            }else if(name.equalsIgnoreCase("FromUserName")){
                wxMessage.setFromUserName(data);
            }else if(name.equalsIgnoreCase("CreateTime")) {
                wxMessage.setCreateTime(Long.valueOf(data));
            }else if(name.equalsIgnoreCase("MsgType")) {
                wxMessage.setMsgType(data);
            }else if(name.equalsIgnoreCase("Content")) {
                wxMessage.setContent(data);
            }else if(name.equalsIgnoreCase("MsgId")) {
                wxMessage.setMsgId(Long.valueOf(data));
            }else if(name.equalsIgnoreCase("PicUrl")) {
                wxMessage.setPicUrl(data);
            }else if(name.equalsIgnoreCase("MediaId")) {
                wxMessage.setMediaId(data);
            }else if(name.equalsIgnoreCase("Format")) {
                wxMessage.setFormat(data);
            }else if(name.equalsIgnoreCase("ThumbMediaId")) {
                wxMessage.setThumbMediaId(data);
            }else if(name.equalsIgnoreCase("Location_X")) {
                wxMessage.setLocation_X(data);
            }else if(name.equalsIgnoreCase("Location_Y")) {
                wxMessage.setLocation_Y(data);
            }else if(name.equalsIgnoreCase("Scale")) {
                wxMessage.setScale(Integer.parseInt(data));
            }else if(name.equalsIgnoreCase("Label")) {
                wxMessage.setLabel(data);
            }else if(name.equalsIgnoreCase("Title")) {
                wxMessage.setTitle(data);
            }else if(name.equalsIgnoreCase("Description")) {
                wxMessage.setDescription(data);
            }else if(name.equalsIgnoreCase("Url")) {
                wxMessage.setUrl(data);
            }
        }
        return wxMessage;
    }
}
