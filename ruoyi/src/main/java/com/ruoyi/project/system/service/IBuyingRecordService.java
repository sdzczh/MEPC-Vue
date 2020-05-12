package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.BuyingRecord;

/**
 * 矿池记录Service接口
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public interface IBuyingRecordService 
{
    /**
     * 查询矿池记录
     * 
     * @param id 矿池记录ID
     * @return 矿池记录
     */
    public BuyingRecord selectBuyingRecordById(Long id);

    /**
     * 查询矿池记录列表
     * 
     * @param buyingRecord 矿池记录
     * @return 矿池记录集合
     */
    public List<BuyingRecord> selectBuyingRecordList(BuyingRecord buyingRecord);

    /**
     * 新增矿池记录
     * 
     * @param buyingRecord 矿池记录
     * @return 结果
     */
    public int insertBuyingRecord(BuyingRecord buyingRecord);

    /**
     * 修改矿池记录
     * 
     * @param buyingRecord 矿池记录
     * @return 结果
     */
    public int updateBuyingRecord(BuyingRecord buyingRecord);

    /**
     * 批量删除矿池记录
     * 
     * @param ids 需要删除的矿池记录ID
     * @return 结果
     */
    public int deleteBuyingRecordByIds(Long[] ids);

    /**
     * 删除矿池记录信息
     * 
     * @param id 矿池记录ID
     * @return 结果
     */
    public int deleteBuyingRecordById(Long id);
}
