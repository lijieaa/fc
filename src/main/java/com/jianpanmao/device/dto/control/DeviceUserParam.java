package com.jianpanmao.device.dto.control;

import java.util.Date;

/**
 * Created by mayn on 2018/5/27.
 * 用户参数
 */
public class DeviceUserParam {
    private Long id;
    private String device_production_num;
    private Integer clear_cyc;
    private Integer clear_time;
    private Integer unit_interval;
    private Integer main_valve_delay_time;
    private Integer p_delay_time;
    private Integer p_threshold;
    private Integer p_clear_time;
    private Integer p_warning;
    private Integer power_cyc;
    private Integer p_power_threshold;
    private Date update_time;
    private Date create_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDevice_production_num() {
        return device_production_num;
    }

    public void setDevice_production_num(String device_production_num) {
        this.device_production_num = device_production_num;
    }

    public Integer getClear_cyc() {
        return clear_cyc;
    }

    public void setClear_cyc(Integer clear_cyc) {
        this.clear_cyc = clear_cyc;
    }

    public Integer getClear_time() {
        return clear_time;
    }

    public void setClear_time(Integer clear_time) {
        this.clear_time = clear_time;
    }

    public Integer getUnit_interval() {
        return unit_interval;
    }

    public void setUnit_interval(Integer unit_interval) {
        this.unit_interval = unit_interval;
    }

    public Integer getMain_valve_delay_time() {
        return main_valve_delay_time;
    }

    public void setMain_valve_delay_time(Integer main_valve_delay_time) {
        this.main_valve_delay_time = main_valve_delay_time;
    }

    public Integer getP_delay_time() {
        return p_delay_time;
    }

    public void setP_delay_time(Integer p_delay_time) {
        this.p_delay_time = p_delay_time;
    }

    public Integer getP_threshold() {
        return p_threshold;
    }

    public void setP_threshold(Integer p_threshold) {
        this.p_threshold = p_threshold;
    }

    public Integer getP_clear_time() {
        return p_clear_time;
    }

    public void setP_clear_time(Integer p_clear_time) {
        this.p_clear_time = p_clear_time;
    }

    public Integer getP_warning() {
        return p_warning;
    }

    public void setP_warning(Integer p_warning) {
        this.p_warning = p_warning;
    }

    public Integer getPower_cyc() {
        return power_cyc;
    }

    public void setPower_cyc(Integer power_cyc) {
        this.power_cyc = power_cyc;
    }

    public Integer getP_power_threshold() {
        return p_power_threshold;
    }

    public void setP_power_threshold(Integer p_power_threshold) {
        this.p_power_threshold = p_power_threshold;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
};
