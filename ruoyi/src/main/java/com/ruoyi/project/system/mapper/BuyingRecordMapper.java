package com.ruoyi.project.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.domain.BuyingRecord;
import org.apache.ibatis.annotations.Param;

/**
 * 矿池记录Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public interface BuyingRecordMapper 
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
     * 删除矿池记录
     * 
     * @param id 矿池记录ID
     * @return 结果
     */
    public int deleteBuyingRecordById(Long id);

    /**
     * 批量删除矿池记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBuyingRecordByIds(Long[] ids);

    List<Map<String, Object>> selectBuyingRecordLists(@Param("phone") String phone);
}
