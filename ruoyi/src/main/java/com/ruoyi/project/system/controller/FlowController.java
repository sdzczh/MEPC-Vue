package com.ruoyi.project.system.controller;

import java.util.HashMap;
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
import com.ruoyi.project.system.domain.Flow;
import com.ruoyi.project.system.service.IFlowService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 流水记录Controller
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@RestController
@RequestMapping("/system/flow")
public class FlowController extends BaseController
{
    @Autowired
    private IFlowService flowService;

    /**
     * 查询流水记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:flow:list')")
    @GetMapping("/list")
    public TableDataInfo list(Flow flow, String phone)
    {
        Map<String, Object> param = new HashMap();
        param.put("phone", phone);
        param.put("id", flow.getId());
        param.put("operType", flow.getOperType());
        param.put("flows", flow.getFlows());
        param.put("accountType", flow.getAccountType());
        param.put("coinType", flow.getCoinType());
        startPage();
        List<Map<String, Object>> list = flowService.selectFlowLists(param);
        return getDataTable(list);
    }

    /**
     * 导出流水记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:flow:export')")
    @Log(title = "流水记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Flow flow)
    {
        List<Flow> list = flowService.selectFlowList(flow);
        ExcelUtil<Flow> util = new ExcelUtil<Flow>(Flow.class);
        return util.exportExcel(list, "flow");
    }

    /**
     * 获取流水记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:flow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(flowService.selectFlowById(id));
    }

    /**
     * 新增流水记录
     */
    @PreAuthorize("@ss.hasPermi('system:flow:add')")
    @Log(title = "流水记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Flow flow)
    {
        return toAjax(flowService.insertFlow(flow));
    }

    /**
     * 修改流水记录
     */
    @PreAuthorize("@ss.hasPermi('system:flow:edit')")
    @Log(title = "流水记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Flow flow)
    {
        return toAjax(flowService.updateFlow(flow));
    }

    /**
     * 删除流水记录
     */
    @PreAuthorize("@ss.hasPermi('system:flow:remove')")
    @Log(title = "流水记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(flowService.deleteFlowByIds(ids));
    }
}
