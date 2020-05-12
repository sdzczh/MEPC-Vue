package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 用户管理对象 users
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public class Users extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long id;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 密码 */
    private String password;

    /** 交易密码 */
    private String orderPwd;

    /** 邀请码 */
    @Excel(name = "邀请码")
    private String uuid;

    /** 推荐人邀请码 */
    @Excel(name = "推荐人邀请码")
    private String referId;

    /** 状态 */
    @Excel(name = "状态")
    private Integer state;

    /** token */
    private String token;

    /** secretkey */
    private String secretkey;

    /** 实名状态  */
    @Excel(name = "实名状态 ")
    private Integer idStatus;

    /** 用户身份 */
    @Excel(name = "用户身份")
    private Integer role;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setOrderPwd(String orderPwd) 
    {
        this.orderPwd = orderPwd;
    }

    public String getOrderPwd() 
    {
        return orderPwd;
    }
    public void setUuid(String uuid) 
    {
        this.uuid = uuid;
    }

    public String getUuid() 
    {
        return uuid;
    }
    public void setReferId(String referId) 
    {
        this.referId = referId;
    }

    public String getReferId() 
    {
        return referId;
    }
    public void setState(Integer state) 
    {
        this.state = state;
    }

    public Integer getState() 
    {
        return state;
    }
    public void setToken(String token) 
    {
        this.token = token;
    }

    public String getToken() 
    {
        return token;
    }
    public void setSecretkey(String secretkey) 
    {
        this.secretkey = secretkey;
    }

    public String getSecretkey() 
    {
        return secretkey;
    }
    public void setIdStatus(Integer idStatus) 
    {
        this.idStatus = idStatus;
    }

    public Integer getIdStatus() 
    {
        return idStatus;
    }
    public void setRole(Integer role) 
    {
        this.role = role;
    }

    public Integer getRole() 
    {
        return role;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("phone", getPhone())
            .append("password", getPassword())
            .append("orderPwd", getOrderPwd())
            .append("uuid", getUuid())
            .append("referId", getReferId())
            .append("state", getState())
            .append("token", getToken())
            .append("secretkey", getSecretkey())
            .append("idStatus", getIdStatus())
            .append("role", getRole())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
