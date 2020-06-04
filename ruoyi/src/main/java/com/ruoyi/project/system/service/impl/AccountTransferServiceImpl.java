package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.AccountTransferMapper;
import com.ruoyi.project.system.domain.AccountTransfer;
import com.ruoyi.project.system.service.IAccountTransferService;

/**
 * 资金划转管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-23
 */
@Service
public class AccountTransferServiceImpl implements IAccountTransferService 
{
    @Autowired
    private AccountTransferMapper accountTransferMapper;

    /**
     * 查询资金划转管理
     * 
     * @param id 资金划转管理ID
     * @return 资金划转管理
     */
    @Override
    public AccountTransfer selectAccountTransferById(Long id)
    {
        return accountTransferMapper.selectAccountTransferById(id);
    }

    /**
     * 查询资金划转管理列表
     * 
     * @param accountTransfer 资金划转管理
     * @return 资金划转管理
     */
    @Override
    public List<AccountTransfer> selectAccountTransferList(AccountTransfer accountTransfer)
    {
        return accountTransferMapper.selectAccountTransferList(accountTransfer);
    }

    /**
     * 新增资金划转管理
     * 
     * @param accountTransfer 资金划转管理
     * @return 结果
     */
    @Override
    public int insertAccountTransfer(AccountTransfer accountTransfer)
    {
        accountTransfer.setCreateTime(DateUtils.getNowDate());
        return accountTransferMapper.insertAccountTransfer(accountTransfer);
    }

    /**
     * 修改资金划转管理
     * 
     * @param accountTransfer 资金划转管理
     * @return 结果
     */
    @Override
    public int updateAccountTransfer(AccountTransfer accountTransfer)
    {
        accountTransfer.setUpdateTime(DateUtils.getNowDate());
        return accountTransferMapper.updateAccountTransfer(accountTransfer);
    }

    /**
     * 批量删除资金划转管理
     * 
     * @param ids 需要删除的资金划转管理ID
     * @return 结果
     */
    @Override
    public int deleteAccountTransferByIds(Long[] ids)
    {
        return accountTransferMapper.deleteAccountTransferByIds(ids);
    }

    /**
     * 删除资金划转管理信息
     * 
     * @param id 资金划转管理ID
     * @return 结果
     */
    @Override
    public int deleteAccountTransferById(Long id)
    {
        return accountTransferMapper.deleteAccountTransferById(id);
    }
}
