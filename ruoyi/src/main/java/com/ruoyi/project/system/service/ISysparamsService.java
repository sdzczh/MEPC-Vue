package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.Sysparams;

/**
 * 系统参数配置Service接口
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public interface ISysparamsService 
{
    /**
     * 查询系统参数配置
     * 
     * @param id 系统参数配置ID
     * @return 系统参数配置
     */
    public Sysparams selectSysparamsById(Long id);

    /**
     * 查询系统参数配置列表
     * 
     * @param sysparams 系统参数配置
     * @return 系统参数配置集合
     */
    public List<Sysparams> selectSysparamsList(Sysparams sysparams);

    /**
     * 新增系统参数配置
     * 
     * @param sysparams 系统参数配置
     * @return 结果
     */
    public int insertSysparams(Sysparams sysparams);

    /**
     * 修改系统参数配置
     * 
     * @param sysparams 系统参数配置
     * @return 结果
     */
    public int updateSysparams(Sysparams sysparams);

    /**
     * 批量删除系统参数配置
     * 
     * @param ids 需要删除的系统参数配置ID
     * @return 结果
     */
    public int deleteSysparamsByIds(Long[] ids);

    /**
     * 删除系统参数配置信息
     * 
     * @param id 系统参数配置ID
     * @return 结果
     */
    public int deleteSysparamsById(Long id);
}
