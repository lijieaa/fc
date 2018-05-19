package com.jianpanmao.common.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateConverter implements Converter<String, Date> {

    Logger LOG = LoggerFactory.getLogger(this.getClass());

    private String datePattern;

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public Date convert(String s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(this.datePattern);
        try {
            Date date = dateFormat.parse(s);
            return date;
        }catch (ParseException e){
            LOG.error("convertError",e);
        }
        return null;
    }

}
