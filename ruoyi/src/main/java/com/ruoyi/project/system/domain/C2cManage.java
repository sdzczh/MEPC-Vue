package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 法币交易管理对象 c2c_manage
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public class C2cManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Long id;

    /** 币种 */
    @Excel(name = "币种")
    private Integer coinType;

    /** 价格 */
    @Excel(name = "价格")
    private Double price;

    /** 开关 0关 1开 */
    @Excel(name = "开关 0关 1开")
    private Integer onOff;

    /** 类型 0买 1卖 */
    @Excel(name = "类型 0买 1卖")
    private Integer type;

    /** 最小值 */
    @Excel(name = "最小值")
    private Double totalMin;

    /** 最大值 */
    @Excel(name = "最大值")
    private Double totalMax;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCoinType(Integer coinType) 
    {
        this.coinType = coinType;
    }

    public Integer getCoinType() 
    {
        return coinType;
    }
    public void setPrice(Double price) 
    {
        this.price = price;
    }

    public Double getPrice() 
    {
        return price;
    }
    public void setOnOff(Integer onOff) 
    {
        this.onOff = onOff;
    }

    public Integer getOnOff() 
    {
        return onOff;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setTotalMin(Double totalMin) 
    {
        this.totalMin = totalMin;
    }

    public Double getTotalMin() 
    {
        return totalMin;
    }
    public void setTotalMax(Double totalMax) 
    {
        this.totalMax = totalMax;
    }

    public Double getTotalMax() 
    {
        return totalMax;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("coinType", getCoinType())
            .append("price", getPrice())
            .append("onOff", getOnOff())
            .append("type", getType())
            .append("totalMin", getTotalMin())
            .append("totalMax", getTotalMax())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
