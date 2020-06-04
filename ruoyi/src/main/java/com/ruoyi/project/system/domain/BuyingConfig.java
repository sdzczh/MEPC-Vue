package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 矿池配置对象 buying_config
 * 
 * @author ruoyi
 * @date 2020-05-11
 */
public class BuyingConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 币种 */
    @Excel(name = "币种")
    private Long coinType;

    /** 开关 0关 1开 */
    @Excel(name = "开关 0关 1开")
    private Integer onOff;

    /** 当前价格 */
    @Excel(name = "当前价格")
    private String nowPrice;

    /** 流通量 */
    @Excel(name = "流通量")
    private String circulation;

    /** 合约周期 */
    @Excel(name = "合约周期")
    private Long days;

    /** 价格 */
    @Excel(name = "价格")
    private Double buyPrice;

    /** 可获得数量 */
    @Excel(name = "可获得数量")
    private Double getNumber;

    /** 可购买次数 */
    @Excel(name = "可购买次数")
    private Long buyCount;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCoinType(Long coinType) 
    {
        this.coinType = coinType;
    }

    public Long getCoinType() 
    {
        return coinType;
    }
    public void setOnOff(Integer onOff) 
    {
        this.onOff = onOff;
    }

    public Integer getOnOff() 
    {
        return onOff;
    }
    public void setNowPrice(String nowPrice) 
    {
        this.nowPrice = nowPrice;
    }

    public String getNowPrice() 
    {
        return nowPrice;
    }
    public void setCirculation(String circulation) 
    {
        this.circulation = circulation;
    }

    public String getCirculation() 
    {
        return circulation;
    }
    public void setDays(Long days) 
    {
        this.days = days;
    }

    public Long getDays() 
    {
        return days;
    }
    public void setBuyPrice(Double buyPrice) 
    {
        this.buyPrice = buyPrice;
    }

    public Double getBuyPrice() 
    {
        return buyPrice;
    }
    public void setGetNumber(Double getNumber) 
    {
        this.getNumber = getNumber;
    }

    public Double getGetNumber() 
    {
        return getNumber;
    }
    public void setBuyCount(Long buyCount) 
    {
        this.buyCount = buyCount;
    }

    public Long getBuyCount() 
    {
        return buyCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("coinType", getCoinType())
            .append("onOff", getOnOff())
            .append("nowPrice", getNowPrice())
            .append("circulation", getCirculation())
            .append("days", getDays())
            .append("buyPrice", getBuyPrice())
            .append("getNumber", getGetNumber())
            .append("buyCount", getBuyCount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
