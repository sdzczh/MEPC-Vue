package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.CoinManageMapper;
import com.ruoyi.project.system.domain.CoinManage;
import com.ruoyi.project.system.service.ICoinManageService;

/**
 * 币种管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@Service
public class CoinManageServiceImpl implements ICoinManageService 
{
    @Autowired
    private CoinManageMapper coinManageMapper;

    /**
     * 查询币种管理
     * 
     * @param id 币种管理ID
     * @return 币种管理
     */
    @Override
    public CoinManage selectCoinManageById(Long id)
    {
        return coinManageMapper.selectCoinManageById(id);
    }

    /**
     * 查询币种管理列表
     * 
     * @param coinManage 币种管理
     * @return 币种管理
     */
    @Override
    public List<CoinManage> selectCoinManageList(CoinManage coinManage)
    {
        return coinManageMapper.selectCoinManageList(coinManage);
    }

    /**
     * 新增币种管理
     * 
     * @param coinManage 币种管理
     * @return 结果
     */
    @Override
    public int insertCoinManage(CoinManage coinManage)
    {
        coinManage.setCreateTime(DateUtils.getNowDate());
        return coinManageMapper.insertCoinManage(coinManage);
    }

    /**
     * 修改币种管理
     * 
     * @param coinManage 币种管理
     * @return 结果
     */
    @Override
    public int updateCoinManage(CoinManage coinManage)
    {
        coinManage.setUpdateTime(DateUtils.getNowDate());
        return coinManageMapper.updateCoinManage(coinManage);
    }

    /**
     * 批量删除币种管理
     * 
     * @param ids 需要删除的币种管理ID
     * @return 结果
     */
    @Override
    public int deleteCoinManageByIds(Long[] ids)
    {
        return coinManageMapper.deleteCoinManageByIds(ids);
    }

    /**
     * 删除币种管理信息
     * 
     * @param id 币种管理ID
     * @return 结果
     */
    @Override
    public int deleteCoinManageById(Long id)
    {
        return coinManageMapper.deleteCoinManageById(id);
    }
}
