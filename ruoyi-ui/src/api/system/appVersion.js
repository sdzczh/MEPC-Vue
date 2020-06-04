import request from '@/utils/request'

// 查询版本控制列表
export function listAppVersion(query) {
  return request({
    url: '/system/appVersion/list',
    method: 'get',
    params: query
  })
}

// 查询版本控制详细
export function getAppVersion(id) {
  return request({
    url: '/system/appVersion/' + id,
    method: 'get'
  })
}

// 新增版本控制
export function addAppVersion(data) {
  return request({
    url: '/system/appVersion',
    method: 'post',
    data: data
  })
}

// 修改版本控制
export function updateAppVersion(data) {
  return request({
    url: '/system/appVersion',
    method: 'put',
    data: data
  })
}

// 删除版本控制
export function delAppVersion(id) {
  return request({
    url: '/system/appVersion/' + id,
    method: 'delete'
  })
}

// 导出版本控制
export function exportAppVersion(query) {
  return request({
    url: '/system/appVersion/export',
    method: 'get',
    params: query
  })
}