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
import com.ruoyi.project.system.domain.BindInfo;
import com.ruoyi.project.system.service.IBindInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 支付绑定信息Controller
 * 
 * @author ruoyi
 * @date 2020-05-10
 */
@RestController
@RequestMapping("/system/info")
public class BindInfoController extends BaseController
{
    @Autowired
    private IBindInfoService bindInfoService;

    /**
     * 查询支付绑定信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(String phone)
    {
        startPage();
        List<Map<String, Object>> list = bindInfoService.selectBindInfoLists(phone);
        return getDataTable(list);
    }

    /**
     * 导出支付绑定信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:export')")
    @Log(title = "支付绑定信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BindInfo bindInfo)
    {
        List<BindInfo> list = bindInfoService.selectBindInfoList(bindInfo);
        ExcelUtil<BindInfo> util = new ExcelUtil<BindInfo>(BindInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取支付绑定信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(bindInfoService.selectBindInfoById(id));
    }

    /**
     * 新增支付绑定信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @Log(title = "支付绑定信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BindInfo bindInfo)
    {
        return toAjax(bindInfoService.insertBindInfo(bindInfo));
    }

    /**
     * 修改支付绑定信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @Log(title = "支付绑定信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BindInfo bindInfo)
    {
        return toAjax(bindInfoService.updateBindInfo(bindInfo));
    }

    /**
     * 删除支付绑定信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:remove')")
    @Log(title = "支付绑定信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bindInfoService.deleteBindInfoByIds(ids));
    }
}
