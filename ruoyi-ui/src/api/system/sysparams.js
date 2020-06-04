import request from '@/utils/request'

// 查询系统参数配置列表
export function listSysparams(query) {
  return request({
    url: '/system/sysparams/list',
    method: 'get',
    params: query
  })
}

// 查询系统参数配置详细
export function getSysparams(id) {
  return request({
    url: '/system/sysparams/' + id,
    method: 'get'
  })
}

// 新增系统参数配置
export function addSysparams(data) {
  return request({
    url: '/system/sysparams',
    method: 'post',
    data: data
  })
}

// 修改系统参数配置
export function updateSysparams(data) {
  return request({
    url: '/system/sysparams',
    method: 'put',
    data: data
  })
}

// 删除系统参数配置
export function delSysparams(id) {
  return request({
    url: '/system/sysparams/' + id,
    method: 'delete'
  })
}

// 导出系统参数配置
export function exportSysparams(query) {
  return request({
    url: '/system/sysparams/export',
    method: 'get',
    params: query
  })
}