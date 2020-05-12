package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 短信记录对象 sms_record
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public class SmsRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 类型 */
    @Excel(name = "类型")
    private Integer type;

    /** 状态 */
    @Excel(name = "状态")
    private Integer state;

    /** 验证码 */
    @Excel(name = "验证码")
    private String code;

    /** 时间 */
    @Excel(name = "时间")
    private Long times;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setState(Integer state) 
    {
        this.state = state;
    }

    public Integer getState() 
    {
        return state;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setTimes(Long times) 
    {
        this.times = times;
    }

    public Long getTimes() 
    {
        return times;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("phone", getPhone())
            .append("type", getType())
            .append("state", getState())
            .append("code", getCode())
            .append("times", getTimes())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
