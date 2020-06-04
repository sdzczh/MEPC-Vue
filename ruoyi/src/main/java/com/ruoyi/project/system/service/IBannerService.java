package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.Banner;

/**
 * Banner管理Service接口
 * 
 * @author ruoyi
 * @date 2020-06-04
 */
public interface IBannerService 
{
    /**
     * 查询Banner管理
     * 
     * @param id Banner管理ID
     * @return Banner管理
     */
    public Banner selectBannerById(Long id);

    /**
     * 查询Banner管理列表
     * 
     * @param banner Banner管理
     * @return Banner管理集合
     */
    public List<Banner> selectBannerList(Banner banner);

    /**
     * 新增Banner管理
     * 
     * @param banner Banner管理
     * @return 结果
     */
    public int insertBanner(Banner banner);

    /**
     * 修改Banner管理
     * 
     * @param banner Banner管理
     * @return 结果
     */
    public int updateBanner(Banner banner);

    /**
     * 批量删除Banner管理
     * 
     * @param ids 需要删除的Banner管理ID
     * @return 结果
     */
    public int deleteBannerByIds(Long[] ids);

    /**
     * 删除Banner管理信息
     * 
     * @param id Banner管理ID
     * @return 结果
     */
    public int deleteBannerById(Long id);
}
