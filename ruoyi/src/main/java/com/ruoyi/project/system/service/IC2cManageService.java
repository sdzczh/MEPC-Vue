package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.C2cManage;

/**
 * 法币交易管理Service接口
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public interface IC2cManageService 
{
    /**
     * 查询法币交易管理
     * 
     * @param id 法币交易管理ID
     * @return 法币交易管理
     */
    public C2cManage selectC2cManageById(Long id);

    /**
     * 查询法币交易管理列表
     * 
     * @param c2cManage 法币交易管理
     * @return 法币交易管理集合
     */
    public List<C2cManage> selectC2cManageList(C2cManage c2cManage);

    /**
     * 新增法币交易管理
     * 
     * @param c2cManage 法币交易管理
     * @return 结果
     */
    public int insertC2cManage(C2cManage c2cManage);

    /**
     * 修改法币交易管理
     * 
     * @param c2cManage 法币交易管理
     * @return 结果
     */
    public int updateC2cManage(C2cManage c2cManage);

    /**
     * 批量删除法币交易管理
     * 
     * @param ids 需要删除的法币交易管理ID
     * @return 结果
     */
    public int deleteC2cManageByIds(Long[] ids);

    /**
     * 删除法币交易管理信息
     * 
     * @param id 法币交易管理ID
     * @return 结果
     */
    public int deleteC2cManageById(Long id);
}
