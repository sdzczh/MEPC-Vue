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
import com.ruoyi.project.system.domain.C2cManage;
import com.ruoyi.project.system.service.IC2cManageService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 法币交易管理Controller
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@RestController
@RequestMapping("/system/c2cManage")
public class C2cManageController extends BaseController
{
    @Autowired
    private IC2cManageService c2cManageService;

    /**
     * 查询法币交易管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:c2cManage:list')")
    @GetMapping("/list")
    public TableDataInfo list(C2cManage c2cManage)
    {
        startPage();
        List<C2cManage> list = c2cManageService.selectC2cManageList(c2cManage);
        return getDataTable(list);
    }

    /**
     * 导出法币交易管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:c2cManage:export')")
    @Log(title = "法币交易管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(C2cManage c2cManage)
    {
        List<C2cManage> list = c2cManageService.selectC2cManageList(c2cManage);
        ExcelUtil<C2cManage> util = new ExcelUtil<C2cManage>(C2cManage.class);
        return util.exportExcel(list, "c2cManage");
    }

    /**
     * 获取法币交易管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:c2cManage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(c2cManageService.selectC2cManageById(id));
    }

    /**
     * 新增法币交易管理
     */
    @PreAuthorize("@ss.hasPermi('system:c2cManage:add')")
    @Log(title = "法币交易管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody C2cManage c2cManage)
    {
        return toAjax(c2cManageService.insertC2cManage(c2cManage));
    }

    /**
     * 修改法币交易管理
     */
    @PreAuthorize("@ss.hasPermi('system:c2cManage:edit')")
    @Log(title = "法币交易管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody C2cManage c2cManage)
    {
        return toAjax(c2cManageService.updateC2cManage(c2cManage));
    }

    /**
     * 删除法币交易管理
     */
    @PreAuthorize("@ss.hasPermi('system:c2cManage:remove')")
    @Log(title = "法币交易管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(c2cManageService.deleteC2cManageByIds(ids));
    }
}
