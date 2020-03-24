package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 资金划转管理对象 account_transfer
 * 
 * @author ruoyi
 * @date 2020-03-23
 */
public class AccountTransfer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 目标用户id */
    @Excel(name = "目标用户id")
    private Long toUserId;

    /** 币种类型 */
    @Excel(name = "币种类型")
    private Integer coinType;

    /** 账户类型 */
    @Excel(name = "账户类型")
    private Integer accountType;

    /** 转帐金额 */
    @Excel(name = "转帐金额")
    private Double amount;

    /** 相关id */
    @Excel(name = "相关id")
    private Long relatedid;

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
    public void setToUserId(Long toUserId) 
    {
        this.toUserId = toUserId;
    }

    public Long getToUserId() 
    {
        return toUserId;
    }
    public void setCoinType(Integer coinType) 
    {
        this.coinType = coinType;
    }

    public Integer getCoinType() 
    {
        return coinType;
    }
    public void setAccountType(Integer accountType) 
    {
        this.accountType = accountType;
    }

    public Integer getAccountType() 
    {
        return accountType;
    }
    public void setAmount(Double amount) 
    {
        this.amount = amount;
    }

    public Double getAmount() 
    {
        return amount;
    }
    public void setRelatedid(Long relatedid) 
    {
        this.relatedid = relatedid;
    }

    public Long getRelatedid() 
    {
        return relatedid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("toUserId", getToUserId())
            .append("coinType", getCoinType())
            .append("accountType", getAccountType())
            .append("amount", getAmount())
            .append("relatedid", getRelatedid())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
