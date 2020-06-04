import request from '@/utils/request'

// 查询法币订单管理列表
export function listOrderTaker(query) {
  return request({
    url: '/system/orderTaker/list',
    method: 'get',
    params: query
  })
}

// 查询法币订单管理详细
export function getOrderTaker(id) {
  return request({
    url: '/system/orderTaker/' + id,
    method: 'get'
  })
}

// 新增法币订单管理
export function addOrderTaker(data) {
  return request({
    url: '/system/orderTaker',
    method: 'post',
    data: data
  })
}

// 修改法币订单管理
export function updateOrderTaker(data) {
  return request({
    url: '/system/orderTaker',
    method: 'put',
    data: data
  })
}

// 删除法币订单管理
export function delOrderTaker(id) {
  return request({
    url: '/system/orderTaker/' + id,
    method: 'delete'
  })
}

// 导出法币订单管理
export function exportOrderTaker(query) {
  return request({
    url: '/system/orderTaker/export',
    method: 'get',
    params: query
  })
}