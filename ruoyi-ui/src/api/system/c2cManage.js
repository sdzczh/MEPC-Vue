import request from '@/utils/request'

// 查询法币交易管理列表
export function listC2cManage(query) {
  return request({
    url: '/system/c2cManage/list',
    method: 'get',
    params: query
  })
}

// 查询法币交易管理详细
export function getC2cManage(id) {
  return request({
    url: '/system/c2cManage/' + id,
    method: 'get'
  })
}

// 新增法币交易管理
export function addC2cManage(data) {
  return request({
    url: '/system/c2cManage',
    method: 'post',
    data: data
  })
}

// 修改法币交易管理
export function updateC2cManage(data) {
  return request({
    url: '/system/c2cManage',
    method: 'put',
    data: data
  })
}

// 删除法币交易管理
export function delC2cManage(id) {
  return request({
    url: '/system/c2cManage/' + id,
    method: 'delete'
  })
}

// 导出法币交易管理
export function exportC2cManage(query) {
  return request({
    url: '/system/c2cManage/export',
    method: 'get',
    params: query
  })
}