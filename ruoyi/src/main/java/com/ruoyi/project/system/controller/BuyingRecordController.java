package com.ruoyi.project.system.controller;

import java.util.List;
import java.util.Map;

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
import com.ruoyi.project.system.domain.BuyingRecord;
import com.ruoyi.project.system.service.IBuyingRecordService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 矿池记录Controller
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@RestController
@RequestMapping("/system/buyingRecord")
public class BuyingRecordController extends BaseController
{
    @Autowired
    private IBuyingRecordService buyingRecordService;

    /**
     * 查询矿池记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:buyingRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(String phone)
    {
        startPage();
        List<Map<String, Object>> list = buyingRecordService.selectBuyingRecordLists(phone);
        return getDataTable(list);
    }

    /**
     * 导出矿池记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:buyingRecord:export')")
    @Log(title = "矿池记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BuyingRecord buyingRecord)
    {
        List<BuyingRecord> list = buyingRecordService.selectBuyingRecordList(buyingRecord);
        ExcelUtil<BuyingRecord> util = new ExcelUtil<BuyingRecord>(BuyingRecord.class);
        return util.exportExcel(list, "buyingRecord");
    }

    /**
     * 获取矿池记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:buyingRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(buyingRecordService.selectBuyingRecordById(id));
    }

    /**
     * 新增矿池记录
     */
    @PreAuthorize("@ss.hasPermi('system:buyingRecord:add')")
    @Log(title = "矿池记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BuyingRecord buyingRecord)
    {
        return toAjax(buyingRecordService.insertBuyingRecord(buyingRecord));
    }

    /**
     * 修改矿池记录
     */
    @PreAuthorize("@ss.hasPermi('system:buyingRecord:edit')")
    @Log(title = "矿池记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BuyingRecord buyingRecord)
    {
        return toAjax(buyingRecordService.updateBuyingRecord(buyingRecord));
    }

    /**
     * 删除矿池记录
     */
    @PreAuthorize("@ss.hasPermi('system:buyingRecord:remove')")
    @Log(title = "矿池记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(buyingRecordService.deleteBuyingRecordByIds(ids));
    }
}
