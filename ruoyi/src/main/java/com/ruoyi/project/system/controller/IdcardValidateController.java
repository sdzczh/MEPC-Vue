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
import com.ruoyi.project.system.domain.IdcardValidate;
import com.ruoyi.project.system.service.IIdcardValidateService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 实名认证记录Controller
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@RestController
@RequestMapping("/system/idcardValidate")
public class IdcardValidateController extends BaseController
{
    @Autowired
    private IIdcardValidateService idcardValidateService;

    /**
     * 查询实名认证记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:idcardValidate:list')")
    @GetMapping("/list")
    public TableDataInfo list(IdcardValidate idcardValidate, String phone)
    {
        Map<String, Object> param = new HashMap<>();
        param.put("phone", phone);
        param.put("name", idcardValidate.getName());
        param.put("identificationnumber", idcardValidate.getIdentificationnumber());
        param.put("state", idcardValidate.getState());
        param.put("type", idcardValidate.getType());
        startPage();
        List<Map<String, Object>> list = idcardValidateService.selectIdcardValidateLists(param);
        return getDataTable(list);
    }

    /**
     * 导出实名认证记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:idcardValidate:export')")
    @Log(title = "实名认证记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(IdcardValidate idcardValidate)
    {
        List<IdcardValidate> list = idcardValidateService.selectIdcardValidateList(idcardValidate);
        ExcelUtil<IdcardValidate> util = new ExcelUtil<IdcardValidate>(IdcardValidate.class);
        return util.exportExcel(list, "idcardValidate");
    }

    /**
     * 获取实名认证记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:idcardValidate:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(idcardValidateService.selectIdcardValidateById(id));
    }

    /**
     * 新增实名认证记录
     */
    @PreAuthorize("@ss.hasPermi('system:idcardValidate:add')")
    @Log(title = "实名认证记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody IdcardValidate idcardValidate)
    {
        return toAjax(idcardValidateService.insertIdcardValidate(idcardValidate));
    }

    /**
     * 修改实名认证记录
     */
    @PreAuthorize("@ss.hasPermi('system:idcardValidate:edit')")
    @Log(title = "实名认证记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody IdcardValidate idcardValidate)
    {
        return toAjax(idcardValidateService.updateIdcardValidate(idcardValidate));
    }

    /**
     * 删除实名认证记录
     */
    @PreAuthorize("@ss.hasPermi('system:idcardValidate:remove')")
    @Log(title = "实名认证记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(idcardValidateService.deleteIdcardValidateByIds(ids));
    }
}
