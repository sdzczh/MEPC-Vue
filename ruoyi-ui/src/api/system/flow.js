import request from '@/utils/request'

// 查询流水记录列表
export function listFlow(query) {
  return request({
    url: '/system/flow/list',
    method: 'get',
    params: query
  })
}

// 查询流水记录详细
export function getFlow(id) {
  return request({
    url: '/system/flow/' + id,
    method: 'get'
  })
}

// 新增流水记录
export function addFlow(data) {
  return request({
    url: '/system/flow',
    method: 'post',
    data: data
  })
}

// 修改流水记录
export function updateFlow(data) {
  return request({
    url: '/system/flow',
    method: 'put',
    data: data
  })
}

// 删除流水记录
export function delFlow(id) {
  return request({
    url: '/system/flow/' + id,
    method: 'delete'
  })
}

// 导出流水记录
export function exportFlow(query) {
  return request({
    url: '/system/flow/export',
    method: 'get',
    params: query
  })
}