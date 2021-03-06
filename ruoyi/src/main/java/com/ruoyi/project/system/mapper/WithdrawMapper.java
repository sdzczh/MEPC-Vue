package com.ruoyi.project.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.domain.Withdraw;

/**
 * 提现管理Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public interface WithdrawMapper 
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
     * 删除提现管理
     * 
     * @param id 提现管理ID
     * @return 结果
     */
    public int deleteWithdrawById(Long id);

    /**
     * 批量删除提现管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWithdrawByIds(Long[] ids);

    List<Map<String, Object>> selectWithdrawLists(Map<String, Object> param);
}
