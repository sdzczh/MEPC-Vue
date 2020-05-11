import request from '@/utils/request'

// 查询矿池配置列表
export function listBuyingConfig(query) {
  return request({
    url: '/system/buyingConfig/list',
    method: 'get',
    params: query
  })
}

// 查询矿池配置详细
export function getBuyingConfig(id) {
  return request({
    url: '/system/buyingConfig/' + id,
    method: 'get'
  })
}

// 新增矿池配置
export function addBuyingConfig(data) {
  return request({
    url: '/system/buyingConfig',
    method: 'post',
    data: data
  })
}

// 修改矿池配置
export function updateBuyingConfig(data) {
  return request({
    url: '/system/buyingConfig',
    method: 'put',
    data: data
  })
}

// 删除矿池配置
export function delBuyingConfig(id) {
  return request({
    url: '/system/buyingConfig/' + id,
    method: 'delete'
  })
}

// 导出矿池配置
export function exportBuyingConfig(query) {
  return request({
    url: '/system/buyingConfig/export',
    method: 'get',
    params: query
  })
}