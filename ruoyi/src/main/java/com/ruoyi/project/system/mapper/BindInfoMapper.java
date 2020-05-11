package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.BindInfo;

/**
 * 支付绑定信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-10
 */
public interface BindInfoMapper 
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
     * 删除支付绑定信息
     * 
     * @param id 支付绑定信息ID
     * @return 结果
     */
    public int deleteBindInfoById(Long id);

    /**
     * 批量删除支付绑定信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBindInfoByIds(Long[] ids);
}
