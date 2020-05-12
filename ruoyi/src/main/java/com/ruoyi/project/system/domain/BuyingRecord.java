package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 矿池记录对象 buying_record
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public class BuyingRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 配置id */
    @Excel(name = "配置id")
    private Long buyingId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 购买数量 */
    @Excel(name = "购买数量")
    private Double buyNumber;

    /** 每次分发数量 */
    @Excel(name = "每次分发数量")
    private Double provides;

    /** 剩余数量 */
    @Excel(name = "剩余数量")
    private Double surplus;

    /** 到期时间 */
    @Excel(name = "到期时间")
    private String endTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBuyingId(Long buyingId) 
    {
        this.buyingId = buyingId;
    }

    public Long getBuyingId() 
    {
        return buyingId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setBuyNumber(Double buyNumber) 
    {
        this.buyNumber = buyNumber;
    }

    public Double getBuyNumber() 
    {
        return buyNumber;
    }
    public void setProvides(Double provides) 
    {
        this.provides = provides;
    }

    public Double getProvides() 
    {
        return provides;
    }
    public void setSurplus(Double surplus) 
    {
        this.surplus = surplus;
    }

    public Double getSurplus() 
    {
        return surplus;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("buyingId", getBuyingId())
            .append("userId", getUserId())
            .append("buyNumber", getBuyNumber())
            .append("provides", getProvides())
            .append("surplus", getSurplus())
            .append("endTime", getEndTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
