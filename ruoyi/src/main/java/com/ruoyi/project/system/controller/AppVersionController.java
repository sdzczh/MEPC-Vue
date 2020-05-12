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
import com.ruoyi.project.system.domain.AppVersion;
import com.ruoyi.project.system.service.IAppVersionService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 版本控制Controller
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@RestController
@RequestMapping("/system/appVersion")
public class AppVersionController extends BaseController
{
    @Autowired
    private IAppVersionService appVersionService;

    /**
     * 查询版本控制列表
     */
    @PreAuthorize("@ss.hasPermi('system:appVersion:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppVersion appVersion)
    {
        startPage();
        List<AppVersion> list = appVersionService.selectAppVersionList(appVersion);
        return getDataTable(list);
    }

    /**
     * 导出版本控制列表
     */
    @PreAuthorize("@ss.hasPermi('system:appVersion:export')")
    @Log(title = "版本控制", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AppVersion appVersion)
    {
        List<AppVersion> list = appVersionService.selectAppVersionList(appVersion);
        ExcelUtil<AppVersion> util = new ExcelUtil<AppVersion>(AppVersion.class);
        return util.exportExcel(list, "appVersion");
    }

    /**
     * 获取版本控制详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:appVersion:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(appVersionService.selectAppVersionById(id));
    }

    /**
     * 新增版本控制
     */
    @PreAuthorize("@ss.hasPermi('system:appVersion:add')")
    @Log(title = "版本控制", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppVersion appVersion)
    {
        return toAjax(appVersionService.insertAppVersion(appVersion));
    }

    /**
     * 修改版本控制
     */
    @PreAuthorize("@ss.hasPermi('system:appVersion:edit')")
    @Log(title = "版本控制", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppVersion appVersion)
    {
        return toAjax(appVersionService.updateAppVersion(appVersion));
    }

    /**
     * 删除版本控制
     */
    @PreAuthorize("@ss.hasPermi('system:appVersion:remove')")
    @Log(title = "版本控制", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appVersionService.deleteAppVersionByIds(ids));
    }
}
