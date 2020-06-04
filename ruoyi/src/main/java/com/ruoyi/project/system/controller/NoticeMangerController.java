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
import com.ruoyi.project.system.domain.NoticeManger;
import com.ruoyi.project.system.service.INoticeMangerService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 公告Controller
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@RestController
@RequestMapping("/system/noticeManger")
public class NoticeMangerController extends BaseController
{
    @Autowired
    private INoticeMangerService noticeMangerService;

    /**
     * 查询公告列表
     */
    @PreAuthorize("@ss.hasPermi('system:noticeManger:list')")
    @GetMapping("/list")
    public TableDataInfo list(NoticeManger noticeManger)
    {
        startPage();
        List<NoticeManger> list = noticeMangerService.selectNoticeMangerList(noticeManger);
        return getDataTable(list);
    }

    /**
     * 导出公告列表
     */
    @PreAuthorize("@ss.hasPermi('system:noticeManger:export')")
    @Log(title = "公告", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(NoticeManger noticeManger)
    {
        List<NoticeManger> list = noticeMangerService.selectNoticeMangerList(noticeManger);
        ExcelUtil<NoticeManger> util = new ExcelUtil<NoticeManger>(NoticeManger.class);
        return util.exportExcel(list, "noticeManger");
    }

    /**
     * 获取公告详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:noticeManger:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(noticeMangerService.selectNoticeMangerById(id));
    }

    /**
     * 新增公告
     */
    @PreAuthorize("@ss.hasPermi('system:noticeManger:add')")
    @Log(title = "公告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NoticeManger noticeManger)
    {
        return toAjax(noticeMangerService.insertNoticeManger(noticeManger));
    }

    /**
     * 修改公告
     */
    @PreAuthorize("@ss.hasPermi('system:noticeManger:edit')")
    @Log(title = "公告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NoticeManger noticeManger)
    {
        return toAjax(noticeMangerService.updateNoticeManger(noticeManger));
    }

    /**
     * 删除公告
     */
    @PreAuthorize("@ss.hasPermi('system:noticeManger:remove')")
    @Log(title = "公告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(noticeMangerService.deleteNoticeMangerByIds(ids));
    }
}
