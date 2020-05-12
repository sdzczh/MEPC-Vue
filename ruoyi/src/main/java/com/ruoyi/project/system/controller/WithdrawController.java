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
import com.ruoyi.project.system.domain.Withdraw;
import com.ruoyi.project.system.service.IWithdrawService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 提现管理Controller
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@RestController
@RequestMapping("/system/withdraw")
public class WithdrawController extends BaseController
{
    @Autowired
    private IWithdrawService withdrawService;

    /**
     * 查询提现管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:withdraw:list')")
    @GetMapping("/list")
    public TableDataInfo list(Withdraw withdraw)
    {
        startPage();
        List<Withdraw> list = withdrawService.selectWithdrawList(withdraw);
        return getDataTable(list);
    }

    /**
     * 导出提现管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:withdraw:export')")
    @Log(title = "提现管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Withdraw withdraw)
    {
        List<Withdraw> list = withdrawService.selectWithdrawList(withdraw);
        ExcelUtil<Withdraw> util = new ExcelUtil<Withdraw>(Withdraw.class);
        return util.exportExcel(list, "withdraw");
    }

    /**
     * 获取提现管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:withdraw:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(withdrawService.selectWithdrawById(id));
    }

    /**
     * 新增提现管理
     */
    @PreAuthorize("@ss.hasPermi('system:withdraw:add')")
    @Log(title = "提现管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Withdraw withdraw)
    {
        return toAjax(withdrawService.insertWithdraw(withdraw));
    }

    /**
     * 修改提现管理
     */
    @PreAuthorize("@ss.hasPermi('system:withdraw:edit')")
    @Log(title = "提现管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Withdraw withdraw)
    {
        return toAjax(withdrawService.updateWithdraw(withdraw));
    }

    /**
     * 删除提现管理
     */
    @PreAuthorize("@ss.hasPermi('system:withdraw:remove')")
    @Log(title = "提现管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(withdrawService.deleteWithdrawByIds(ids));
    }
}
