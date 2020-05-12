package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.NoticeMangerMapper;
import com.ruoyi.project.system.domain.NoticeManger;
import com.ruoyi.project.system.service.INoticeMangerService;

/**
 * 公告Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@Service
public class NoticeMangerServiceImpl implements INoticeMangerService 
{
    @Autowired
    private NoticeMangerMapper noticeMangerMapper;

    /**
     * 查询公告
     * 
     * @param id 公告ID
     * @return 公告
     */
    @Override
    public NoticeManger selectNoticeMangerById(Long id)
    {
        return noticeMangerMapper.selectNoticeMangerById(id);
    }

    /**
     * 查询公告列表
     * 
     * @param noticeManger 公告
     * @return 公告
     */
    @Override
    public List<NoticeManger> selectNoticeMangerList(NoticeManger noticeManger)
    {
        return noticeMangerMapper.selectNoticeMangerList(noticeManger);
    }

    /**
     * 新增公告
     * 
     * @param noticeManger 公告
     * @return 结果
     */
    @Override
    public int insertNoticeManger(NoticeManger noticeManger)
    {
        noticeManger.setCreateTime(DateUtils.getNowDate());
        return noticeMangerMapper.insertNoticeManger(noticeManger);
    }

    /**
     * 修改公告
     * 
     * @param noticeManger 公告
     * @return 结果
     */
    @Override
    public int updateNoticeManger(NoticeManger noticeManger)
    {
        noticeManger.setUpdateTime(DateUtils.getNowDate());
        return noticeMangerMapper.updateNoticeManger(noticeManger);
    }

    /**
     * 批量删除公告
     * 
     * @param ids 需要删除的公告ID
     * @return 结果
     */
    @Override
    public int deleteNoticeMangerByIds(Long[] ids)
    {
        return noticeMangerMapper.deleteNoticeMangerByIds(ids);
    }

    /**
     * 删除公告信息
     * 
     * @param id 公告ID
     * @return 结果
     */
    @Override
    public int deleteNoticeMangerById(Long id)
    {
        return noticeMangerMapper.deleteNoticeMangerById(id);
    }
}
