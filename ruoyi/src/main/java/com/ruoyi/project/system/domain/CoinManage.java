package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 币种管理对象 coin_manage
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public class CoinManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Long id;

    /** 币种 */
    @Excel(name = "币种")
    private Long coinType;

    /** 币种名称 */
    @Excel(name = "币种名称")
    private String name;

    /** 中文名称 */
    @Excel(name = "中文名称")
    private String cnName;

    /** 充值地址 */
    @Excel(name = "充值地址")
    private String address;

    /** logo */
    @Excel(name = "logo")
    private String imgUrl;

    /** 充值二维码地址 */
    @Excel(name = "充值二维码地址")
    private String rechargeUrl;

    /** 提现手续费 */
    @Excel(name = "提现手续费")
    private Double withdrawFee;

    /** 充值手续费 */
    @Excel(name = "充值手续费")
    private Double rechargeFee;

    /** 充值最大值 */
    @Excel(name = "充值最大值")
    private Double rechargeAmountMax;

    /** 提现最大值 */
    @Excel(name = "提现最大值")
    private Double withdrawAmountMax;

    /** 充值最小值 */
    @Excel(name = "充值最小值")
    private Double rechargeAmountMin;

    /** 提现最小值 */
    @Excel(name = "提现最小值")
    private Double withdrawAmountMin;

    /** 充值开关 */
    @Excel(name = "充值开关")
    private Integer rechargeOnoff;

    /** 提现开关 */
    @Excel(name = "提现开关")
    private Integer withdrawOnoff;

    /** 充值注意事项 */
    @Excel(name = "充值注意事项")
    private String rechargeDoc;

    /** 提现注意事项 */
    @Excel(name = "提现注意事项")
    private String withdrawDoc;

    /** C2C开关 */
    @Excel(name = "C2C开关")
    private Integer c2cOnoff;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCnName(String cnName) 
    {
        this.cnName = cnName;
    }

    public String getCnName() 
    {
        return cnName;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
    }
    public void setRechargeUrl(String rechargeUrl) 
    {
        this.rechargeUrl = rechargeUrl;
    }

    public String getRechargeUrl() 
    {
        return rechargeUrl;
    }
    public void setWithdrawFee(Double withdrawFee) 
    {
        this.withdrawFee = withdrawFee;
    }

    public Double getWithdrawFee() 
    {
        return withdrawFee;
    }
    public void setRechargeFee(Double rechargeFee) 
    {
        this.rechargeFee = rechargeFee;
    }

    public Double getRechargeFee() 
    {
        return rechargeFee;
    }
    public void setRechargeAmountMax(Double rechargeAmountMax) 
    {
        this.rechargeAmountMax = rechargeAmountMax;
    }

    public Double getRechargeAmountMax() 
    {
        return rechargeAmountMax;
    }
    public void setWithdrawAmountMax(Double withdrawAmountMax) 
    {
        this.withdrawAmountMax = withdrawAmountMax;
    }

    public Double getWithdrawAmountMax() 
    {
        return withdrawAmountMax;
    }
    public void setRechargeAmountMin(Double rechargeAmountMin) 
    {
        this.rechargeAmountMin = rechargeAmountMin;
    }

    public Double getRechargeAmountMin() 
    {
        return rechargeAmountMin;
    }
    public void setWithdrawAmountMin(Double withdrawAmountMin) 
    {
        this.withdrawAmountMin = withdrawAmountMin;
    }

    public Double getWithdrawAmountMin() 
    {
        return withdrawAmountMin;
    }
    public void setRechargeOnoff(Integer rechargeOnoff) 
    {
        this.rechargeOnoff = rechargeOnoff;
    }

    public Integer getRechargeOnoff() 
    {
        return rechargeOnoff;
    }
    public void setWithdrawOnoff(Integer withdrawOnoff) 
    {
        this.withdrawOnoff = withdrawOnoff;
    }

    public Integer getWithdrawOnoff() 
    {
        return withdrawOnoff;
    }
    public void setRechargeDoc(String rechargeDoc) 
    {
        this.rechargeDoc = rechargeDoc;
    }

    public String getRechargeDoc() 
    {
        return rechargeDoc;
    }
    public void setWithdrawDoc(String withdrawDoc) 
    {
        this.withdrawDoc = withdrawDoc;
    }

    public String getWithdrawDoc() 
    {
        return withdrawDoc;
    }
    public void setC2cOnoff(Integer c2cOnoff) 
    {
        this.c2cOnoff = c2cOnoff;
    }

    public Integer getC2cOnoff() 
    {
        return c2cOnoff;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("coinType", getCoinType())
            .append("name", getName())
            .append("cnName", getCnName())
            .append("address", getAddress())
            .append("imgUrl", getImgUrl())
            .append("rechargeUrl", getRechargeUrl())
            .append("withdrawFee", getWithdrawFee())
            .append("rechargeFee", getRechargeFee())
            .append("rechargeAmountMax", getRechargeAmountMax())
            .append("withdrawAmountMax", getWithdrawAmountMax())
            .append("rechargeAmountMin", getRechargeAmountMin())
            .append("withdrawAmountMin", getWithdrawAmountMin())
            .append("rechargeOnoff", getRechargeOnoff())
            .append("withdrawOnoff", getWithdrawOnoff())
            .append("rechargeDoc", getRechargeDoc())
            .append("withdrawDoc", getWithdrawDoc())
            .append("c2cOnoff", getC2cOnoff())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
