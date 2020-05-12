package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 法币订单管理对象 order_taker
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public class OrderTaker extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 类型 0买 1卖 */
    @Excel(name = "类型 0买 1卖")
    private Long type;

    /** 币种 */
    @Excel(name = "币种")
    private Long coinType;

    /** makerId */
    @Excel(name = "makerId")
    private Long makerUserId;

    /** 订单id */
    @Excel(name = "订单id")
    private Long makerId;

    /** 价格 */
    @Excel(name = "价格")
    private Double price;

    /** 金额 */
    @Excel(name = "金额")
    private Double amount;

    /** 总额 */
    @Excel(name = "总额")
    private Double total;

    /** 支付id */
    @Excel(name = "支付id")
    private Long payId;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNum;

    /** 状态  */
    @Excel(name = "状态 ")
    private Long state;

    /** 过期时间 */
    @Excel(name = "过期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date inactiveTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setCoinType(Long coinType) 
    {
        this.coinType = coinType;
    }

    public Long getCoinType() 
    {
        return coinType;
    }
    public void setMakerUserId(Long makerUserId) 
    {
        this.makerUserId = makerUserId;
    }

    public Long getMakerUserId() 
    {
        return makerUserId;
    }
    public void setMakerId(Long makerId) 
    {
        this.makerId = makerId;
    }

    public Long getMakerId() 
    {
        return makerId;
    }
    public void setPrice(Double price) 
    {
        this.price = price;
    }

    public Double getPrice() 
    {
        return price;
    }
    public void setAmount(Double amount) 
    {
        this.amount = amount;
    }

    public Double getAmount() 
    {
        return amount;
    }
    public void setTotal(Double total) 
    {
        this.total = total;
    }

    public Double getTotal() 
    {
        return total;
    }
    public void setPayId(Long payId) 
    {
        this.payId = payId;
    }

    public Long getPayId() 
    {
        return payId;
    }
    public void setOrderNum(String orderNum) 
    {
        this.orderNum = orderNum;
    }

    public String getOrderNum() 
    {
        return orderNum;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }
    public void setInactiveTime(Date inactiveTime) 
    {
        this.inactiveTime = inactiveTime;
    }

    public Date getInactiveTime() 
    {
        return inactiveTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("type", getType())
            .append("coinType", getCoinType())
            .append("makerUserId", getMakerUserId())
            .append("makerId", getMakerId())
            .append("price", getPrice())
            .append("amount", getAmount())
            .append("total", getTotal())
            .append("payId", getPayId())
            .append("orderNum", getOrderNum())
            .append("state", getState())
            .append("inactiveTime", getInactiveTime())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
