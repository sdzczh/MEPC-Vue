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
import com.ruoyi.project.system.domain.AccountTransfer;
import com.ruoyi.project.system.service.IAccountTransferService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 资金划转管理Controller
 * 
 * @author ruoyi
 * @date 2020-03-23
 */
@RestController
@RequestMapping("/system/transfer")
public class AccountTransferController extends BaseController
{
    @Autowired
    private IAccountTransferService accountTransferService;

    /**
     * 查询资金划转管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:transfer:list')")
    @GetMapping("/list")
    public TableDataInfo list(AccountTransfer accountTransfer)
    {
        startPage();
        List<AccountTransfer> list = accountTransferService.selectAccountTransferList(accountTransfer);
        return getDataTable(list);
    }

    /**
     * 导出资金划转管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:transfer:export')")
    @Log(title = "资金划转管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AccountTransfer accountTransfer)
    {
        List<AccountTransfer> list = accountTransferService.selectAccountTransferList(accountTransfer);
        ExcelUtil<AccountTransfer> util = new ExcelUtil<AccountTransfer>(AccountTransfer.class);
        return util.exportExcel(list, "transfer");
    }

    /**
     * 获取资金划转管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:transfer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(accountTransferService.selectAccountTransferById(id));
    }

    /**
     * 新增资金划转管理
     */
    @PreAuthorize("@ss.hasPermi('system:transfer:add')")
    @Log(title = "资金划转管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AccountTransfer accountTransfer)
    {
        return toAjax(accountTransferService.insertAccountTransfer(accountTransfer));
    }

    /**
     * 修改资金划转管理
     */
    @PreAuthorize("@ss.hasPermi('system:transfer:edit')")
    @Log(title = "资金划转管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AccountTransfer accountTransfer)
    {
        return toAjax(accountTransferService.updateAccountTransfer(accountTransfer));
    }

    /**
     * 删除资金划转管理
     */
    @PreAuthorize("@ss.hasPermi('system:transfer:remove')")
    @Log(title = "资金划转管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(accountTransferService.deleteAccountTransferByIds(ids));
    }
}
