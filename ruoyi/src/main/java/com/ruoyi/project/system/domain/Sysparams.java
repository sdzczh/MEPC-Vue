package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 系统参数配置对象 sysparams
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public class Sysparams extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** key */
    @Excel(name = "key")
    private String keyName;

    /** value */
    @Excel(name = "value")
    private String keyVal;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setKeyName(String keyName) 
    {
        this.keyName = keyName;
    }

    public String getKeyName() 
    {
        return keyName;
    }
    public void setKeyVal(String keyVal) 
    {
        this.keyVal = keyVal;
    }

    public String getKeyVal() 
    {
        return keyVal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("keyName", getKeyName())
            .append("keyVal", getKeyVal())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
