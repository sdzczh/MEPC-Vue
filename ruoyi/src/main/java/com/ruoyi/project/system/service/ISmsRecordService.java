package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.SmsRecord;

/**
 * 短信记录Service接口
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public interface ISmsRecordService 
{
    /**
     * 查询短信记录
     * 
     * @param id 短信记录ID
     * @return 短信记录
     */
    public SmsRecord selectSmsRecordById(Long id);

    /**
     * 查询短信记录列表
     * 
     * @param smsRecord 短信记录
     * @return 短信记录集合
     */
    public List<SmsRecord> selectSmsRecordList(SmsRecord smsRecord);

    /**
     * 新增短信记录
     * 
     * @param smsRecord 短信记录
     * @return 结果
     */
    public int insertSmsRecord(SmsRecord smsRecord);

    /**
     * 修改短信记录
     * 
     * @param smsRecord 短信记录
     * @return 结果
     */
    public int updateSmsRecord(SmsRecord smsRecord);

    /**
     * 批量删除短信记录
     * 
     * @param ids 需要删除的短信记录ID
     * @return 结果
     */
    public int deleteSmsRecordByIds(Long[] ids);

    /**
     * 删除短信记录信息
     * 
     * @param id 短信记录ID
     * @return 结果
     */
    public int deleteSmsRecordById(Long id);
}
