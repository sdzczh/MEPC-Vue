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
import com.ruoyi.project.system.domain.OrderTaker;
import com.ruoyi.project.system.service.IOrderTakerService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 法币订单管理Controller
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@RestController
@RequestMapping("/system/orderTaker")
public class OrderTakerController extends BaseController
{
    @Autowired
    private IOrderTakerService orderTakerService;

    /**
     * 查询法币订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:orderTaker:list')")
    @GetMapping("/list")
    public TableDataInfo list(OrderTaker orderTaker, String phone)
    {
        Map<String, Object> param = new HashMap<>();
        param.put("phone", phone);
        param.put("type", orderTaker.getType());
        param.put("coinType", orderTaker.getCoinType());
        param.put("orderNum", orderTaker.getOrderNum());
        param.put("state", orderTaker.getState());
        startPage();
        List<Map<String, Object>> list = orderTakerService.selectOrderTakerLists(param);
        return getDataTable(list);
    }

    /**
     * 导出法币订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:orderTaker:export')")
    @Log(title = "法币订单管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(OrderTaker orderTaker)
    {
        List<OrderTaker> list = orderTakerService.selectOrderTakerList(orderTaker);
        ExcelUtil<OrderTaker> util = new ExcelUtil<OrderTaker>(OrderTaker.class);
        return util.exportExcel(list, "orderTaker");
    }

    /**
     * 获取法币订单管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:orderTaker:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(orderTakerService.selectOrderTakerById(id));
    }

    /**
     * 新增法币订单管理
     */
    @PreAuthorize("@ss.hasPermi('system:orderTaker:add')")
    @Log(title = "法币订单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderTaker orderTaker)
    {
        return toAjax(orderTakerService.insertOrderTaker(orderTaker));
    }

    /**
     * 修改法币订单管理
     */
    @PreAuthorize("@ss.hasPermi('system:orderTaker:edit')")
    @Log(title = "法币订单管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrderTaker orderTaker)
    {
        return toAjax(orderTakerService.updateOrderTaker(orderTaker));
    }

    /**
     * 删除法币订单管理
     */
    @PreAuthorize("@ss.hasPermi('system:orderTaker:remove')")
    @Log(title = "法币订单管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(orderTakerService.deleteOrderTakerByIds(ids));
    }
}
