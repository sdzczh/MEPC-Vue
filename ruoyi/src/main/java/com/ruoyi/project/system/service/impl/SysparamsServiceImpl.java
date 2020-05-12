package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.SysparamsMapper;
import com.ruoyi.project.system.domain.Sysparams;
import com.ruoyi.project.system.service.ISysparamsService;

/**
 * 系统参数配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@Service
public class SysparamsServiceImpl implements ISysparamsService 
{
    @Autowired
    private SysparamsMapper sysparamsMapper;

    /**
     * 查询系统参数配置
     * 
     * @param id 系统参数配置ID
     * @return 系统参数配置
     */
    @Override
    public Sysparams selectSysparamsById(Long id)
    {
        return sysparamsMapper.selectSysparamsById(id);
    }

    /**
     * 查询系统参数配置列表
     * 
     * @param sysparams 系统参数配置
     * @return 系统参数配置
     */
    @Override
    public List<Sysparams> selectSysparamsList(Sysparams sysparams)
    {
        return sysparamsMapper.selectSysparamsList(sysparams);
    }

    /**
     * 新增系统参数配置
     * 
     * @param sysparams 系统参数配置
     * @return 结果
     */
    @Override
    public int insertSysparams(Sysparams sysparams)
    {
        sysparams.setCreateTime(DateUtils.getNowDate());
        return sysparamsMapper.insertSysparams(sysparams);
    }

    /**
     * 修改系统参数配置
     * 
     * @param sysparams 系统参数配置
     * @return 结果
     */
    @Override
    public int updateSysparams(Sysparams sysparams)
    {
        sysparams.setUpdateTime(DateUtils.getNowDate());
        return sysparamsMapper.updateSysparams(sysparams);
    }

    /**
     * 批量删除系统参数配置
     * 
     * @param ids 需要删除的系统参数配置ID
     * @return 结果
     */
    @Override
    public int deleteSysparamsByIds(Long[] ids)
    {
        return sysparamsMapper.deleteSysparamsByIds(ids);
    }

    /**
     * 删除系统参数配置信息
     * 
     * @param id 系统参数配置ID
     * @return 结果
     */
    @Override
    public int deleteSysparamsById(Long id)
    {
        return sysparamsMapper.deleteSysparamsById(id);
    }
}
