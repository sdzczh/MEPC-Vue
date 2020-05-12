import request from '@/utils/request'

// 查询提现管理列表
export function listWithdraw(query) {
  return request({
    url: '/system/withdraw/list',
    method: 'get',
    params: query
  })
}

// 查询提现管理详细
export function getWithdraw(id) {
  return request({
    url: '/system/withdraw/' + id,
    method: 'get'
  })
}

// 新增提现管理
export function addWithdraw(data) {
  return request({
    url: '/system/withdraw',
    method: 'post',
    data: data
  })
}

// 修改提现管理
export function updateWithdraw(data) {
  return request({
    url: '/system/withdraw',
    method: 'put',
    data: data
  })
}

// 删除提现管理
export function delWithdraw(id) {
  return request({
    url: '/system/withdraw/' + id,
    method: 'delete'
  })
}

// 导出提现管理
export function exportWithdraw(query) {
  return request({
    url: '/system/withdraw/export',
    method: 'get',
    params: query
  })
}