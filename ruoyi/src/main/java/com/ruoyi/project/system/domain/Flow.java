package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 流水记录对象 flow
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public class Flow extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 操作类型 */
    @Excel(name = "操作类型")
    private String operType;

    /** 关联id */
    @Excel(name = "关联id")
    private Long relateId;

    /** 资金流向 */
    @Excel(name = "资金流向")
    private Integer flows;

    /** 账户类型 */
    @Excel(name = "账户类型")
    private Long accountType;

    /** 币种 */
    @Excel(name = "币种")
    private Long coinType;

    /** 操作人id */
    @Excel(name = "操作人id")
    private Long operId;

    /** 金额 */
    @Excel(name = "金额")
    private Double amount;

    /** 操作后金额 */
    @Excel(name = "操作后金额")
    private String resultAmount;

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
    public void setOperType(String operType) 
    {
        this.operType = operType;
    }

    public String getOperType() 
    {
        return operType;
    }
    public void setRelateId(Long relateId) 
    {
        this.relateId = relateId;
    }

    public Long getRelateId() 
    {
        return relateId;
    }
    public void setFlows(Integer flows) 
    {
        this.flows = flows;
    }

    public Integer getFlows() 
    {
        return flows;
    }
    public void setAccountType(Long accountType) 
    {
        this.accountType = accountType;
    }

    public Long getAccountType() 
    {
        return accountType;
    }
    public void setCoinType(Long coinType) 
    {
        this.coinType = coinType;
    }

    public Long getCoinType() 
    {
        return coinType;
    }
    public void setOperId(Long operId) 
    {
        this.operId = operId;
    }

    public Long getOperId() 
    {
        return operId;
    }
    public void setAmount(Double amount) 
    {
        this.amount = amount;
    }

    public Double getAmount() 
    {
        return amount;
    }
    public void setResultAmount(String resultAmount) 
    {
        this.resultAmount = resultAmount;
    }

    public String getResultAmount() 
    {
        return resultAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("operType", getOperType())
            .append("relateId", getRelateId())
            .append("flows", getFlows())
            .append("accountType", getAccountType())
            .append("coinType", getCoinType())
            .append("operId", getOperId())
            .append("amount", getAmount())
            .append("resultAmount", getResultAmount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
