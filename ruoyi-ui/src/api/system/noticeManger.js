import request from '@/utils/request'

// 查询公告列表
export function listNoticeManger(query) {
  return request({
    url: '/system/noticeManger/list',
    method: 'get',
    params: query
  })
}

// 查询公告详细
export function getNoticeManger(id) {
  return request({
    url: '/system/noticeManger/' + id,
    method: 'get'
  })
}

// 新增公告
export function addNoticeManger(data) {
  return request({
    url: '/system/noticeManger',
    method: 'post',
    data: data
  })
}

// 修改公告
export function updateNoticeManger(data) {
  return request({
    url: '/system/noticeManger',
    method: 'put',
    data: data
  })
}

// 删除公告
export function delNoticeManger(id) {
  return request({
    url: '/system/noticeManger/' + id,
    method: 'delete'
  })
}

// 导出公告
export function exportNoticeManger(query) {
  return request({
    url: '/system/noticeManger/export',
    method: 'get',
    params: query
  })
}