package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.AppVersion;

/**
 * 版本控制Service接口
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public interface IAppVersionService 
{
    /**
     * 查询版本控制
     * 
     * @param id 版本控制ID
     * @return 版本控制
     */
    public AppVersion selectAppVersionById(Long id);

    /**
     * 查询版本控制列表
     * 
     * @param appVersion 版本控制
     * @return 版本控制集合
     */
    public List<AppVersion> selectAppVersionList(AppVersion appVersion);

    /**
     * 新增版本控制
     * 
     * @param appVersion 版本控制
     * @return 结果
     */
    public int insertAppVersion(AppVersion appVersion);

    /**
     * 修改版本控制
     * 
     * @param appVersion 版本控制
     * @return 结果
     */
    public int updateAppVersion(AppVersion appVersion);

    /**
     * 批量删除版本控制
     * 
     * @param ids 需要删除的版本控制ID
     * @return 结果
     */
    public int deleteAppVersionByIds(Long[] ids);

    /**
     * 删除版本控制信息
     * 
     * @param id 版本控制ID
     * @return 结果
     */
    public int deleteAppVersionById(Long id);
}
