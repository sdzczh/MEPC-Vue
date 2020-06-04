package com.ruoyi.project.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.BindInfoMapper;
import com.ruoyi.project.system.domain.BindInfo;
import com.ruoyi.project.system.service.IBindInfoService;

/**
 * 支付绑定信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-10
 */
@Service
public class BindInfoServiceImpl implements IBindInfoService 
{
    @Autowired
    private BindInfoMapper bindInfoMapper;

    /**
     * 查询支付绑定信息
     * 
     * @param id 支付绑定信息ID
     * @return 支付绑定信息
     */
    @Override
    public BindInfo selectBindInfoById(Long id)
    {
        return bindInfoMapper.selectBindInfoById(id);
    }

    /**
     * 查询支付绑定信息列表
     * 
     * @param bindInfo 支付绑定信息
     * @return 支付绑定信息
     */
    @Override
    public List<BindInfo> selectBindInfoList(BindInfo bindInfo)
    {
        return bindInfoMapper.selectBindInfoList(bindInfo);
    }

    /**
     * 新增支付绑定信息
     * 
     * @param bindInfo 支付绑定信息
     * @return 结果
     */
    @Override
    public int insertBindInfo(BindInfo bindInfo)
    {
        bindInfo.setCreateTime(DateUtils.getNowDate());
        return bindInfoMapper.insertBindInfo(bindInfo);
    }

    /**
     * 修改支付绑定信息
     * 
     * @param bindInfo 支付绑定信息
     * @return 结果
     */
    @Override
    public int updateBindInfo(BindInfo bindInfo)
    {
        bindInfo.setUpdateTime(DateUtils.getNowDate());
        return bindInfoMapper.updateBindInfo(bindInfo);
    }

    /**
     * 批量删除支付绑定信息
     * 
     * @param ids 需要删除的支付绑定信息ID
     * @return 结果
     */
    @Override
    public int deleteBindInfoByIds(Long[] ids)
    {
        return bindInfoMapper.deleteBindInfoByIds(ids);
    }

    /**
     * 删除支付绑定信息信息
     * 
     * @param id 支付绑定信息ID
     * @return 结果
     */
    @Override
    public int deleteBindInfoById(Long id)
    {
        return bindInfoMapper.deleteBindInfoById(id);
    }

    @Override
    public List<Map<String, Object>> selectBindInfoLists(String phone) {
        return bindInfoMapper.selectBindInfoLists(phone);

    }
}
