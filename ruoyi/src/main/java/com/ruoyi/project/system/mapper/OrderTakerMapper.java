package com.ruoyi.project.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.domain.OrderTaker;

/**
 * 法币订单管理Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
public interface OrderTakerMapper 
{
    /**
     * 查询法币订单管理
     * 
     * @param id 法币订单管理ID
     * @return 法币订单管理
     */
    public OrderTaker selectOrderTakerById(Long id);

    /**
     * 查询法币订单管理列表
     * 
     * @param orderTaker 法币订单管理
     * @return 法币订单管理集合
     */
    public List<OrderTaker> selectOrderTakerList(OrderTaker orderTaker);

    /**
     * 新增法币订单管理
     * 
     * @param orderTaker 法币订单管理
     * @return 结果
     */
    public int insertOrderTaker(OrderTaker orderTaker);

    /**
     * 修改法币订单管理
     * 
     * @param orderTaker 法币订单管理
     * @return 结果
     */
    public int updateOrderTaker(OrderTaker orderTaker);

    /**
     * 删除法币订单管理
     * 
     * @param id 法币订单管理ID
     * @return 结果
     */
    public int deleteOrderTakerById(Long id);

    /**
     * 批量删除法币订单管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderTakerByIds(Long[] ids);

    List<Map<String, Object>> selectOrderTakerLists(Map<String, Object> param);
}
