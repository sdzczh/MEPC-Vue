import request from '@/utils/request'

// 查询矿池配置列表
export function listConfig(query) {
  return request({
    url: '/system/config/list',
    method: 'get',
    params: query
  })
}

// 查询矿池配置详细
export function getConfig(id) {
  return request({
    url: '/system/config/' + id,
    method: 'get'
  })
}

// 新增矿池配置
export function addConfig(data) {
  return request({
    url: '/system/config',
    method: 'post',
    data: data
  })
}

// 修改矿池配置
export function updateConfig(data) {
  return request({
    url: '/system/config',
    method: 'put',
    data: data
  })
}

// 删除矿池配置
export function delConfig(id) {
  return request({
    url: '/system/config/' + id,
    method: 'delete'
  })
}

// 导出矿池配置
export function exportConfig(query) {
  return request({
    url: '/system/config/export',
    method: 'get',
    params: query
  })
}