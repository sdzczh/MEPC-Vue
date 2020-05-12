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
import com.ruoyi.project.system.domain.Sysparams;
import com.ruoyi.project.system.service.ISysparamsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 系统参数配置Controller
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@RestController
@RequestMapping("/system/sysparams")
public class SysparamsController extends BaseController
{
    @Autowired
    private ISysparamsService sysparamsService;

    /**
     * 查询系统参数配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:sysparams:list')")
    @GetMapping("/list")
    public TableDataInfo list(Sysparams sysparams)
    {
        startPage();
        List<Sysparams> list = sysparamsService.selectSysparamsList(sysparams);
        return getDataTable(list);
    }

    /**
     * 导出系统参数配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:sysparams:export')")
    @Log(title = "系统参数配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Sysparams sysparams)
    {
        List<Sysparams> list = sysparamsService.selectSysparamsList(sysparams);
        ExcelUtil<Sysparams> util = new ExcelUtil<Sysparams>(Sysparams.class);
        return util.exportExcel(list, "sysparams");
    }

    /**
     * 获取系统参数配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:sysparams:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysparamsService.selectSysparamsById(id));
    }

    /**
     * 新增系统参数配置
     */
    @PreAuthorize("@ss.hasPermi('system:sysparams:add')")
    @Log(title = "系统参数配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Sysparams sysparams)
    {
        return toAjax(sysparamsService.insertSysparams(sysparams));
    }

    /**
     * 修改系统参数配置
     */
    @PreAuthorize("@ss.hasPermi('system:sysparams:edit')")
    @Log(title = "系统参数配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Sysparams sysparams)
    {
        return toAjax(sysparamsService.updateSysparams(sysparams));
    }

    /**
     * 删除系统参数配置
     */
    @PreAuthorize("@ss.hasPermi('system:sysparams:remove')")
    @Log(title = "系统参数配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysparamsService.deleteSysparamsByIds(ids));
    }
}
