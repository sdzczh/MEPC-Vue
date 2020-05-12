package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 版本控制对象 app_version
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public class AppVersion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** APP版本 */
    @Excel(name = "APP版本")
    private Long appVersion;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 状态 */
    @Excel(name = "状态")
    private Long state;

    /** 更新内容 */
    @Excel(name = "更新内容")
    private String content;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAppVersion(Long appVersion) 
    {
        this.appVersion = appVersion;
    }

    public Long getAppVersion() 
    {
        return appVersion;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("appVersion", getAppVersion())
            .append("address", getAddress())
            .append("state", getState())
            .append("content", getContent())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
