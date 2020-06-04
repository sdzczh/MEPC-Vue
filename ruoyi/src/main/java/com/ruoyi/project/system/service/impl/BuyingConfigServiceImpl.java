package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.BuyingConfigMapper;
import com.ruoyi.project.system.domain.BuyingConfig;
import com.ruoyi.project.system.service.IBuyingConfigService;

/**
 * 矿池配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-11
 */
@Service
public class BuyingConfigServiceImpl implements IBuyingConfigService 
{
    @Autowired
    private BuyingConfigMapper buyingConfigMapper;

    /**
     * 查询矿池配置
     * 
     * @param id 矿池配置ID
     * @return 矿池配置
     */
    @Override
    public BuyingConfig selectBuyingConfigById(Long id)
    {
        return buyingConfigMapper.selectBuyingConfigById(id);
    }

    /**
     * 查询矿池配置列表
     * 
     * @param buyingConfig 矿池配置
     * @return 矿池配置
     */
    @Override
    public List<BuyingConfig> selectBuyingConfigList(BuyingConfig buyingConfig)
    {
        return buyingConfigMapper.selectBuyingConfigList(buyingConfig);
    }

    /**
     * 新增矿池配置
     * 
     * @param buyingConfig 矿池配置
     * @return 结果
     */
    @Override
    public int insertBuyingConfig(BuyingConfig buyingConfig)
    {
        buyingConfig.setCreateTime(DateUtils.getNowDate());
        return buyingConfigMapper.insertBuyingConfig(buyingConfig);
    }

    /**
     * 修改矿池配置
     * 
     * @param buyingConfig 矿池配置
     * @return 结果
     */
    @Override
    public int updateBuyingConfig(BuyingConfig buyingConfig)
    {
        buyingConfig.setUpdateTime(DateUtils.getNowDate());
        return buyingConfigMapper.updateBuyingConfig(buyingConfig);
    }

    /**
     * 批量删除矿池配置
     * 
     * @param ids 需要删除的矿池配置ID
     * @return 结果
     */
    @Override
    public int deleteBuyingConfigByIds(Long[] ids)
    {
        return buyingConfigMapper.deleteBuyingConfigByIds(ids);
    }

    /**
     * 删除矿池配置信息
     * 
     * @param id 矿池配置ID
     * @return 结果
     */
    @Override
    public int deleteBuyingConfigById(Long id)
    {
        return buyingConfigMapper.deleteBuyingConfigById(id);
    }
}
