package com.ruoyi.project.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.IdcardValidateMapper;
import com.ruoyi.project.system.domain.IdcardValidate;
import com.ruoyi.project.system.service.IIdcardValidateService;

/**
 * 实名认证记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-12
 */
@Service
public class IdcardValidateServiceImpl implements IIdcardValidateService 
{
    @Autowired
    private IdcardValidateMapper idcardValidateMapper;

    /**
     * 查询实名认证记录
     * 
     * @param id 实名认证记录ID
     * @return 实名认证记录
     */
    @Override
    public IdcardValidate selectIdcardValidateById(Long id)
    {
        return idcardValidateMapper.selectIdcardValidateById(id);
    }

    /**
     * 查询实名认证记录列表
     * 
     * @param idcardValidate 实名认证记录
     * @return 实名认证记录
     */
    @Override
    public List<IdcardValidate> selectIdcardValidateList(IdcardValidate idcardValidate)
    {
        return idcardValidateMapper.selectIdcardValidateList(idcardValidate);
    }

    /**
     * 新增实名认证记录
     * 
     * @param idcardValidate 实名认证记录
     * @return 结果
     */
    @Override
    public int insertIdcardValidate(IdcardValidate idcardValidate)
    {
        idcardValidate.setCreateTime(DateUtils.getNowDate());
        return idcardValidateMapper.insertIdcardValidate(idcardValidate);
    }

    /**
     * 修改实名认证记录
     * 
     * @param idcardValidate 实名认证记录
     * @return 结果
     */
    @Override
    public int updateIdcardValidate(IdcardValidate idcardValidate)
    {
        idcardValidate.setUpdateTime(DateUtils.getNowDate());
        return idcardValidateMapper.updateIdcardValidate(idcardValidate);
    }

    /**
     * 批量删除实名认证记录
     * 
     * @param ids 需要删除的实名认证记录ID
     * @return 结果
     */
    @Override
    public int deleteIdcardValidateByIds(Long[] ids)
    {
        return idcardValidateMapper.deleteIdcardValidateByIds(ids);
    }

    /**
     * 删除实名认证记录信息
     * 
     * @param id 实名认证记录ID
     * @return 结果
     */
    @Override
    public int deleteIdcardValidateById(Long id)
    {
        return idcardValidateMapper.deleteIdcardValidateById(id);
    }

    @Override
    public List<Map<String, Object>> selectIdcardValidateLists(Map<String, Object> param) {
        return idcardValidateMapper.selectIdcardValidateLists(param);

    }
}
