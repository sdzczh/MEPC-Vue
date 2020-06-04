package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.math.BigDecimal;

/**
 * 账户管理对象 account
 * 
 * @author ruoyi
 * @date 2020-05-09
 */
public class Account extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 可用余额 */
    @Excel(name = "可用余额")
    private BigDecimal availbalance;

    /** 冻结余额 */
    @Excel(name = "冻结余额")
    private BigDecimal frozenblance;

    /** 账户类型 */
    @Excel(name = "账户类型")
    private Integer accountType;

    /** 币种 */
    @Excel(name = "币种")
    private Integer coinType;

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
    public void setAvailbalance(BigDecimal availbalance) 
    {
        this.availbalance = availbalance;
    }

    public BigDecimal getAvailbalance() 
    {
        return availbalance;
    }
    public void setFrozenblance(BigDecimal frozenblance) 
    {
        this.frozenblance = frozenblance;
    }

    public BigDecimal getFrozenblance() 
    {
        return frozenblance;
    }
    public void setAccountType(Integer accountType) 
    {
        this.accountType = accountType;
    }

    public Integer getAccountType() 
    {
        return accountType;
    }
    public void setCoinType(Integer coinType) 
    {
        this.coinType = coinType;
    }

    public Integer getCoinType() 
    {
        return coinType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("availbalance", getAvailbalance())
            .append("frozenblance", getFrozenblance())
            .append("accountType", getAccountType())
            .append("coinType", getCoinType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
