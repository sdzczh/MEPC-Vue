package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.AppVersionMapper;
import com.ruoyi.project.system.domain.AppVersion;
import com.ruoyi.project.system.service.IAppVersionService;

/**
 * 版本控制Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@Service
public class AppVersionServiceImpl implements IAppVersionService 
{
    @Autowired
    private AppVersionMapper appVersionMapper;

    /**
     * 查询版本控制
     * 
     * @param id 版本控制ID
     * @return 版本控制
     */
    @Override
    public AppVersion selectAppVersionById(Long id)
    {
        return appVersionMapper.selectAppVersionById(id);
    }

    /**
     * 查询版本控制列表
     * 
     * @param appVersion 版本控制
     * @return 版本控制
     */
    @Override
    public List<AppVersion> selectAppVersionList(AppVersion appVersion)
    {
        return appVersionMapper.selectAppVersionList(appVersion);
    }

    /**
     * 新增版本控制
     * 
     * @param appVersion 版本控制
     * @return 结果
     */
    @Override
    public int insertAppVersion(AppVersion appVersion)
    {
        appVersion.setCreateTime(DateUtils.getNowDate());
        return appVersionMapper.insertAppVersion(appVersion);
    }

    /**
     * 修改版本控制
     * 
     * @param appVersion 版本控制
     * @return 结果
     */
    @Override
    public int updateAppVersion(AppVersion appVersion)
    {
        appVersion.setUpdateTime(DateUtils.getNowDate());
        return appVersionMapper.updateAppVersion(appVersion);
    }

    /**
     * 批量删除版本控制
     * 
     * @param ids 需要删除的版本控制ID
     * @return 结果
     */
    @Override
    public int deleteAppVersionByIds(Long[] ids)
    {
        return appVersionMapper.deleteAppVersionByIds(ids);
    }

    /**
     * 删除版本控制信息
     * 
     * @param id 版本控制ID
     * @return 结果
     */
    @Override
    public int deleteAppVersionById(Long id)
    {
        return appVersionMapper.deleteAppVersionById(id);
    }
}
