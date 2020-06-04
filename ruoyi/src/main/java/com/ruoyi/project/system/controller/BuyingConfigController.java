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
import com.ruoyi.project.system.domain.BuyingConfig;
import com.ruoyi.project.system.service.IBuyingConfigService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 矿池配置Controller
 * 
 * @author ruoyi
 * @date 2020-05-11
 */
@RestController
@RequestMapping("/system/buyingConfig")
public class BuyingConfigController extends BaseController
{
    @Autowired
    private IBuyingConfigService buyingConfigService;

    /**
     * 查询矿池配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:buyingConfig:list')")
    @GetMapping("/list")
    public TableDataInfo list(BuyingConfig buyingConfig)
    {
        startPage();
        List<BuyingConfig> list = buyingConfigService.selectBuyingConfigList(buyingConfig);
        return getDataTable(list);
    }

    /**
     * 导出矿池配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:buyingConfig:export')")
    @Log(title = "矿池配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BuyingConfig buyingConfig)
    {
        List<BuyingConfig> list = buyingConfigService.selectBuyingConfigList(buyingConfig);
        ExcelUtil<BuyingConfig> util = new ExcelUtil<BuyingConfig>(BuyingConfig.class);
        return util.exportExcel(list, "buyingConfig");
    }

    /**
     * 获取矿池配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:buyingConfig:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(buyingConfigService.selectBuyingConfigById(id));
    }

    /**
     * 新增矿池配置
     */
    @PreAuthorize("@ss.hasPermi('system:buyingConfig:add')")
    @Log(title = "矿池配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BuyingConfig buyingConfig)
    {
        return toAjax(buyingConfigService.insertBuyingConfig(buyingConfig));
    }

    /**
     * 修改矿池配置
     */
    @PreAuthorize("@ss.hasPermi('system:buyingConfig:edit')")
    @Log(title = "矿池配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BuyingConfig buyingConfig)
    {
        return toAjax(buyingConfigService.updateBuyingConfig(buyingConfig));
    }

    /**
     * 删除矿池配置
     */
    @PreAuthorize("@ss.hasPermi('system:buyingConfig:remove')")
    @Log(title = "矿池配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(buyingConfigService.deleteBuyingConfigByIds(ids));
    }
}
