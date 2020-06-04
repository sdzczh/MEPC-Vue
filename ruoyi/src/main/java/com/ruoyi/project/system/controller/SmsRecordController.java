package com.ruoyi.project.system.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.domain.SmsRecord;
import com.ruoyi.project.system.service.ISmsRecordService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 短信记录Controller
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@RestController
@RequestMapping("/system/smsRecord")
public class SmsRecordController extends BaseController
{
    @Autowired
    private ISmsRecordService smsRecordService;

    /**
     * 查询短信记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:smsRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(SmsRecord smsRecord)
    {
        startPage();
        List<SmsRecord> list = smsRecordService.selectSmsRecordList(smsRecord);
        return getDataTable(list);
    }

    /**
     * 导出短信记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:smsRecord:export')")
    @Log(title = "短信记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SmsRecord smsRecord)
    {
        List<SmsRecord> list = smsRecordService.selectSmsRecordList(smsRecord);
        ExcelUtil<SmsRecord> util = new ExcelUtil<SmsRecord>(SmsRecord.class);
        return util.exportExcel(list, "smsRecord");
    }

    /**
     * 获取短信记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:smsRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(smsRecordService.selectSmsRecordById(id));
    }

    /**
     * 新增短信记录
     */
    @PreAuthorize("@ss.hasPermi('system:smsRecord:add')")
    @Log(title = "短信记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsRecord smsRecord)
    {
        return toAjax(smsRecordService.insertSmsRecord(smsRecord));
    }

    /**
     * 修改短信记录
     */
    @PreAuthorize("@ss.hasPermi('system:smsRecord:edit')")
    @Log(title = "短信记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsRecord smsRecord)
    {
        return toAjax(smsRecordService.updateSmsRecord(smsRecord));
    }

    /**
     * 删除短信记录
     */
    @PreAuthorize("@ss.hasPermi('system:smsRecord:remove')")
    @Log(title = "短信记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsRecordService.deleteSmsRecordByIds(ids));
    }
}
