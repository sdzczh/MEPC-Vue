package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.SmsRecordMapper;
import com.ruoyi.project.system.domain.SmsRecord;
import com.ruoyi.project.system.service.ISmsRecordService;

/**
 * 短信记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@Service
public class SmsRecordServiceImpl implements ISmsRecordService 
{
    @Autowired
    private SmsRecordMapper smsRecordMapper;

    /**
     * 查询短信记录
     * 
     * @param id 短信记录ID
     * @return 短信记录
     */
    @Override
    public SmsRecord selectSmsRecordById(Long id)
    {
        return smsRecordMapper.selectSmsRecordById(id);
    }

    /**
     * 查询短信记录列表
     * 
     * @param smsRecord 短信记录
     * @return 短信记录
     */
    @Override
    public List<SmsRecord> selectSmsRecordList(SmsRecord smsRecord)
    {
        return smsRecordMapper.selectSmsRecordList(smsRecord);
    }

    /**
     * 新增短信记录
     * 
     * @param smsRecord 短信记录
     * @return 结果
     */
    @Override
    public int insertSmsRecord(SmsRecord smsRecord)
    {
        smsRecord.setCreateTime(DateUtils.getNowDate());
        return smsRecordMapper.insertSmsRecord(smsRecord);
    }

    /**
     * 修改短信记录
     * 
     * @param smsRecord 短信记录
     * @return 结果
     */
    @Override
    public int updateSmsRecord(SmsRecord smsRecord)
    {
        smsRecord.setUpdateTime(DateUtils.getNowDate());
        return smsRecordMapper.updateSmsRecord(smsRecord);
    }

    /**
     * 批量删除短信记录
     * 
     * @param ids 需要删除的短信记录ID
     * @return 结果
     */
    @Override
    public int deleteSmsRecordByIds(Long[] ids)
    {
        return smsRecordMapper.deleteSmsRecordByIds(ids);
    }

    /**
     * 删除短信记录信息
     * 
     * @param id 短信记录ID
     * @return 结果
     */
    @Override
    public int deleteSmsRecordById(Long id)
    {
        return smsRecordMapper.deleteSmsRecordById(id);
    }
}
