package com.ruoyi.project.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.OrderTakerMapper;
import com.ruoyi.project.system.domain.OrderTaker;
import com.ruoyi.project.system.service.IOrderTakerService;

/**
 * 法币订单管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@Service
public class OrderTakerServiceImpl implements IOrderTakerService 
{
    @Autowired
    private OrderTakerMapper orderTakerMapper;

    /**
     * 查询法币订单管理
     * 
     * @param id 法币订单管理ID
     * @return 法币订单管理
     */
    @Override
    public OrderTaker selectOrderTakerById(Long id)
    {
        return orderTakerMapper.selectOrderTakerById(id);
    }

    /**
     * 查询法币订单管理列表
     * 
     * @param orderTaker 法币订单管理
     * @return 法币订单管理
     */
    @Override
    public List<OrderTaker> selectOrderTakerList(OrderTaker orderTaker)
    {
        return orderTakerMapper.selectOrderTakerList(orderTaker);
    }

    /**
     * 新增法币订单管理
     * 
     * @param orderTaker 法币订单管理
     * @return 结果
     */
    @Override
    public int insertOrderTaker(OrderTaker orderTaker)
    {
        orderTaker.setCreateTime(DateUtils.getNowDate());
        return orderTakerMapper.insertOrderTaker(orderTaker);
    }

    /**
     * 修改法币订单管理
     * 
     * @param orderTaker 法币订单管理
     * @return 结果
     */
    @Override
    public int updateOrderTaker(OrderTaker orderTaker)
    {
        orderTaker.setUpdateTime(DateUtils.getNowDate());
        return orderTakerMapper.updateOrderTaker(orderTaker);
    }

    /**
     * 批量删除法币订单管理
     * 
     * @param ids 需要删除的法币订单管理ID
     * @return 结果
     */
    @Override
    public int deleteOrderTakerByIds(Long[] ids)
    {
        return orderTakerMapper.deleteOrderTakerByIds(ids);
    }

    @Override
    public List<Map<String, Object>> selectOrderTakerLists(Map<String, Object> param) {
        return orderTakerMapper.selectOrderTakerLists(param);
    }

    /**
     * 删除法币订单管理信息
     * 
     * @param id 法币订单管理ID
     * @return 结果
     */
    @Override
    public int deleteOrderTakerById(Long id)
    {
        return orderTakerMapper.deleteOrderTakerById(id);
    }
}
