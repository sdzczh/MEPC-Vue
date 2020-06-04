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
import com.ruoyi.project.system.domain.CoinManage;
import com.ruoyi.project.system.service.ICoinManageService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 币种管理Controller
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@RestController
@RequestMapping("/system/coinManage")
public class CoinManageController extends BaseController
{
    @Autowired
    private ICoinManageService coinManageService;

    /**
     * 查询币种管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:coinManage:list')")
    @GetMapping("/list")
    public TableDataInfo list(CoinManage coinManage)
    {
        startPage();
        List<CoinManage> list = coinManageService.selectCoinManageList(coinManage);
        return getDataTable(list);
    }

    /**
     * 导出币种管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:coinManage:export')")
    @Log(title = "币种管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CoinManage coinManage)
    {
        List<CoinManage> list = coinManageService.selectCoinManageList(coinManage);
        ExcelUtil<CoinManage> util = new ExcelUtil<CoinManage>(CoinManage.class);
        return util.exportExcel(list, "coinManage");
    }

    /**
     * 获取币种管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:coinManage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(coinManageService.selectCoinManageById(id));
    }

    /**
     * 新增币种管理
     */
    @PreAuthorize("@ss.hasPermi('system:coinManage:add')")
    @Log(title = "币种管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CoinManage coinManage)
    {
        return toAjax(coinManageService.insertCoinManage(coinManage));
    }

    /**
     * 修改币种管理
     */
    @PreAuthorize("@ss.hasPermi('system:coinManage:edit')")
    @Log(title = "币种管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CoinManage coinManage)
    {
        return toAjax(coinManageService.updateCoinManage(coinManage));
    }

    /**
     * 删除币种管理
     */
    @PreAuthorize("@ss.hasPermi('system:coinManage:remove')")
    @Log(title = "币种管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(coinManageService.deleteCoinManageByIds(ids));
    }
}
