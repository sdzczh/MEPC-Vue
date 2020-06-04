package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.BuyingConfig;

/**
 * 矿池配置Service接口
 * 
 * @author ruoyi
 * @date 2020-05-11
 */
public interface IBuyingConfigService 
{
    /**
     * 查询矿池配置
     * 
     * @param id 矿池配置ID
     * @return 矿池配置
     */
    public BuyingConfig selectBuyingConfigById(Long id);

    /**
     * 查询矿池配置列表
     * 
     * @param buyingConfig 矿池配置
     * @return 矿池配置集合
     */
    public List<BuyingConfig> selectBuyingConfigList(BuyingConfig buyingConfig);

    /**
     * 新增矿池配置
     * 
     * @param buyingConfig 矿池配置
     * @return 结果
     */
    public int insertBuyingConfig(BuyingConfig buyingConfig);

    /**
     * 修改矿池配置
     * 
     * @param buyingConfig 矿池配置
     * @return 结果
     */
    public int updateBuyingConfig(BuyingConfig buyingConfig);

    /**
     * 批量删除矿池配置
     * 
     * @param ids 需要删除的矿池配置ID
     * @return 结果
     */
    public int deleteBuyingConfigByIds(Long[] ids);

    /**
     * 删除矿池配置信息
     * 
     * @param id 矿池配置ID
     * @return 结果
     */
    public int deleteBuyingConfigById(Long id);
}
