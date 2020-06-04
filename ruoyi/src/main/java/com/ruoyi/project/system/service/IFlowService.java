package com.ruoyi.project.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.domain.Flow;

/**
 * 流水记录Service接口
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public interface IFlowService 
{
    /**
     * 查询流水记录
     * 
     * @param id 流水记录ID
     * @return 流水记录
     */
    public Flow selectFlowById(Long id);

    /**
     * 查询流水记录列表
     * 
     * @param flow 流水记录
     * @return 流水记录集合
     */
    public List<Flow> selectFlowList(Flow flow);

    /**
     * 新增流水记录
     * 
     * @param flow 流水记录
     * @return 结果
     */
    public int insertFlow(Flow flow);

    /**
     * 修改流水记录
     * 
     * @param flow 流水记录
     * @return 结果
     */
    public int updateFlow(Flow flow);

    /**
     * 批量删除流水记录
     * 
     * @param ids 需要删除的流水记录ID
     * @return 结果
     */
    public int deleteFlowByIds(Long[] ids);

    /**
     * 删除流水记录信息
     * 
     * @param id 流水记录ID
     * @return 结果
     */
    public int deleteFlowById(Long id);

    List<Map<String, Object>> selectFlowLists(Map<String, Object> param);
}
