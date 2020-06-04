import request from '@/utils/request'

// 查询资金划转管理列表
export function listTransfer(query) {
  return request({
    url: '/system/transfer/list',
    method: 'get',
    params: query
  })
}

// 查询资金划转管理详细
export function getTransfer(id) {
  return request({
    url: '/system/transfer/' + id,
    method: 'get'
  })
}

// 新增资金划转管理
export function addTransfer(data) {
  return request({
    url: '/system/transfer',
    method: 'post',
    data: data
  })
}

// 修改资金划转管理
export function updateTransfer(data) {
  return request({
    url: '/system/transfer',
    method: 'put',
    data: data
  })
}

// 删除资金划转管理
export function delTransfer(id) {
  return request({
    url: '/system/transfer/' + id,
    method: 'delete'
  })
}

// 导出资金划转管理
export function exportTransfer(query) {
  return request({
    url: '/system/transfer/export',
    method: 'get',
    params: query
  })
}