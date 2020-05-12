import request from '@/utils/request'

// 查询实名认证记录列表
export function listIdcardValidate(query) {
  return request({
    url: '/system/idcardValidate/list',
    method: 'get',
    params: query
  })
}

// 查询实名认证记录详细
export function getIdcardValidate(id) {
  return request({
    url: '/system/idcardValidate/' + id,
    method: 'get'
  })
}

// 新增实名认证记录
export function addIdcardValidate(data) {
  return request({
    url: '/system/idcardValidate',
    method: 'post',
    data: data
  })
}

// 修改实名认证记录
export function updateIdcardValidate(data) {
  return request({
    url: '/system/idcardValidate',
    method: 'put',
    data: data
  })
}

// 删除实名认证记录
export function delIdcardValidate(id) {
  return request({
    url: '/system/idcardValidate/' + id,
    method: 'delete'
  })
}

// 导出实名认证记录
export function exportIdcardValidate(query) {
  return request({
    url: '/system/idcardValidate/export',
    method: 'get',
    params: query
  })
}