package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.C2cManageMapper;
import com.ruoyi.project.system.domain.C2cManage;
import com.ruoyi.project.system.service.IC2cManageService;

/**
 * 法币交易管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@Service
public class C2cManageServiceImpl implements IC2cManageService 
{
    @Autowired
    private C2cManageMapper c2cManageMapper;

    /**
     * 查询法币交易管理
     * 
     * @param id 法币交易管理ID
     * @return 法币交易管理
     */
    @Override
    public C2cManage selectC2cManageById(Long id)
    {
        return c2cManageMapper.selectC2cManageById(id);
    }

    /**
     * 查询法币交易管理列表
     * 
     * @param c2cManage 法币交易管理
     * @return 法币交易管理
     */
    @Override
    public List<C2cManage> selectC2cManageList(C2cManage c2cManage)
    {
        return c2cManageMapper.selectC2cManageList(c2cManage);
    }

    /**
     * 新增法币交易管理
     * 
     * @param c2cManage 法币交易管理
     * @return 结果
     */
    @Override
    public int insertC2cManage(C2cManage c2cManage)
    {
        c2cManage.setCreateTime(DateUtils.getNowDate());
        return c2cManageMapper.insertC2cManage(c2cManage);
    }

    /**
     * 修改法币交易管理
     * 
     * @param c2cManage 法币交易管理
     * @return 结果
     */
    @Override
    public int updateC2cManage(C2cManage c2cManage)
    {
        c2cManage.setUpdateTime(DateUtils.getNowDate());
        return c2cManageMapper.updateC2cManage(c2cManage);
    }

    /**
     * 批量删除法币交易管理
     * 
     * @param ids 需要删除的法币交易管理ID
     * @return 结果
     */
    @Override
    public int deleteC2cManageByIds(Long[] ids)
    {
        return c2cManageMapper.deleteC2cManageByIds(ids);
    }

    /**
     * 删除法币交易管理信息
     * 
     * @param id 法币交易管理ID
     * @return 结果
     */
    @Override
    public int deleteC2cManageById(Long id)
    {
        return c2cManageMapper.deleteC2cManageById(id);
    }
}
