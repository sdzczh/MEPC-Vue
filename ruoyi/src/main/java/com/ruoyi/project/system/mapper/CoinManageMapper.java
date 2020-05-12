package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.CoinManage;

/**
 * 币种管理Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public interface CoinManageMapper 
{
    /**
     * 查询币种管理
     * 
     * @param id 币种管理ID
     * @return 币种管理
     */
    public CoinManage selectCoinManageById(Long id);

    /**
     * 查询币种管理列表
     * 
     * @param coinManage 币种管理
     * @return 币种管理集合
     */
    public List<CoinManage> selectCoinManageList(CoinManage coinManage);

    /**
     * 新增币种管理
     * 
     * @param coinManage 币种管理
     * @return 结果
     */
    public int insertCoinManage(CoinManage coinManage);

    /**
     * 修改币种管理
     * 
     * @param coinManage 币种管理
     * @return 结果
     */
    public int updateCoinManage(CoinManage coinManage);

    /**
     * 删除币种管理
     * 
     * @param id 币种管理ID
     * @return 结果
     */
    public int deleteCoinManageById(Long id);

    /**
     * 批量删除币种管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCoinManageByIds(Long[] ids);
}
