package com.ruoyi.project.system.service;

import com.ruoyi.project.system.domain.Withdraw;

import java.util.List;
import java.util.Map;

/**
 * 提现管理Service接口
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public interface IWithdrawService 
{
    /**
     * 查询提现管理
     * 
     * @param id 提现管理ID
     * @return 提现管理
     */
    public Withdraw selectWithdrawById(Long id);

    /**
     * 查询提现管理列表
     * 
     * @param withdraw 提现管理
     * @return 提现管理集合
     */
    public List<Withdraw> selectWithdrawList(Withdraw withdraw);

    /**
     * 新增提现管理
     * 
     * @param withdraw 提现管理
     * @return 结果
     */
    public int insertWithdraw(Withdraw withdraw);

    /**
     * 修改提现管理
     * 
     * @param withdraw 提现管理
     * @return 结果
     */
    public int updateWithdraw(Withdraw withdraw);

    /**
     * 批量删除提现管理
     * 
     * @param ids 需要删除的提现管理ID
     * @return 结果
     */
    public int deleteWithdrawByIds(Long[] ids);

    /**
     * 删除提现管理信息
     * 
     * @param id 提现管理ID
     * @return 结果
     */
    public int deleteWithdrawById(Long id);

    List<Map<String, Object>> selectWithdrawLists(Map<String, Object> param);
}
