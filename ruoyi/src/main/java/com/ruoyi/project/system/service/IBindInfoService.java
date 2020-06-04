package com.ruoyi.project.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.domain.BindInfo;

/**
 * 支付绑定信息Service接口
 * 
 * @author ruoyi
 * @date 2020-05-10
 */
public interface IBindInfoService 
{
    /**
     * 查询支付绑定信息
     * 
     * @param id 支付绑定信息ID
     * @return 支付绑定信息
     */
    public BindInfo selectBindInfoById(Long id);

    /**
     * 查询支付绑定信息列表
     * 
     * @param bindInfo 支付绑定信息
     * @return 支付绑定信息集合
     */
    public List<BindInfo> selectBindInfoList(BindInfo bindInfo);

    /**
     * 新增支付绑定信息
     * 
     * @param bindInfo 支付绑定信息
     * @return 结果
     */
    public int insertBindInfo(BindInfo bindInfo);

    /**
     * 修改支付绑定信息
     * 
     * @param bindInfo 支付绑定信息
     * @return 结果
     */
    public int updateBindInfo(BindInfo bindInfo);

    /**
     * 批量删除支付绑定信息
     * 
     * @param ids 需要删除的支付绑定信息ID
     * @return 结果
     */
    public int deleteBindInfoByIds(Long[] ids);

    /**
     * 删除支付绑定信息信息
     * 
     * @param id 支付绑定信息ID
     * @return 结果
     */
    public int deleteBindInfoById(Long id);

    List<Map<String, Object>> selectBindInfoLists(String phone);
}
