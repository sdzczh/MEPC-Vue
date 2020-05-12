package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.FlowMapper;
import com.ruoyi.project.system.domain.Flow;
import com.ruoyi.project.system.service.IFlowService;

/**
 * 流水记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@Service
public class FlowServiceImpl implements IFlowService 
{
    @Autowired
    private FlowMapper flowMapper;

    /**
     * 查询流水记录
     * 
     * @param id 流水记录ID
     * @return 流水记录
     */
    @Override
    public Flow selectFlowById(Long id)
    {
        return flowMapper.selectFlowById(id);
    }

    /**
     * 查询流水记录列表
     * 
     * @param flow 流水记录
     * @return 流水记录
     */
    @Override
    public List<Flow> selectFlowList(Flow flow)
    {
        return flowMapper.selectFlowList(flow);
    }

    /**
     * 新增流水记录
     * 
     * @param flow 流水记录
     * @return 结果
     */
    @Override
    public int insertFlow(Flow flow)
    {
        flow.setCreateTime(DateUtils.getNowDate());
        return flowMapper.insertFlow(flow);
    }

    /**
     * 修改流水记录
     * 
     * @param flow 流水记录
     * @return 结果
     */
    @Override
    public int updateFlow(Flow flow)
    {
        flow.setUpdateTime(DateUtils.getNowDate());
        return flowMapper.updateFlow(flow);
    }

    /**
     * 批量删除流水记录
     * 
     * @param ids 需要删除的流水记录ID
     * @return 结果
     */
    @Override
    public int deleteFlowByIds(Long[] ids)
    {
        return flowMapper.deleteFlowByIds(ids);
    }

    /**
     * 删除流水记录信息
     * 
     * @param id 流水记录ID
     * @return 结果
     */
    @Override
    public int deleteFlowById(Long id)
    {
        return flowMapper.deleteFlowById(id);
    }
}
