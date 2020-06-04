package com.ruoyi.project.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.BuyingRecordMapper;
import com.ruoyi.project.system.domain.BuyingRecord;
import com.ruoyi.project.system.service.IBuyingRecordService;

/**
 * 矿池记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@Service
public class BuyingRecordServiceImpl implements IBuyingRecordService 
{
    @Autowired
    private BuyingRecordMapper buyingRecordMapper;

    /**
     * 查询矿池记录
     * 
     * @param id 矿池记录ID
     * @return 矿池记录
     */
    @Override
    public BuyingRecord selectBuyingRecordById(Long id)
    {
        return buyingRecordMapper.selectBuyingRecordById(id);
    }

    /**
     * 查询矿池记录列表
     * 
     * @param buyingRecord 矿池记录
     * @return 矿池记录
     */
    @Override
    public List<BuyingRecord> selectBuyingRecordList(BuyingRecord buyingRecord)
    {
        return buyingRecordMapper.selectBuyingRecordList(buyingRecord);
    }

    /**
     * 新增矿池记录
     * 
     * @param buyingRecord 矿池记录
     * @return 结果
     */
    @Override
    public int insertBuyingRecord(BuyingRecord buyingRecord)
    {
        buyingRecord.setCreateTime(DateUtils.getNowDate());
        return buyingRecordMapper.insertBuyingRecord(buyingRecord);
    }

    /**
     * 修改矿池记录
     * 
     * @param buyingRecord 矿池记录
     * @return 结果
     */
    @Override
    public int updateBuyingRecord(BuyingRecord buyingRecord)
    {
        buyingRecord.setUpdateTime(DateUtils.getNowDate());
        return buyingRecordMapper.updateBuyingRecord(buyingRecord);
    }

    /**
     * 批量删除矿池记录
     * 
     * @param ids 需要删除的矿池记录ID
     * @return 结果
     */
    @Override
    public int deleteBuyingRecordByIds(Long[] ids)
    {
        return buyingRecordMapper.deleteBuyingRecordByIds(ids);
    }

    /**
     * 删除矿池记录信息
     * 
     * @param id 矿池记录ID
     * @return 结果
     */
    @Override
    public int deleteBuyingRecordById(Long id)
    {
        return buyingRecordMapper.deleteBuyingRecordById(id);
    }

    @Override
    public List<Map<String, Object>> selectBuyingRecordLists(String phone) {
        return buyingRecordMapper.selectBuyingRecordLists(phone);
    }
}
