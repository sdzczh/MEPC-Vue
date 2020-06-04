package com.ruoyi.project.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.AccountMapper;
import com.ruoyi.project.system.domain.Account;
import com.ruoyi.project.system.service.IAccountService;

/**
 * 账户管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-09
 */
@Service
public class AccountServiceImpl implements IAccountService 
{
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 查询账户管理
     * 
     * @param id 账户管理ID
     * @return 账户管理
     */
    @Override
    public Account selectAccountById(Long id)
    {
        return accountMapper.selectAccountById(id);
    }

    /**
     * 查询账户管理列表
     * 
     * @param account 账户管理
     * @return 账户管理
     */
    @Override
    public List<Account> selectAccountList(Account account)
    {
        return accountMapper.selectAccountList(account);
    }
    /**
     * 查询账户管理列表
     *
     * @param account 账户管理
     * @return 账户管理
     */
    @Override
    public List<Map<String, Object>> selectAccountLists(Map<String, Object> account)
    {
        return accountMapper.selectAccountLists(account);
    }

    /**
     * 新增账户管理
     * 
     * @param account 账户管理
     * @return 结果
     */
    @Override
    public int insertAccount(Account account)
    {
        account.setCreateTime(DateUtils.getNowDate());
        return accountMapper.insertAccount(account);
    }

    /**
     * 修改账户管理
     * 
     * @param account 账户管理
     * @return 结果
     */
    @Override
    public int updateAccount(Account account)
    {
        account.setUpdateTime(DateUtils.getNowDate());
        return accountMapper.updateAccount(account);
    }

    /**
     * 批量删除账户管理
     * 
     * @param ids 需要删除的账户管理ID
     * @return 结果
     */
    @Override
    public int deleteAccountByIds(Long[] ids)
    {
        return accountMapper.deleteAccountByIds(ids);
    }

    /**
     * 删除账户管理信息
     * 
     * @param id 账户管理ID
     * @return 结果
     */
    @Override
    public int deleteAccountById(Long id)
    {
        return accountMapper.deleteAccountById(id);
    }
}
