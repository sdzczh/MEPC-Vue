package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.AccountTransfer;

/**
 * 资金划转管理Service接口
 * 
 * @author ruoyi
 * @date 2020-03-23
 */
public interface IAccountTransferService 
{
    /**
     * 查询资金划转管理
     * 
     * @param id 资金划转管理ID
     * @return 资金划转管理
     */
    public AccountTransfer selectAccountTransferById(Long id);

    /**
     * 查询资金划转管理列表
     * 
     * @param accountTransfer 资金划转管理
     * @return 资金划转管理集合
     */
    public List<AccountTransfer> selectAccountTransferList(AccountTransfer accountTransfer);

    /**
     * 新增资金划转管理
     * 
     * @param accountTransfer 资金划转管理
     * @return 结果
     */
    public int insertAccountTransfer(AccountTransfer accountTransfer);

    /**
     * 修改资金划转管理
     * 
     * @param accountTransfer 资金划转管理
     * @return 结果
     */
    public int updateAccountTransfer(AccountTransfer accountTransfer);

    /**
     * 批量删除资金划转管理
     * 
     * @param ids 需要删除的资金划转管理ID
     * @return 结果
     */
    public int deleteAccountTransferByIds(Long[] ids);

    /**
     * 删除资金划转管理信息
     * 
     * @param id 资金划转管理ID
     * @return 结果
     */
    public int deleteAccountTransferById(Long id);
}
