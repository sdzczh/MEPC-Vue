import request from '@/utils/request'

// 查询矿池记录列表
export function listBuyingRecord(query) {
  return request({
    url: '/system/buyingRecord/list',
    method: 'get',
    params: query
  })
}

// 查询矿池记录详细
export function getBuyingRecord(id) {
  return request({
    url: '/system/buyingRecord/' + id,
    method: 'get'
  })
}

// 新增矿池记录
export function addBuyingRecord(data) {
  return request({
    url: '/system/buyingRecord',
    method: 'post',
    data: data
  })
}

// 修改矿池记录
export function updateBuyingRecord(data) {
  return request({
    url: '/system/buyingRecord',
    method: 'put',
    data: data
  })
}

// 删除矿池记录
export function delBuyingRecord(id) {
  return request({
    url: '/system/buyingRecord/' + id,
    method: 'delete'
  })
}

// 导出矿池记录
export function exportBuyingRecord(query) {
  return request({
    url: '/system/buyingRecord/export',
    method: 'get',
    params: query
  })
}