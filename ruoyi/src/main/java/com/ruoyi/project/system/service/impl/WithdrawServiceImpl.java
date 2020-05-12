package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.WithdrawMapper;
import com.ruoyi.project.system.domain.Withdraw;
import com.ruoyi.project.system.service.IWithdrawService;

/**
 * 提现管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@Service
public class WithdrawServiceImpl implements IWithdrawService 
{
    @Autowired
    private WithdrawMapper withdrawMapper;

    /**
     * 查询提现管理
     * 
     * @param id 提现管理ID
     * @return 提现管理
     */
    @Override
    public Withdraw selectWithdrawById(Long id)
    {
        return withdrawMapper.selectWithdrawById(id);
    }

    /**
     * 查询提现管理列表
     * 
     * @param withdraw 提现管理
     * @return 提现管理
     */
    @Override
    public List<Withdraw> selectWithdrawList(Withdraw withdraw)
    {
        return withdrawMapper.selectWithdrawList(withdraw);
    }

    /**
     * 新增提现管理
     * 
     * @param withdraw 提现管理
     * @return 结果
     */
    @Override
    public int insertWithdraw(Withdraw withdraw)
    {
        withdraw.setCreateTime(DateUtils.getNowDate());
        return withdrawMapper.insertWithdraw(withdraw);
    }

    /**
     * 修改提现管理
     * 
     * @param withdraw 提现管理
     * @return 结果
     */
    @Override
    public int updateWithdraw(Withdraw withdraw)
    {
        withdraw.setUpdateTime(DateUtils.getNowDate());
        return withdrawMapper.updateWithdraw(withdraw);
    }

    /**
     * 批量删除提现管理
     * 
     * @param ids 需要删除的提现管理ID
     * @return 结果
     */
    @Override
    public int deleteWithdrawByIds(Long[] ids)
    {
        return withdrawMapper.deleteWithdrawByIds(ids);
    }

    /**
     * 删除提现管理信息
     * 
     * @param id 提现管理ID
     * @return 结果
     */
    @Override
    public int deleteWithdrawById(Long id)
    {
        return withdrawMapper.deleteWithdrawById(id);
    }
}
