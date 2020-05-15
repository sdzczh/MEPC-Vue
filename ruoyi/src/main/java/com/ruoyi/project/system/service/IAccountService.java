package com.ruoyi.project.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.domain.Account;

/**
 * 账户管理Service接口
 * 
 * @author ruoyi
 * @date 2020-05-09
 */
public interface IAccountService 
{
    /**
     * 查询账户管理
     * 
     * @param id 账户管理ID
     * @return 账户管理
     */
    public Account selectAccountById(Long id);

    /**
     * 查询账户管理列表
     * 
     * @param account 账户管理
     * @return 账户管理集合
     */
    public List<Account> selectAccountList(Account account);

    /**
     * 新增账户管理
     * 
     * @param account 账户管理
     * @return 结果
     */
    public int insertAccount(Account account);

    /**
     * 修改账户管理
     * 
     * @param account 账户管理
     * @return 结果
     */
    public int updateAccount(Account account);

    /**
     * 批量删除账户管理
     * 
     * @param ids 需要删除的账户管理ID
     * @return 结果
     */
    public int deleteAccountByIds(Long[] ids);

    /**
     * 删除账户管理信息
     * 
     * @param id 账户管理ID
     * @return 结果
     */
    public int deleteAccountById(Long id);

    List<Map<String, Object>> selectAccountLists(Account account);
}
