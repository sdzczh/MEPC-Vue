package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.Flow;

/**
 * 流水记录Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public interface FlowMapper 
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
     * 删除流水记录
     * 
     * @param id 流水记录ID
     * @return 结果
     */
    public int deleteFlowById(Long id);

    /**
     * 批量删除流水记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFlowByIds(Long[] ids);
}
