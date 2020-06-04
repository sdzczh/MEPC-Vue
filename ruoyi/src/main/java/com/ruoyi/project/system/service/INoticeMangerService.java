package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.NoticeManger;

/**
 * 公告Service接口
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public interface INoticeMangerService 
{
    /**
     * 查询公告
     * 
     * @param id 公告ID
     * @return 公告
     */
    public NoticeManger selectNoticeMangerById(Long id);

    /**
     * 查询公告列表
     * 
     * @param noticeManger 公告
     * @return 公告集合
     */
    public List<NoticeManger> selectNoticeMangerList(NoticeManger noticeManger);

    /**
     * 新增公告
     * 
     * @param noticeManger 公告
     * @return 结果
     */
    public int insertNoticeManger(NoticeManger noticeManger);

    /**
     * 修改公告
     * 
     * @param noticeManger 公告
     * @return 结果
     */
    public int updateNoticeManger(NoticeManger noticeManger);

    /**
     * 批量删除公告
     * 
     * @param ids 需要删除的公告ID
     * @return 结果
     */
    public int deleteNoticeMangerByIds(Long[] ids);

    /**
     * 删除公告信息
     * 
     * @param id 公告ID
     * @return 结果
     */
    public int deleteNoticeMangerById(Long id);
}
