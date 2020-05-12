import request from '@/utils/request'

// 查询币种管理列表
export function listCoinManage(query) {
  return request({
    url: '/system/coinManage/list',
    method: 'get',
    params: query
  })
}

// 查询币种管理详细
export function getCoinManage(id) {
  return request({
    url: '/system/coinManage/' + id,
    method: 'get'
  })
}

// 新增币种管理
export function addCoinManage(data) {
  return request({
    url: '/system/coinManage',
    method: 'post',
    data: data
  })
}

// 修改币种管理
export function updateCoinManage(data) {
  return request({
    url: '/system/coinManage',
    method: 'put',
    data: data
  })
}

// 删除币种管理
export function delCoinManage(id) {
  return request({
    url: '/system/coinManage/' + id,
    method: 'delete'
  })
}

// 导出币种管理
export function exportCoinManage(query) {
  return request({
    url: '/system/coinManage/export',
    method: 'get',
    params: query
  })
}